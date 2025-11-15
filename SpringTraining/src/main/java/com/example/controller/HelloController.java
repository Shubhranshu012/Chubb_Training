package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.repository.OrderRepository;
import com.example.request.Order;
import com.example.request.Order1;
import com.example.service.OrderService;

import jakarta.validation.Valid;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController

public class HelloController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello from Spring!";
    }
    
    @PostMapping("/price")
    Order saveOrder(@RequestBody Order order) {
    		return order;
	}
    
    
    
    /*
     * We send :-
     * {
     * 	"item":"laptop",
     * 	"price":55000.75
     * }
     * it internaly is executed as
     Order order = new Order();
	 order.setItem("Laptop");
	 order.setPrice(55000.75f);
     */
    
    
    @PostMapping("/total")
    float TotalPrice(@RequestBody @Valid Order order) {
    		return order.total();
	}
    
    @Autowired
    OrderService os;
    
    @PostMapping("/orderService")
    Order saveOrderService(@RequestBody Order order) {
    	log.debug("logger added");
		os.insert(order);
    	return order;
    }
    
    
    
    @Autowired
    OrderRepository orderRepository;
    @PostMapping("/savetodb")
    public Order1 insertOrder(@RequestBody Order1 order) {
    	orderRepository.save(order);
    	log.debug(order.toString());
    	return order;
    }
    
    
}
