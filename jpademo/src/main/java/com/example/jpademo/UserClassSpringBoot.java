package com.example.jpademo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UserClassSpringBoot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public UserClassSpringBoot(){ //it is compulsory is using @Entity

    }

    public UserClassSpringBoot(String name) { //automatically id generation
        this.name = name;
    }

    public UserClassSpringBoot(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName(){
        return name;
    }
}
