package com.example.demo.models;

public class Adder {
	
//	int secret1;
//	double secret2;
	double sum;
	
	public Adder(int first, double second) {
//		secret1 = first;
//		secret2 = second;
		sum = first + second;
	}
	
	public double calculate() {		
		return sum;
	}
	
}
