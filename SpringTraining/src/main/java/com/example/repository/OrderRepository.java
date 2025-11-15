package com.example.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.request.Order1;



@Repository
public interface OrderRepository extends CrudRepository<Order1, Integer>{

}