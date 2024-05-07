package com.user.user.model;
import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Component
@Entity
@Table
public class datauser {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String username;
  private String email;
  private Integer age;
  private Integer password;
  private Integer phone;
  private String adress;
  private String zipcode;
  public datauser(){
    
  }
  public datauser(String username,String email,Integer password,Integer age){
    this.username=username;
    this.email=email;
    this.password=password;
    this.age=age;
  }
  public datauser(Integer id,String username,String email,Integer password){
    this.id=id;
    this.username=username;
    this.email=email;
    this.password=password;
  }
  public datauser(String username,String email,Integer password,Integer phone,String adress,String zipcode){
    this.username=username;
    this.email=email;
    this.password=password;
    this.phone=phone;
    this.adress=adress;
    this.zipcode=zipcode;
  }
  public datauser(Integer id,String username,String email,Integer password,Integer phone,String adress,String zipcode){
    this.id=id;
    this.username=username;
    this.email=email;
    this.password=password;
    this.phone=phone;
    this.adress=adress;
    this.zipcode=zipcode;
  }
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Integer getPassword() {
    return password;
  }

  public void setage(Integer age) {
    this.age = age;
  }

  public Integer getage() {
    return age;
  }

  public void setPassword(Integer password) {
    this.password = password;
  }

  public Integer getPhone() {
    return phone;
  }

  public void setPhone(Integer phone) {
    this.phone = phone;
  }

  public String getAdress() {
    return adress;
  }
  public void setadress(String adress){
    this.adress=adress;
  }
  public String getzipcode(){
    return zipcode;
  }
  public void setzipcode(String zipcode){
    this.zipcode=zipcode;
  }
}
 



