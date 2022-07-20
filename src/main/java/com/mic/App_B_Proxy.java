package com.mic;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "b")
public interface App_B_Proxy {
    @PostMapping("/b")
    public App_B_ResponseDTO retrieveValue(
            @RequestBody App_B_RequestDTO appBRequestDTO
    );
}
