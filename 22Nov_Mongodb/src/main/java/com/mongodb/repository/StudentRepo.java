package com.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mongodb.model.Student;

public interface StudentRepo extends MongoRepository<Student,Integer>{

}
