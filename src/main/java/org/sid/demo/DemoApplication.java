package org.sid.demo;

import org.sid.demo.entities.Client;
import org.sid.demo.repository.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ClientRepository customerRepository, RepositoryRestConfiguration repositoryRestConfiguration) {
        repositoryRestConfiguration.exposeIdsFor(Client.class);
        return args -> {
            customerRepository.save(new Client(null, "Omar", "omarelouahdani7@gmail.com"));
            customerRepository.save(new Client(null, "Yassine", "yassine@gmail.com"));
            customerRepository.save(new Client(null, "Oussama", "oussama@gmail.com"));
            customerRepository.findAll().forEach(c -> {
                c.toString();
            });
        };
    }
}
