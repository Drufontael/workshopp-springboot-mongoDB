package com.drufontael.workshopmongo.services;

import com.drufontael.workshopmongo.domain.User;
import com.drufontael.workshopmongo.repository.UserRepository;
import com.drufontael.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }
    public User findById(String id){
        User user;
        if (repository.findById(id).isPresent()){
            user=repository.findById(id).get();
        } else {
            throw new ObjectNotFoundException("Objeto não encontrado");
        }
        return user;
    }
}
