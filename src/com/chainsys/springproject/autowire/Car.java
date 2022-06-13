package com.chainsys.springproject.autowire;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class Car {
	@Autowired
	private Engine petrolEngine;
	@Autowired
	private Wheel alloy;

	public Car() {
		System.out.println("1 Car Object created " + hashCode());
	}

	public void begin() {
		petrolEngine.start();
	}

	@PostConstruct
	public void start() {
		System.out.println("Started annotation....");
	}

	@PreDestroy
	public void stop() {
		System.out.println("Stopped Annotation...");
	}

	public void move() {
		alloy.rotate();
	}
}

@Component("SportsCar")
class SportsCar extends Car {
	public SportsCar() {
		System.out.println("SportsCar object is created :" + hashCode());
	}
}

@Component("SuvCar")
class SuvCar extends Car {
	public SuvCar() {
		System.out.println("Suv Car object is created : " + hashCode());
	}
}
