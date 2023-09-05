package com.meteor.ddd.application.event.handler;

import com.meteor.ddd.domain.event.UserLoginEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author 钟宗兵
 * @since 1.0.0
 */
@Slf4j
@Component
public class UserLoginEventHandler implements ApplicationListener<UserLoginEvent> {

    @Override
    public void onApplicationEvent(UserLoginEvent event) {
        // 执行登录后处理，如记录登录记录
        log.info("用户已登录：{}", event.getData().getUserId());
    }
}
