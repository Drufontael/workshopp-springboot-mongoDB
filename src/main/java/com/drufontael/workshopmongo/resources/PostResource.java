package com.drufontael.workshopmongo.resources;

import com.drufontael.workshopmongo.domain.Post;
import com.drufontael.workshopmongo.domain.User;
import com.drufontael.workshopmongo.dto.UserDTO;
import com.drufontael.workshopmongo.resources.util.URL;
import com.drufontael.workshopmongo.services.PostService;
import com.drufontael.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService service;



    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity<Post> findById(@PathVariable String id){
            Post post = service.findById(id);
            return ResponseEntity.ok().body(post);
    }

    @GetMapping("/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text",defaultValue = "") String text){
        String decodeText= URL.decodeParam(text);
        List<Post> list=service.findByTitle(decodeText);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/fullSearch")
    public ResponseEntity<List<Post>> fullSearch(@RequestParam(value = "text",defaultValue = "") String text,
                                                 @RequestParam(value = "minDate",defaultValue = "") String minDate,
                                                 @RequestParam(value = "maxDate",defaultValue = "") String maxDate){
        String decodeText= URL.decodeParam(text);
        LocalDate min=URL.convertDate(minDate,LocalDate.parse("1970-01-01"));
        LocalDate max=URL.convertDate(maxDate,LocalDate.now());
        List<Post> list=service.fullSearch(decodeText,min,max);
        return ResponseEntity.ok(list);
    }

}
