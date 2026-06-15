package com.example.repository;
//repository layer interacts with database

import com.example.db.DatabaseConnection;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public class UserRepository {
    private DatabaseConnection db;

    public UserRepository(DatabaseConnection db) {
        this.db = db;
    }

    public List<String> findAll(){
        return db.getUser();
    }

    public void save(String user){
        db.addUser(user);
    }
}
