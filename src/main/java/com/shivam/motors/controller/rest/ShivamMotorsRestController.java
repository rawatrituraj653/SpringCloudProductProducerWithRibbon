package com.shivam.motors.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shivam.motors.maruti.consumer.MarutiModelConsumer;

@RestController
@RequestMapping("/motor")
public class ShivamMotorsRestController {

	@Autowired
	private MarutiModelConsumer consumer;
	
	
	@GetMapping("/msg")
	public String getMsg() {
			
		return "From Shivam Motors:"+consumer.getMsg();
	}
	
	@GetMapping("/one")
	public String getOne() {
	
	return  "From Shivam Motors:"+consumer.getOneModel();
	}
	
	@GetMapping("/all")
	public String  getAll() {

	return  "From Shivam Motors:"+consumer.getAllModel();	
	}

}