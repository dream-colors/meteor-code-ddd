package com.meteor.ddd.domain.event;

import com.meteor.ddd.domain.entity.User;
import com.meteor.ddd.infrastructure.utils.event.BaseEvent;

/**
 * @author 钟宗兵
 * @since 1.0.0
 */
public class UserLoginEvent extends BaseEvent<User> {
    public UserLoginEvent(User data) {
        super("user-event", data);
    }

    public UserLoginEvent(Object source, User data) {
        super(source, data);
    }
}
