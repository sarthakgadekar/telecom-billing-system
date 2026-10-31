package com.telefonica.telecom.common.event;

import com.telefonica.telecom.common.dto.DomainEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaEventPublisher {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public KafkaEventPublisher(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    // The original 2-argument method
    public void publish(String topic, DomainEvent<?> event) {
        kafkaTemplate.send(topic, event);
    }

    // ✅ NEW: 3-argument method to match the recharge-service call
    public void publish(String topic, String key, DomainEvent<?> event) {
        // The second string is usually a Kafka message key (e.g., an Order ID)
        // used to ensure messages for the same entity go to the same partition.
        kafkaTemplate.send(topic, key, event);
    }
}