package com.meteor.ddd.interfaces.facade;

import com.meteor.ddd.interfaces.dto.UserLoginCmd;
import com.meteor.ddd.interfaces.dto.vo.UserVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

/**
 * @author 钟宗兵
 * @since 1.0.0
 */
//@FeignClient:微服务客户端注解,value:指定微服务的名字,这样就可以使Feign客户端直接找到对应的微服务
//@FeignClient(value = "SPRINGCOULD-PROVIDER-USER")
public interface IUserApi {

    @PostMapping("/api/user/login")
    UserVO login(@RequestBody @Valid UserLoginCmd loginCmd);
}
