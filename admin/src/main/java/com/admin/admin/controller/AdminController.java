package com.admin.admin.controller;

import org.springframework.web.bind.annotation.RestController;
import com.admin.admin.model.Car;
import com.admin.admin.service.AdminService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping("/admin")
public class AdminController {
    

    int current;


    @Autowired
    private AdminService Service;

    @GetMapping("/getcar")
    //localhost:8080/admin/getcar
    public List<Car> getcars(){
        return Service.get_cars();
    }


    @PostMapping("/create")
    //localhost:8080/admin/create
    public String savecar(@RequestBody Map <String , String> request) {
        Car CarObj = new Car(Integer.parseInt(request.get("plateid")),request.get("name"),request.get("des"),request.get("type"),request.get("price"), "avilable",request.get("loc").replace("C:\\fakepath\\", ""));
        Service.add_car(CarObj);
        return "done";
    }

    @PutMapping("/update") 
    //localhost:8080/admin/update
    public Car updatecar(@RequestBody Map <String,String> request) {
        Car CarObj = new Car( current,request.get("name"),request.get("description"),request.get("type"),request.get("price"),findcar().getCar_state(),request.get("loc").replace("C:\\fakepath\\", ""));

        Car result = Service.update_car(CarObj);
        return result;
    }


    @DeleteMapping("/{id}/delete")
    public String deletecar(@PathVariable Integer id){
        Service.delete_car(id);
        return "Deleted successfully";
    }


    @GetMapping("/view")
    public  Car findcar() {
        return Service.find_car(current);
    } 

    @GetMapping("/{id}/set")
    public int setcurrent(@PathVariable int id) {
        current=id;
        return current;
    }

    @PutMapping("/buy") 
    //localhost:8080/admin/update
    public void buy() {
        Service.buy_car(current);
    }

}