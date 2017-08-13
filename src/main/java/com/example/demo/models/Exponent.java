package com.example.demo.models;

public class Exponent {
	
	double exponentProduct;
	
	public Exponent(double first, double second) {
		exponentProduct = Math.pow(first, second);
	}
	
	public double calculate() {		
		return exponentProduct;
	}
	
}
