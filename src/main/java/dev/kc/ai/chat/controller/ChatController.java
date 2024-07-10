package dev.kc.ai.chat.controller;

import dev.kc.ai.chat.service.*;
import org.springframework.web.bind.annotation.*;

/**
 * @author Krishna Chaitanya
 */
@RestController
@RequestMapping("/chat")
public class ChatController {

    private final ChatService chatService;

    ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @GetMapping("/{chatId}")
    String chat(@PathVariable String chatId, @RequestParam String message) {
        return chatService.chat(chatId, message);
    }

}
