package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.beans.IntrospectionException;

@Service
public class UserService {
    @Autowired
    private  UserRepository userRepository;

    public void updateUser(Integer id,Users n){
        userRepository.save(n);

    }

    public void deleteUser(Integer id){
         userRepository.deleteById(id);

    }


    public Iterable<Users> findAll()
    {
        return userRepository.findAll();
    }



    public void addNewUser(Users n)
    {
        userRepository.save(n);
    }

    public String signin(String email, String password){
        Users u = userRepository.signin(email, password);
        if(u==null){
            return "0";
        }
        return u.getName();
    }

    public String signup(Users u) {
         try{

             userRepository.save(u);
             return "Registered Successfully";
         }
         catch (Exception e){
             return e.toString();
         }


    }
    public String checkPhoneNumber(String contactNo)
    {
        Users u=userRepository.checkPhoneNumber(contactNo);
        if(u==null)
        {
            return "0";
        }
        return "1";
    }

    public String checkEmail(String email)
    {
        Users u=userRepository.checkEmail(email);
        if(u==null)
        {
            return "0";
        }
        return "1";
    }
}
