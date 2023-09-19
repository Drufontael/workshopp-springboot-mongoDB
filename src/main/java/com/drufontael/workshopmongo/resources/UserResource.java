package com.drufontael.workshopmongo.resources;

import com.drufontael.workshopmongo.domain.User;
import com.drufontael.workshopmongo.dto.UserDTO;
import com.drufontael.workshopmongo.services.UserService;
import com.drufontael.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){
        return ResponseEntity.ok().body(service.findAll().stream().map(UserDTO::new).toList());
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity<UserDTO> findById(@PathVariable String id){
            UserDTO userDTO = new UserDTO(service.findById(id));
            return ResponseEntity.ok().body(userDTO);
    }
}
