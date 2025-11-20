package com.example.service;

import org.springframework.stereotype.Service;

import com.example.request.Order;
import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class OrderService {
    public void insert(Order od) {
    	log.debug(od.toString());
    }
}
