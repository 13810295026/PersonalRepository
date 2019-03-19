package com.ceac.easystudy.mockexercises.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OptionContent {

	@JsonProperty(value = "No")
	private String no;
	@JsonProperty(value = "Type")
	private String type;
	@JsonProperty(value = "Value")
	private String value;

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
