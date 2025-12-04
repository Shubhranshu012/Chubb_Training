package com.redis.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Person {
	private static final long serialVersionUID = 1L;
    @Id
    private String id;
    private String name;
    public Person() {}
    public Person(String name) { 
    	this.name = name; 
    }
    public String getId() { 
    	return id; 
    }
    public String getName() { 
    	return name; 
    }
    public void setName(String name) { 
    	this.name = name; 
    }
}

