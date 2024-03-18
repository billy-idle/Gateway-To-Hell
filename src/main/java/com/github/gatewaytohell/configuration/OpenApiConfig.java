package com.github.gatewaytohell.configuration;

import org.springdoc.core.SwaggerUiConfigParameters;
import org.springdoc.core.SwaggerUiConfigProperties;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Objects;

@Configuration
public class OpenApiConfig {
  @Bean
  public CommandLineRunner runner(RouteDefinitionLocator locator, SwaggerUiConfigParameters parameters) {
    return args -> Objects.requireNonNull(locator.getRouteDefinitions().collectList().block())
                          .stream()
                          .map(RouteDefinition::getId)
                          .filter(id -> id.matches(".*_route"))
                          .map(id -> id.replace("_route", ""))
                          .forEach(parameters::addGroup);
  }

  @Bean
  public SwaggerUiConfigParameters parameters(){
      return new SwaggerUiConfigParameters(new SwaggerUiConfigProperties());
  }
}
