package com.drufontael.workshopmongo.config;

import com.drufontael.workshopmongo.domain.Post;
import com.drufontael.workshopmongo.domain.User;
import com.drufontael.workshopmongo.repository.PostRepository;
import com.drufontael.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;
    @Autowired
    PostRepository postRepository;
    @Override
    public void run(String... args) throws Exception {

        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd/MM/yyyy");

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");
        userRepository.saveAll(Arrays.asList(maria,alex,bob));

        Post post1 = new Post(null, LocalDate.parse("21/03/2018",formatter),"Partiu viagem","Vou viajar " +
                "para São Paulo. Abraços",maria);
        Post post2 = new Post(null,LocalDate.parse("21/03/2018",formatter),"Bom dia","Acordei feliz hoje!",
                maria);
        postRepository.saveAll(Arrays.asList(post1,post2));
    }
}
