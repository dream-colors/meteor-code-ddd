package com.meteor.ddd.application.event;

import com.meteor.ddd.domain.entity.User;
import com.meteor.ddd.domain.event.UserLoginEvent;
import com.meteor.ddd.infrastructure.utils.event.EventPublisher;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author 钟宗兵
 * @since 1.0.0
 */
@Component
public class UserEventPublisher {
    @Resource
    private EventPublisher eventPublisher;

    public void publishLoginEvent(User user) {
        eventPublisher.publishSync(new UserLoginEvent(this, user));
    }
}
