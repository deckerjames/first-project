package com.example.demo.models;

public class Yeller {
	String msg;
	
	
	public Yeller(String message) {
		msg = message;
	}
	
	public String upper() {		
		return msg.toUpperCase();
	}
	
}