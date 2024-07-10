package dev.kc.ai.chat.service;

import org.springframework.ai.chat.client.*;
import org.springframework.ai.chat.client.advisor.*;
import org.springframework.ai.chat.memory.*;
import org.springframework.stereotype.*;

import static org.springframework.ai.chat.client.advisor.AbstractChatMemoryAdvisor.CHAT_MEMORY_CONVERSATION_ID_KEY;

/**
 * @author Krishna Chaitanya
 */
@Service
public class ChatService {

    private final ChatClient chatClient;

    ChatService(ChatClient.Builder builder, ChatMemory chatMemory) {
        this.chatClient = builder
                .defaultSystem("you are a chat service, be polite")
                .defaultAdvisors(new PromptChatMemoryAdvisor(chatMemory), new SimpleLoggerAdvisor())
                .build();
    }

    public String chat(String chatId, String message) {
        return chatClient
                .prompt()
                .user(message)
                .advisors(advisorSpec -> advisorSpec.param(CHAT_MEMORY_CONVERSATION_ID_KEY, chatId))
                .call()
                .content();
    }

}
