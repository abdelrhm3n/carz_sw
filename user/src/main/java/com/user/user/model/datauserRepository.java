package com.user.user.model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface datauserRepository extends JpaRepository<datauser, Integer> {   
    datauser findByEmailAndPassword(String email, Integer password);
}
