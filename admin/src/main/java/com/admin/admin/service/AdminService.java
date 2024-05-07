package com.admin.admin.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.admin.admin.model.AdminRepo;
import com.admin.admin.model.Car;
@Service
public class AdminService {
    @Autowired
    private AdminRepo car;

    public List <Car>  get_cars(){
        List<Car> result = new ArrayList<Car>();
        car.findAll().forEach(result::add);   //method reference
        return result;
    }


    public Car add_car(Car carObj){
        car.save(carObj);
        return carObj;
    }
    public boolean delete_car(Integer plate_id){
        car.deleteById(plate_id);
        return true;
    }

    public Car update_car(Car carObj){
        return car.save(carObj);
    }

    public Car find_car(Integer plate_id){
        Optional <Car> result =  car.findById(plate_id);
        return result.orElse(null);
    }

    public void buy_car(int id){
        Car car_b = new Car(car.findById(id).get().getPlate_id(),car.findById(id).get().getCar_name(),car.findById(id).get().getCar_description(),car.findById(id).get().getCar_type(),car.findById(id).get().getCar_price(),"shipping",car.findById(id).get().getCar_photo_location());
        car.save(car_b);
    }

}
