package com.meteor.ddd.infrastructure.utils.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author 钟宗兵
 * @since 1.0.0
 */
@Component
public class EventPublisher {
    @Resource
    private ApplicationEventPublisher applicationEventPublisher;

    public <T> void publish(BaseEvent<T> event) {
        applicationEventPublisher.publishEvent(event);
    }

    @Async
    public <T> void publishSync(BaseEvent<T> event) {
        applicationEventPublisher.publishEvent(event);
    }
}
