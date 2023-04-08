package com.juliofilizzola.strconsumer.listeners;

import com.juliofilizzola.strconsumer.custom.StrConsumerCustomListener;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class StrConsumerListener {

    @KafkaListener(groupId = "group-1", topics = "str-topic", containerFactory = "concurrentKafkaListenerContainerFactory")
    public void listener(String message) {
        log.info("received message {}", message);
    }

//    @KafkaListener(groupId = "group-1", topics = "str-topic", containerFactory = "concurrentKafkaListenerContainerFactory")
    @StrConsumerCustomListener(topics = "str-topic")
    public void log(String message) {
        log.info("received message {}", message);
    }

    @KafkaListener(groupId = "group-2", topics = "str-topic", containerFactory = "validMessageContainerFactory")
    public void history(String message) {
        log.info("group-2");
        log.info("received message {}", message);
    }
}
