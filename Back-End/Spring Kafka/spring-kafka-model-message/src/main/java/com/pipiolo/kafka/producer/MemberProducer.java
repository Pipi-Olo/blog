package com.pipiolo.kafka.producer;

import com.pipiolo.kafka.model.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberProducer {

    private final KafkaTemplate<String, Member> kafkaMemberTemplate;

    public void async(String topic, Member member) {
        kafkaMemberTemplate.send(topic, member);
    }
}
