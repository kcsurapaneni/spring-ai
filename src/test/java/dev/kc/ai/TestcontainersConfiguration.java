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
                .parse("ghcr.io/kcsurapaneni/ollama-phi3:20240708-012629")
                .asCompatibleSubstituteFor("ollama/ollama")
        );
    }

}
