package com.example.subscriber1.service;


import com.example.subscriber1.dto.InfluencerDTO;
import com.example.subscriber1.mapper.SubscriberMapper;
import com.example.subscriber1.model.Influencer;
import com.example.subscriber1.repository.SubRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscribeService {
    private final SubscriberMapper subscriberMapper;
    private final SubRepository subRepository;
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());


    public SubscribeService(SubscriberMapper subscriberMapper, SubRepository subRepository) {
        this.subscriberMapper = subscriberMapper;

        this.subRepository = subRepository;
    }

    @KafkaListener(topics = "managerToSubscriber1")
    public Influencer receiveOrder(InfluencerDTO dto) {
        Influencer influencer = subscriberMapper.toEntity(dto);
        subRepository.save(influencer);
        return influencer;
    }

    @Scheduled(fixedRateString = "${fix.time}")
    public void findUpdate() {
        findAll().forEach(influencer -> {
            String msg = "Update: " + influencer.toString() + " !";
            LOGGER.info(msg);
        });

    }

    public List<Influencer> findAll() {
        return subRepository.findAll();
    }

}
