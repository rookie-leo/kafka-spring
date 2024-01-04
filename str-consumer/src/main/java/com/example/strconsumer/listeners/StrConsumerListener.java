package com.example.strconsumer.listeners;

import com.example.strconsumer.custom.StrConsumerCustomListener;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class StrConsumerListener {

    @StrConsumerCustomListener(groupId = "group-1")
    public void listener(String message) {
        log.info("Receive message: {}", message);
    }

    @StrConsumerCustomListener(groupId = "group-1")
    public void log(String message) {
        log.info("Log message: {}", message);
    }

    @KafkaListener(groupId = "group-2", containerFactory = "validMessageContainerFactory", topics = "str-topic")
    public void history(String message) {
        log.info("History message: {}", message);
    }
}
