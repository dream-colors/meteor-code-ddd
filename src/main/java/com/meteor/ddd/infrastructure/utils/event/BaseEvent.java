package com.meteor.ddd.infrastructure.utils.event;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

/**
 * @author 钟宗兵
 * @since 1.0.0
 */
@Getter
@Setter
public abstract class BaseEvent<T> extends ApplicationEvent {
    private static final long serialVersionUID = 895628808370649881L;

    protected T data;

    public BaseEvent(T data) {
        super(data);
    }

    public BaseEvent(Object source, T data) {
        super(source);
        this.data = data;
    }

}
