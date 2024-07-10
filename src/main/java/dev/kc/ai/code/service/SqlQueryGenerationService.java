package dev.kc.ai.code.service;

import org.springframework.ai.chat.client.*;
import org.springframework.ai.chat.model.*;
import org.springframework.ai.ollama.*;
import org.springframework.ai.ollama.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.core.io.*;
import org.springframework.stereotype.*;

import java.nio.charset.*;

/**
 * @author Krishna Chaitanya
 */
@Service
public class SqlQueryGenerationService {

    @Value("classpath:/code/schema.sql")
    private Resource schemaResource;

    @Value("classpath:/code/sql-prompt-template.st")
    private Resource sqlPromptTemplateResource;

    private final ChatClient phi3Client;

    public SqlQueryGenerationService() {
        OllamaChatModel phi3 = new OllamaChatModel(new OllamaApi("http://localhost:11435"), OllamaOptions.create().withModel("phi3"));
        this.phi3Client = ChatClient.builder(phi3).defaultSystem("Consider you as a sql query generator bot and assume you are writing queries for MySQL 8 version").build();
    }

    public String generateQuery(String question) {
        try {
            String ddlData = schemaResource.getContentAsString(StandardCharsets.UTF_8);
            return phi3Client
                    .prompt()
                    .user(promptUserSpec -> promptUserSpec
                            .text(sqlPromptTemplateResource)
                            .param("question", question)
                            .param("ddl", ddlData)
                    )
                    .call()
                    .content();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
