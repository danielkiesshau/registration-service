package com.br.healthCare.registrationService.appRunner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.br.healthCare.registrationService.domain")
@ComponentScan("com.br.healthCare.registrationService.infra")
@EnableJpaRepositories("com.br.healthCare.registrationService.infra")
@EntityScan("com.br.healthCare.registrationService.data")
public class ApplicationRunner {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationRunner.class, args);
    }
}
