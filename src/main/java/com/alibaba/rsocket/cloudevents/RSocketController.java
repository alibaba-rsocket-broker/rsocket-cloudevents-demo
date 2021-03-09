package com.alibaba.rsocket.cloudevents;

import io.cloudevents.CloudEvent;
import io.cloudevents.core.builder.CloudEventBuilder;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.UUID;

@Controller
public class RSocketController {
    @MessageMapping("event")
    public Mono<CloudEvent> event(@RequestBody Mono<CloudEvent> body) {
        return body.map(event -> CloudEventBuilder.from(event) //
                .withId(UUID.randomUUID().toString()) //
                .withSource(URI.create("https://spring.io/foos")) //
                .withType("com.alibaba.rsocket.cloudevents.User") //
                .withData(event.getData().toBytes()) //
                .build());
    }
}
