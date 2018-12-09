package com.arthurthecat.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.arthurthecat.model.Calculator;

@Controller
@SessionAttributes({"decision"})
public class DecisionController {


	@RequestMapping(path = {"/home","/"}, method = RequestMethod.GET)
	public String displayHomePage(HttpServletRequest request) {
		Calculator calculator = new Calculator();
		request.setAttribute("decision", calculator);
		return "home";
	}
	
	@RequestMapping(path = "/impact", method = RequestMethod.POST)
	public String addComplexity(ModelMap modelMap, String complexity) {
		Calculator calculator = new Calculator();
		calculator.setComplexity(complexity);
		modelMap.addAttribute("decision", calculator);
		return "redirect:/impact";
	}
	
	@RequestMapping(path = {"/impact"}, method = RequestMethod.GET)
	public String displayImpactPage(HttpServletRequest request) {
		return "impact";
	}
	
	@RequestMapping(path = "/options", method = RequestMethod.POST)
	public String addImpact(ModelMap modelMap, String impact) {
		Calculator calculator = (Calculator) modelMap.get("decision");
		calculator.setImpact(impact);
		modelMap.replace("decision", calculator);
		return "redirect:/options";
	}
	
	@RequestMapping(path = "/options", method = RequestMethod.GET)
	public String displayOptionsPage(HttpServletRequest request) {
		return "options";
	}

}