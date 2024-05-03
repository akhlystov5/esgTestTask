package info.fa.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = {"info.fa.rest"})
@EnableJpaRepositories(basePackages = {"info.fa.rest"})
@SpringBootApplication
public class EsgRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(EsgRestApplication.class);
    }

}
