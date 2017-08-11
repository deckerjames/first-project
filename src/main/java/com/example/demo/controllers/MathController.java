package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.models.Adder;
import com.example.demo.models.Subtractor;

@Controller
@RequestMapping("/math")
public class MathController {

	@PostMapping("adder")
	public String addTwoNumbers(@RequestParam(name="left") int first, @RequestParam(name="right") double second, Model model) {
		Adder adder = new Adder(first, second);
		double result = adder.calculate();
		model.addAttribute("sum", result);
		return "helloworld/sum-result";
	}
	
	// homework
	@GetMapping("adder")
	public String addTwoNumbersGet(Model model) {
		Adder adder = new Adder(0, 0);
		double result = adder.calculate();
		model.addAttribute("sum", result);
		return "helloworld/sum-resultGet";
	}
	
	@PostMapping("subtractor")
	public String subtractTwoNumbers(@RequestParam(name="left") int first, @RequestParam(name="right") double second, Model model) {
		Subtractor subtractor = new Subtractor(first, second);
		double result = subtractor.calculate();
		model.addAttribute("difference", result);
		return "helloworld/difference-result";
	}
	
	// homework
	@GetMapping("subtractor")
	public String subtractTwoNumbersGet(Model model) {
		Subtractor subtractor = new Subtractor(0, 0);
		double result = subtractor.calculate();
		model.addAttribute("difference", result);
		return "helloworld/difference-resultGet";
	}
		
}
