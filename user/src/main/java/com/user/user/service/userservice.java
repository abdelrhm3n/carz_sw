package com.user.user.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.RedirectView;

import com.user.user.model.AdminRepo;
import com.user.user.model.Car;
import com.user.user.model.datauser;
import com.user.user.model.datauserRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;
@Service
public class userservice {
    Integer id;
    @Autowired
    public datauserRepository repository;
    @Autowired
    private AdminRepo car;
    private static final String USERNAME = "^[a-zA-Z0-9]([._-](?![._-])|[a-zA-Z0-9]){3,18}[a-zA-Z0-9]$";
    private static final Pattern USERNAMEPATTERN = Pattern.compile(USERNAME);
    private static final String EMAIL ="^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    private static final Pattern EMAILpattern = Pattern.compile(EMAIL);
    private static final String ZIP_CODE_PATTERN = "^[0-9]{6}$";
    private static final Pattern ZIPPATTERN = Pattern.compile(ZIP_CODE_PATTERN);
    public RedirectView  login(String email ,Integer password){
        datauser person=repository.findByEmailAndPassword(email,password);
        Matcher matcheremail = EMAILpattern.matcher(email);
        if (matcheremail.matches()){
           if ( password!=55555 || !email.equals("admin@admin.com")){
              if (person!= null){  
                 id=person.getId();
               return new RedirectView("http://localhost:8080/clint/our_cars.html", true);
             //user

                }

               else{
                return new RedirectView("http://localhost:8080/auth/login.html", true);
               //login
                }
          }
          else{
            return new RedirectView("http://localhost:8080/admin/admin_panel.html", true);
             //admin
          }
        }
        else{
              return new RedirectView("http://localhost:8080/auth/login.html", true);
             // login
        }
        
     }
    public RedirectView saveuser(String username,String email,Integer password,Integer age){
            if (age>=20){
             datauser user = new datauser(username,email,password,age);
              repository.save(user);
              id=user.getId();
              return new RedirectView("http://localhost:8080/clint/our_cars.html", true);  } 
              else{
                return new RedirectView("http://localhost:8080/misc/pages-misc-under-maintenance.html", true);
              }         
            }
        public void checksaveuser(String username,String email,Integer password,Integer age){
        Matcher matcheremail = EMAILpattern.matcher(email);
        Matcher matcherusername = USERNAMEPATTERN.matcher(username);
        if(matcheremail.matches()&&matcherusername.matches()){
           saveuser(username, email, password,age);
        }

      }
      public RedirectView updateuser(  String username, String email, Integer password,Integer phone,String adress,String zipcode ,Integer age){
      Matcher matcheremail = EMAILpattern.matcher(email);
      Matcher matcherzip = ZIPPATTERN.matcher(zipcode);
      if(matcheremail.matches()&&matcherzip.matches()&& age>=20){
        datauser data =repository.findById(id).get();
        data.setUsername(username);
        data.setEmail(email);
        data.setPassword(password);
        data.setPhone(phone);
        data.setadress(adress);
        data.setzipcode(zipcode);
        data.setage(age);
        repository.save(data);
        return new RedirectView("http://localhost:8080/auth/profile.html", true);
        }
      else{
          return new RedirectView("http://localhost:8080/misc/pages-misc-under-maintenance.html", true);
        }
      }
      public RedirectView deleteuser(){
       repository.deleteById(id);
       return new RedirectView("http://localhost:8080/auth/login.html", true);
      }
      public datauser getuser(){
      datauser user =repository.findById(id).get();
      return user;
      }
          public List <Car>  get_cars_by_type(String type){
        List<Car> result = new ArrayList<Car>();
        List<Car> cars = new ArrayList<Car>();
        car.findAll().forEach(cars::add);
        for(int i=0;i<cars.size();i++){
            if(cars.get(i).getCar_state().equals("avilable") | cars.get(i).getCar_state()=="avilable" ){
            if(cars.get(i).getCar_type().equals(type)|cars.get(i).getCar_type()==type){
                result.add(cars.get(i));
            }}
        }
        return result;
    }

    public List <Car>  get_cars_by_state(){
        List<Car> result = new ArrayList<Car>();
        List<Car> cars = new ArrayList<Car>();
        car.findAll().forEach(cars::add);
        for(int i=0;i<cars.size();i++){
            if(cars.get(i).getCar_state().equals("avilable") | cars.get(i).getCar_state()=="avilable" ){
                result.add(cars.get(i));
            }
        }
        return result;
    }
    }