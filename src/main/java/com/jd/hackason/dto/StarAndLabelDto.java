package com.jd.hackason.dto;

import java.util.Arrays;

public class StarAndLabelDto {
	private int star;
	private String[] label_names;
	public int getStar() {
		return star;
	}
	public void setStar(int star) {
		this.star = star;
	}
	public String[] getLabel_names() {
		return label_names;
	}
	public void setLabel_names(String[] label_names) {
		this.label_names = label_names;
	}
	@Override
	public String toString() {
		return "StarAndLabelDto [star=" + star + ", label_names=" + Arrays.toString(label_names) + "]";
	}
	
	
}
