package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller // This means that this class is a Controller
@RestController
@RequestMapping(path="/demo") // This means URL's start with /demo (after Application path)
public class MainController {
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private UserService userService;

    @PostMapping(path="/add") // Map ONLY POST Requests

    public @ResponseBody String addNewUser ( @RequestBody Users n) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        userService.addNewUser(n);
        return "Saved";
    }
    @PutMapping(path="/update/{id}")

    public String updateUser ( @RequestBody Users n,@PathVariable Integer id) {
        userService.updateUser(id,n);
        return "Updated";

    }

    @DeleteMapping(path="/delete/{id}")

    public String deleteUser ( @PathVariable Integer id) {
        userService.deleteUser(id);
       return "Deleted";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Users> getAllUsers() {
        // This returns a JSON or XML with the users
        return userService.findAll();
    }
   @RequestMapping(method = RequestMethod.POST,value="/signin")

    public String signin(@RequestParam String email,@RequestParam String password){
        return userService.signin(email, password);
   }

   @RequestMapping(method = RequestMethod.POST,value = "/signup" )

    public  String signup(@RequestBody  Users u){
        return  userService.signup(u);
    }
    //Web service for checking email address is there in database or not
    @RequestMapping(method = RequestMethod.GET,value = "/checkEmail")
    public String checkEmail(@RequestParam String email){
        return userService.checkEmail(email);
    }

    //Web service for checking phone number is there in database or not
    @RequestMapping(method = RequestMethod.GET,value="/checkPhoneNumber")
    public String checkPhoneNumber(@RequestParam String contactNo){
        return userService.checkPhoneNumber(contactNo);
    }



}