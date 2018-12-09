package com.arthurthecat.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Calculator {
	
	private String complexity;
	private String impact;
	private double complexityCoeff;
	private double impactCoeff;
	private List<Option> options;
	
	public String getComplexity() {
		return complexity;
	}
	public void setComplexity(String complexity) {
		this.complexity = complexity;
	}
	public String getImpact() {
		return impact;
	}
	public void setImpact(String impact) {
		this.impact = impact;
	}
	public double getComplexityCoeff() {
		return complexityCoeff;
	}
	public void setComplexityCoeff() {
		if(complexity.equals("Simple")) {
			this.complexityCoeff= 1.0;
		}
		if(complexity.equals("Moderate")) {
			this.complexityCoeff= 1.2;
		}
		if(complexity.equals("Compound")) {
			this.complexityCoeff= 1.5;
		}
	}
	public double getImpactCoeff() {
		return impactCoeff;
	}
	public void setImpactCoeff() {
		if(impact.equals("Minimal")) {
			this.impactCoeff= 1.0;
		}
		if(impact.equals("Moderate")) {
			this.impactCoeff= 1.5;
		}
		if(impact.equals("Major")) {
			this.impactCoeff= 2.0;
		}
	}
	public List<Option> getOptions() {
		return options;
	}
	public void addOption(Option option) {
		this.options.add(option);
	}
	public Option calculateRandom() {
		Random rand = new Random();
		int n = rand.nextInt(this.options.size());
		return this.options.get(n-1);
		
	}
	public Result calculateWeighted() {
		
		List<Result> results = calcResults();
		double denominator = 0;
		for(Result each: results) {
			denominator+= each.getStrengthValue();
		}
		for(Result each: results) {
			each.setStrengthValue(each.getStrengthValue()/denominator);
		}
		int randomIndex = -1;
		double random = Math.random() * denominator;
		for (int i = 0; i < results.size(); ++i)
		{
		    random -= results.get(i).getStrengthValue();
		    if (random <= 0.0)
		    {
		        randomIndex = i;
		        break;
		    }
		}
		Result choice = results.get(randomIndex);
		return choice;
		
	}

	public Result calculateProbable() {
		Result choice = new Result();
		List<Result> results = calcResults();
		choice = results.get(0);
		double value = results.get(0).getStrengthValue();
			for(int i = 0; i<results.size(); i++) {
				if(results.get(i).getStrengthValue() > value) {
					choice = results.get(i);
				}
			}return choice;
	}
	
	private List<Result> calcResults() {
		
		List<Result> results = new ArrayList<>();
		for(Option option: this.options) {
			Result result = new Result();
			double conVal =0;
			double proVal =0;
			List<Con> cons = option.getCons();
			List<Pro> pros = option.getPros();
			for(Con con : cons) {
				conVal += con.getConVal();
			}
			for(Pro pro: pros) {
				proVal += pro.getProVal();
			}
			conVal = (conVal * this.impactCoeff) + (conVal * this.complexityCoeff);
			proVal = (proVal * this.impactCoeff) + (proVal * this.complexityCoeff);
			
			result.setName(option.getName());
			result.setStrengthValue(proVal-conVal);
			results.add(result);
		}
		return results;
	}
}
