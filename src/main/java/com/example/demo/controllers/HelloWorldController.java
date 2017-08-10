package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.models.Adder;
import com.example.demo.models.Subtractor;
import com.example.demo.models.Whisperer;
import com.example.demo.models.Yeller;

@Controller
@RequestMapping({"/", "/HelloWorld"})
public class HelloWorldController {
	
	private String title;
	
	public HelloWorldController() {
		title = "Hello Java and Spring!";
	}
	
	@GetMapping("")
	public String index() {
		return "helloworld/index";
	}
	
	// create a class named Whisperer that makes Strings lower case
	// Using the method below, create a method named "whisper" for a GetMapping that
	//   does essentially the same thing *BUT* uses Whisperer.
	// This means that you should map a GET to the path "whisper"
	// This means that you should have a method named "whisper" that returns a ModelAndView
	
	@GetMapping("message")
	public ModelAndView message(@RequestParam(required=false, defaultValue="«silence»") String message) {
		ModelAndView mv = new ModelAndView("helloworld/message");
		Yeller yeller = new Yeller(message);
		String msgYeller = yeller.upper();
		mv.addObject("title", title);
		mv.addObject("message", msgYeller);
		return mv;
	}
	
	@GetMapping("whisper")
	public ModelAndView whisper(@RequestParam(required=false, defaultValue="«shhhhh!»") String whisper) {
		ModelAndView mv = new ModelAndView("helloworld/whisper");
		Whisperer whisperer = new Whisperer(whisper);
		String msgWhisper = whisperer.lower();
		mv.addObject("title", title);
		mv.addObject("whisper", msgWhisper);
		return mv;
	}
	 
	@PostMapping("adder")
	public String addTwoNumbers(@RequestParam(name="left") int first, @RequestParam(name="right") double second, Model model) {
		Adder adder = new Adder(first, second);
		double result = adder.calculate();
		model.addAttribute("sum", result);
		return "helloworld/sum-result";
	}
	
	@PostMapping("subtractor")
	public String subtractTwoNumbers(@RequestParam(name="left") int first, @RequestParam(name="right") double second, Model model) {
		Subtractor subtractor = new Subtractor(first, second);
		double result = subtractor.calculate();
		model.addAttribute("difference", result);
		return "helloworld/difference-result";
	}
	
}
