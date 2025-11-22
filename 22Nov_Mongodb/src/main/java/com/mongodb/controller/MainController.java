package com.mongodb.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.model.Student;
import com.mongodb.repository.StudentRepo;

import jakarta.validation.Valid;

@RestController
public class MainController {
	
	@Autowired
	StudentRepo studentrepo;
	@PostMapping("/addStudent")
	public ResponseEntity<?> adding(@RequestBody @Valid Student student) {

	    boolean exists = studentrepo.existsById(student.getRno());
	    if (exists) {
	        Map<String, String> error = new HashMap<>();
	        error.put("message", "Id already exists");
	        return ResponseEntity.badRequest().body(error);  
	    }

	    studentrepo.save(student);
	    return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	@GetMapping("/getStudent")
	public List<Student> getAll() {
		return studentrepo.findAll();
	}
	@GetMapping("/getStudent/{id}")
	public ResponseEntity<Student> getStudentbyId(@PathVariable Integer id) {

	    return studentrepo.findById(id)
	            .map(student -> ResponseEntity.ok(student)).orElseGet(() -> ResponseEntity.notFound().build());
	}
	@PutMapping("/updateStudent")
	public ResponseEntity<Object> update(@RequestBody @Valid Student student) {
		
		Student data=studentrepo.findById(student.getRno()).orElse(null);
		if(data!=null) {
			data.setAddress(student.getAddress());
			data.setName(student.getName());
			studentrepo.save(student);
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.ok().build();
		
	}
	
	@DeleteMapping("/deleteStudent/{id}")
	public ResponseEntity<Void> deleteStudentbyId(@PathVariable Integer id) {

	    if (!studentrepo.existsById(id)) {
	        return ResponseEntity.notFound().build();  
	    }
	    studentrepo.deleteById(id);
	    return ResponseEntity.ok().build(); 
	}
}
