package com.demo.first.Repository;

import com.demo.first.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer>{
    List<User> findByNameIgnoreCaseAndEmailIgnoreCase(String name, String email);
}
