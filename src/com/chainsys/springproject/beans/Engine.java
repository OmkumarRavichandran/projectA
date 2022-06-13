package com.chainsys.springproject.beans;

public class Engine {

	public void start() {
		System.out.println("Engine is Started");
	}
	public Engine() {
		System.out.println("Engine object is created"+hashCode());
	}
}
