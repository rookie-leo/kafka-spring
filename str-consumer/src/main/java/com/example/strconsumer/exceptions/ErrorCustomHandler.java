package com.example.strconsumer.exceptions;

import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.listener.KafkaListenerErrorHandler;
import org.springframework.kafka.listener.ListenerExecutionFailedException;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class ErrorCustomHandler implements KafkaListenerErrorHandler {
    @Override
    public Object handleError(Message<?> message, ListenerExecutionFailedException e) {
        log.info("Capturado erro {}", e.getMessage());
        log.info("Payload da mensagem: {}", message.getPayload());
        log.info("Headers da mensagem: {}", message.getHeaders());
        log.info("Offset da mensagem: {}", message.getHeaders().get("kafka_offset"));
        return null;//Apenas para questões de estudos
    }
}
