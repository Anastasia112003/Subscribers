package com.example.subscriber1.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Entity(name = "influencer")
@Table(name = "influencer")
@ToString
public class Influencer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer subsAmount;
    @OneToMany
    private List<Subscriber> subscribers = new ArrayList<>();
    private LocalDateTime lastUpdate;

}
