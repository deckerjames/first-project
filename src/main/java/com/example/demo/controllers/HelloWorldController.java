package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.models.Whisperer;
import com.example.demo.models.Yeller;

@Controller
@RequestMapping( "/HelloWorld" )
public class HelloWorldController {

	private String title;

	public HelloWorldController() {
		title = "Hello Java and Spring!";
	}

	@GetMapping("")
	public String index() {
		return "helloworld/index";
	}

	@GetMapping("say-something")
	public String makeAChoice(String speechChoice, String message, Model model) {
		if (speechChoice.equals("yell")) {
			Yeller yeller = new Yeller(message);
			String loud = yeller.upper();
			model.addAttribute("output", loud);
		} else {
			Whisperer whisperer = new Whisperer(message);
			String quiet = whisperer.lower();
			model.addAttribute("output", quiet);
		}
		return "helloworld/mixed-messages";
	}

}
