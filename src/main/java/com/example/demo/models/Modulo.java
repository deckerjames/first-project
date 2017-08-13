package com.example.demo.models;

public class Modulo {
	
	double moduloRemainder;
	
	public Modulo(double first, double second) {
		moduloRemainder = first % second;
	}
	
	public double calculate() {		
		return moduloRemainder;
	}
	
}
