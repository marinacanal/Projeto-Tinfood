package com.example.registrationlogindemo.repository;

import com.example.registrationlogindemo.entity.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {    
    @Query(value="delete from users_roles where user_id = ?", nativeQuery=true)
    void deleteByUserRoles(Long user_id);

    User findByEmail(String email);

    List<User> findAllById(Long id);

    // boolean existsById(String email);
}


