package com.telefonica.telecom.common.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public class DomainEvent<T>
{
    private String eventId;
    private String eventType;
    private String correlationId; // Added to hold the second String argument
    private LocalDateTime timestamp;
    private T payload;

    public DomainEvent()
    {
        this.eventId = UUID.randomUUID().toString();
        this.timestamp = LocalDateTime.now();
    }

    // The missing static factory method causing the error
    public static <T> DomainEvent<T> of(String eventType, String correlationId, T payload)
    {
        DomainEvent<T> event = new DomainEvent<>();
        event.setEventType(eventType);
        event.setCorrelationId(correlationId);
        event.setPayload(payload);
        return event;
    }

    // Getters and Setters
    public String getEventId()
    {
        return eventId;
    }

    public void setEventId(String eventId)
    {
        this.eventId = eventId;
    }

    public String getEventType()
    {
        return eventType;
    }

    public void setEventType(String eventType)
    {
        this.eventType = eventType;
    }

    public String getCorrelationId()
    {
        return correlationId;
    }

    public void setCorrelationId(String correlationId)
    {
        this.correlationId = correlationId;
    }

    public LocalDateTime getTimestamp()
    {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp)
    {
        this.timestamp = timestamp;
    }

    public T getPayload()
    {
        return payload;
    }

    public void setPayload(T payload)
    {
        this.payload = payload;
    }
}