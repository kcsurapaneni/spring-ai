package dev.kc.ai.config;

import org.springframework.ai.chat.memory.*;
import org.springframework.boot.web.client.*;
import org.springframework.context.annotation.*;
import org.zalando.logbook.*;
import org.zalando.logbook.spring.*;

/**
 * @author Krishna Chaitanya
 */
@Configuration
public class AppConfig {

    @Bean
    ChatMemory chatMemory() {
        return new InMemoryChatMemory();
    }

    @Bean
    RestClientCustomizer restClientCustomizer(Logbook logbook) {
        return restClientCustomizer -> restClientCustomizer.requestInterceptor(new LogbookClientHttpRequestInterceptor(logbook));
    }

}
