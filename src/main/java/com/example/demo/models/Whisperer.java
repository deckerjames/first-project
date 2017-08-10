package com.example.demo.models;

public class Whisperer {
	String lowTalker;
	
	
	public Whisperer(String whisper) {
		lowTalker = whisper;
	}
	
	public String lower() {		
		return lowTalker.toLowerCase();
	}
	
}
