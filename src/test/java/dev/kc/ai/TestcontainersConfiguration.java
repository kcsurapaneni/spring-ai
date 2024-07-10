package dev.kc.ai;

import org.springframework.boot.devtools.restart.*;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.*;
import org.springframework.context.annotation.*;
import org.testcontainers.ollama.*;
import org.testcontainers.utility.*;

@TestConfiguration(proxyBeanMethods = false)
class TestcontainersConfiguration {

    @Bean
    @RestartScope
    @ServiceConnection
    OllamaContainer ollama() {
        return new OllamaContainer(DockerImageName
                .parse("kcsurapaneni/ollama-llama3:latest")
                .asCompatibleSubstituteFor("ollama/ollama")
        );
    }

}
