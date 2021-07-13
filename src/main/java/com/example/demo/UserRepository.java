package com.example.demo;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.Users;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends CrudRepository<Users, Integer> {
    @Query(value="select u from Users u where u.email=?1 and u.Password=?2")

    Users signin (String email, String password);

    @Query(value = "SELECT u FROM Users u where u.contactNo=?1")
    Users checkPhoneNumber(String contactNo);

    @Query(value = "SELECT u FROM Users u WHERE u.email=?1")
    Users checkEmail(String email);
}
