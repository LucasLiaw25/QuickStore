package com.liaw.dev.Order.client;

import com.liaw.dev.Order.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "UserService", url = "http://localhost:8080/api/user")
public interface UserClient {

    @GetMapping("/{userId}")
    UserDTO findUserById(@PathVariable Long userId);

}
