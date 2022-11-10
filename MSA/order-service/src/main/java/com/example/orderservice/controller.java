package com.example.orderservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order-service")
public class controller {

    @Autowired
    Environment env;

    @GetMapping("/heath_check")
    public String status(){
        return String.format("It's working in User Service or PORT %s",
                env.getProperty("local.server.port"));
    }
}
