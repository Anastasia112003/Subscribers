package com.example.subscriber1.repository;

import com.example.subscriber1.model.Influencer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubRepository extends JpaRepository<Influencer,Long> {

}
