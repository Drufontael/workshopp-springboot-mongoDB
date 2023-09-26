package com.drufontael.workshopmongo.services;

import com.drufontael.workshopmongo.domain.User;
import com.drufontael.workshopmongo.dto.UserDTO;
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
    public User insert(User obj){
        return repository.insert(obj);
    }
    public void delete(String id){
        findById(id);
        repository.deleteById(id);
    }
    public User fromDTO(UserDTO objDTO){
        return new User(objDTO.getId(),objDTO.getName(),objDTO.getEmail());
    }
}
