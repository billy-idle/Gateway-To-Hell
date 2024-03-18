package com.github.gatewaytohell;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Hooks;

@SpringBootApplication
public class GatewayToHellApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayToHellApplication.class, args);
        Hooks.enableAutomaticContextPropagation();
    }

}
