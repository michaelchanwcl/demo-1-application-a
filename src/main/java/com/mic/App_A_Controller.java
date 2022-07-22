package com.mic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class App_A_Controller {

    private static final Logger log = LoggerFactory.getLogger(App_A_Controller.class);
    @Autowired
    App_B_Proxy appBProxy;

    @PostMapping("/a")
    public App_A_ResponseDTO post(@RequestBody App_A_RequestDTO appARequestDTO) {
        App_B_RequestDTO appBRequestDTO = new App_B_RequestDTO();
        appBRequestDTO.setA("Value from A Request=[" + appARequestDTO.getA() + "]" );
        log.info("Calling App B Proxy with request parameter=[" + appBRequestDTO.getA() + "]");
        App_B_ResponseDTO appBResponseDTO = appBProxy.retrieveValue(appBRequestDTO);

        App_A_ResponseDTO appAResponseDTO = new App_A_ResponseDTO();
        appAResponseDTO.setA(appBResponseDTO.getA());
        log.info("Response back with=[" + appBResponseDTO.getA() + "]");

        return appAResponseDTO;
    }
}
