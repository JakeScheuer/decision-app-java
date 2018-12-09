package com.arthurthecat.model;

import java.util.List;

public class Option {
	
	private String optionName;
	private List<Pro> pros;
	private List<Con> cons;
	public String getName() {
		return optionName;
	}
	public void setOptionName(String name) {
		this.optionName = name;
	}
	public String getOptionName() {
		return this.optionName;
	}
	public List<Pro> getPros() {
		return pros;
	}
	public void setPros(List<Pro> pros) {
		this.pros = pros;
	}
	public List<Con> getCons() {
		return cons;
	}
	public void setCons(List<Con> cons) {
		this.cons = cons;
	}

	
}
