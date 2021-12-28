package com.pipiolo.kafka.producer;

import com.pipiolo.kafka.model.Team;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TeamProducer {

    private final KafkaTemplate<String, Team> kafkaTeamTemplate;

    public void async(String topic, Team Team) {
        kafkaTeamTemplate.send(topic, Team);
    }
}

