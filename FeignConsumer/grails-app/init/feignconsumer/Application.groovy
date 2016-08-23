package feignconsumer

import feign.Feign
import feign.gson.GsonDecoder
import feign.gson.GsonEncoder
import grails.boot.GrailsApp
import grails.boot.config.GrailsAutoConfiguration
import org.springframework.context.annotation.Bean
import utils.FeignConsumerApi

class Application extends GrailsAutoConfiguration {
    static void main(String[] args) {
        GrailsApp.run(Application, args)
    }

    @Bean
    FeignConsumerApi createConsumerApi() {
        Feign.builder()
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .target(FeignConsumerApi.class, "http://localhost:8080/");
    }
}