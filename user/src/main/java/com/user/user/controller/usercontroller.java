package com.user.user.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.user.user.model.Car;
import com.user.user.model.datauser;
import com.user.user.service.userservice;

@RestController
@RequestMapping("/user")
public class usercontroller {
    @Autowired
    private userservice userservice;
    @GetMapping("/login")
    public RedirectView login (@RequestParam("email") String email ,@RequestParam("password")Integer password){
        return userservice.login(email,password);
     }
    @PostMapping("/regester")
    private RedirectView regester(@RequestParam("username") String username,@RequestParam("email") String email,@RequestParam("password") Integer password ,@RequestParam("age") Integer age){
         return userservice.saveuser(username,email,password,age);
     }   
    @PostMapping("/updateuser")
    public RedirectView updateuser(@RequestParam("username") String username,@RequestParam("email") String email,@RequestParam("password") Integer password,@RequestParam("phone") Integer phone,@RequestParam("adress") String adress,@RequestParam("zipcode") String zipcode,@RequestParam("age") Integer age){
        return userservice.updateuser(  username, email, password,  phone, adress, zipcode,age);
     }
    @PostMapping("/deleteuser")
    public RedirectView deleteuser(){
        return userservice.deleteuser();
     }
     @GetMapping("/getuser")
     public datauser getuser (){
        return userservice.getuser();
     }   
     @GetMapping("/getavilablecar")
     public List<Car> getavilablecars(){
         return userservice.get_cars_by_state();
     }
         @GetMapping("/{type}/type")
    public List<Car> getcarsbytype(@PathVariable String type){
        return userservice.get_cars_by_type(type);
    }

}