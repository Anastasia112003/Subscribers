package com.example.subscriber1.websocket;


import com.example.subscriber1.service.SubscribeService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;


@Controller
public class WebSocketController {
    private final SubscribeService subscribeService;


    public WebSocketController(SubscribeService subscribeService) {
        this.subscribeService = subscribeService;
    }

    @MessageMapping("/hello")
    @SendTo("/topic/answer")
    public void answer() {
        subscribeService.findUpdate();
    }

}
