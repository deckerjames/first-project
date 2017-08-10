package com.example.demo.models;

public class Subtractor {
	
//	int secret1;
//	double secret2;
	double difference;
	
	public Subtractor(int first, double second) {
//		secret1 = first;
//		secret2 = second;
		difference = first - second;
	}
	
	public double calculate() {		
		return difference;
	}
	
}
