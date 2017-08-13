package com.example.demo.models;

public class Multiplier {
	
	double product;
	
	public Multiplier(double first, double second) {
		product = first * second;
	}
	
	public double calculate() {		
		return product;
	}
	
}
