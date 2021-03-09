package com.alibaba.rsocket.cloudevents.codec;

import org.springframework.boot.rsocket.messaging.RSocketStrategiesCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
public class RSocketConfiguration {
    @Bean
    @Order(-1)
    public RSocketStrategiesCustomizer cloudEventsCustomizer() {
        return strategies -> {
            strategies.encoder(new CloudEventEncoder());
            strategies.decoder(new CloudEventDecoder());
        };
    }
}
