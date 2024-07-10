package dev.kc.ai.code.controller;

import dev.kc.ai.code.service.*;
import org.springframework.web.bind.annotation.*;

/**
 * @author Krishna Chaitanya
 */
@RestController
@RequestMapping("/code")
public class SqlQueryGenerationController {

    private final SqlQueryGenerationService sqlQueryGenerationService;

    public SqlQueryGenerationController(SqlQueryGenerationService sqlQueryGenerationService) {
        this.sqlQueryGenerationService = sqlQueryGenerationService;
    }


    @GetMapping
    String fetchSqlQuery(@RequestParam String question) {
        return sqlQueryGenerationService.generateQuery(question);
    }

}
