package com.drufontael.workshopmongo.config;

import com.drufontael.workshopmongo.domain.User;
import com.drufontael.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    UserRepository repository;
    @Override
    public void run(String... args) throws Exception {
        repository.deleteAll();
        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");
        repository.saveAll(Arrays.asList(maria,alex,bob));
    }
}
