package com.pipiolo.kafka.consumer;

import com.pipiolo.kafka.model.Member;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MemberConsumer {

    @KafkaListener(id = "member-listener", topics = "member")
    public void listenMember(Member member) {
        System.out.println("Member. member name=" + member.getName());
    }
}
