package com.pipiolo.kafka.consumer;

import com.pipiolo.kafka.model.Team;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class TeamConsumer {

    @KafkaListener(id = "team-listener", topics = "team")
    public void listenTeam(Team team) {
        System.out.println("Team. team=" + team.getName());
    }
}
