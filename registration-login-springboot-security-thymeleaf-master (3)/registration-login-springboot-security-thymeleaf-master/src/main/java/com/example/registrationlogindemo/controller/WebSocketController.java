package com.example.registrationlogindemo.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.example.registrationlogindemo.entity.Message;

@Controller
public class WebSocketController {

    @MessageMapping("/chat")
    @SendTo("/topicor/messages")
    public Message handleMessage(Message message) {
        // Processar a mensagem e retornar uma resposta
        return new Message("Servidor", "Recebido: " + message.getContent() +
        "Obrigado por conversar comigo :-)" );
    }
}