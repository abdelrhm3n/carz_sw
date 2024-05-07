package com.user.user.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    private int plate_id;
    private String car_name;
    private String car_description;
    private String car_type;
    private String car_price;
    private String car_state;
    private String car_photo_location;
    
    public Car() {
    }
    public Car(int plate_id, String car_name, String car_description, String car_type, String car_price,
            String car_state, String car_photo_location) {
        this.plate_id = plate_id;
        this.car_name = car_name;
        this.car_description = car_description;
        this.car_type = car_type;
        this.car_price = car_price;
        this.car_state = car_state;
        this.car_photo_location = car_photo_location;
    }
    public int getPlate_id() {
        return plate_id;
    }
    public void setPlate_id(int plate_id) {
        this.plate_id = plate_id;
    }
    public String getCar_name() {
        return car_name;
    }
    public void setCar_name(String car_name) {
        this.car_name = car_name;
    }
    public String getCar_description() {
        return car_description;
    }
    public void setCar_description(String car_description) {
        this.car_description = car_description;
    }
    public String getCar_type() {
        return car_type;
    }
    public void setCar_type(String car_type) {
        this.car_type = car_type;
    }
    public String getCar_price() {
        return car_price;
    }
    public void setCar_price(String car_price) {
        this.car_price = car_price;
    }
    public String getCar_state() {
        return car_state;
    }
    public void setCar_state(String car_state) {
        this.car_state = car_state;
    }
    public String getCar_photo_location() {
        return car_photo_location;
    }
    public void setCar_photo_location(String car_photo_location) {
        this.car_photo_location = car_photo_location;
    }


    
}
