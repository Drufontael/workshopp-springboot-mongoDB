package com.drufontael.workshopmongo.dto;

import com.drufontael.workshopmongo.domain.User;

import java.io.Serializable;

public class AuthorDTO implements Serializable {
    private static final long serialVersionUID=1L;
    private String id;
    private String name;

    public AuthorDTO(){}

    public AuthorDTO(User obj){
        this.id=obj.getId();
        this.name=obj.getName();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AuthorDTO authorDTO = (AuthorDTO) o;

        return id.equals(authorDTO.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
