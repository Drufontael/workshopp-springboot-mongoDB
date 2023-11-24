package com.drufontael.workshopmongo.services;

import com.drufontael.workshopmongo.domain.Post;
import com.drufontael.workshopmongo.repository.PostRepository;
import com.drufontael.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PostService {
    @Autowired
    PostRepository repository;


    public Post findById(String id){
        Post post;
        if (repository.findById(id).isPresent()){
            post=repository.findById(id).get();
        } else {
            throw new ObjectNotFoundException("Objeto não encontrado");
        }
        return post;
    }

    public List<Post> findByTitle(String text){
        return repository.searchByTitle(text);
    }

    public List<Post> fullSearch(String text, LocalDate minDate, LocalDate maxDate){
       return repository.fullSearch(text,minDate,maxDate);
    }

}
