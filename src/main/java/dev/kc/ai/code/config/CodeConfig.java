package dev.kc.ai.code.config;

import org.springframework.ai.chat.model.*;
import org.springframework.ai.ollama.*;
import org.springframework.ai.ollama.api.*;
import org.springframework.context.annotation.*;

/**
 * @author Krishna Chaitanya
 */
//@Configuration
public class CodeConfig {

    // TODO use @Fallback once it is available in GA
    // https://github.com/spring-projects/spring-framework/commit/480051a21c54329af5705205535290dfb158456e
    @Bean
    ChatModel phi3() {
        return new OllamaChatModel(new OllamaApi("http://localhost:11435"), OllamaOptions.create().withModel("phi3"));
    }

}
