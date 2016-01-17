package com.coding_exercise.primefacestuff;

import org.springframework.stereotype.Component;

@Component("editor")
public class EditorBean {
	
	public EditorBean() {}

	private String value = "This editor is provided by PrimeFaces";

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}