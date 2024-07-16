package com.theoflu.ChatService.controller;

import com.theoflu.ChatService.model.Message;
import com.theoflu.ChatService.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class ChatController {

    private final SimpMessagingTemplate simpleMessagingTemplate;

    @MessageMapping("/message") //app/message
    @SendTo("/chatroom/public")
    private Message recievePublicMessage (@Payload Message message){


        return message;

    }
    @MessageMapping("/private-message") //app/message
    private Message recievePrivateMessage (@Payload Message message){
        // /user/osman/private
        simpleMessagingTemplate.convertAndSendToUser(message.getReceiverName(),"/private",message);
        return message;

    }


}
