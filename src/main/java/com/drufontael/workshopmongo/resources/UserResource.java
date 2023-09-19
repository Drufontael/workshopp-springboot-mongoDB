package com.drufontael.workshopmongo.resources;

import com.drufontael.workshopmongo.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        User maria=new User("1","Maria Rita","m.rita@gmail.com");
        User alex=new User("2","Alex Pedro","ale.pedro@gmail.com");
        User ivan=new User("3","Ivan Lucio","ivan.lucio@gmail.com");
        return ResponseEntity.ok().body(Arrays.asList(maria,alex,ivan));
    }
}
