package com.mic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class App_A_Controller {

    @Autowired
    App_B_Proxy appBProxy;

    @PostMapping("/a")
    public App_A_ResponseDTO post(@RequestBody App_A_RequestDTO appARequestDTO) {
        App_B_RequestDTO appBRequestDTO = new App_B_RequestDTO();
        appBRequestDTO.setA("Value from A Request=[" + appARequestDTO.getA() + "]" );
        App_B_ResponseDTO appBResponseDTO = appBProxy.retrieveValue(appBRequestDTO);

        App_A_ResponseDTO appAResponseDTO = new App_A_ResponseDTO();
        appAResponseDTO.setA(appBResponseDTO.getA());
        return appAResponseDTO;
    }
}
