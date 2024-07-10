package dev.kc.ai;

import org.springframework.boot.SpringApplication;

public class TestSpringAiApplication {

	public static void main(String[] args) {
		SpringApplication.from(SpringAiApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
