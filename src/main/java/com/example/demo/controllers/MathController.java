package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.models.Adder;
import com.example.demo.models.Divider;
import com.example.demo.models.Exponent;
import com.example.demo.models.Modulo;
import com.example.demo.models.Multiplier;
import com.example.demo.models.Subtractor;

@Controller
@RequestMapping({ "/", "/Math" })
public class MathController {

	private String title;

	public MathController() {
		title = "Calculator";
	}

	@GetMapping("")
	public String index() {
		return "math/index";
	}
	
	@GetMapping("calculate-something")
	public String calcGet () {
		return "math/calculator-resultGet";
	}

	@PostMapping("calculate-something")
	public String calculator(@RequestParam(name = "calcChoice") String calcChoice,
			@RequestParam(name = "left") int first, @RequestParam(name = "right") double second, Model model) {
		if (calcChoice.equals("add")) {
			Adder adder = new Adder(first, second);
			double sum = adder.calculate();
			model.addAttribute("output", sum);
		} else if (calcChoice.equals("subtract")) {
			Subtractor subtractor = new Subtractor(first, second);
			double difference = subtractor.calculate();
			model.addAttribute("output", difference);
		} else if (calcChoice.equals("multiply")) {
			Multiplier multiplier = new Multiplier(first, second);
			double product = multiplier.calculate();
			model.addAttribute("output", product);
		} else if (calcChoice.equals("divide")) {
			Divider divider = new Divider(first, second);
			double quotient = divider.calculate();
			model.addAttribute("output", quotient);
		} else if (calcChoice.equals("modulo")) {
			Modulo modulo = new Modulo(first, second);
			double moduloRemainder = modulo.calculate();
			model.addAttribute("output", moduloRemainder);
		} else {
			Exponent exponent = new Exponent(first, second);
			double exponentProduct = exponent.calculate();
			model.addAttribute("output", exponentProduct);
		}
		return "math/calculator-result";
	}	
}