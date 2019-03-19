package com.ceac.easystudy.po;

import java.io.Serializable;

public class ResultMsg implements Serializable {

	public ResultMsg() {
	}

	public ResultMsg(int code, String info) {

		this.statusCode = code;
		this.info = info;
	}

	public ResultMsg(int code, String info, Object data) {

		this.statusCode = code;
		this.info = info;
		this.data = data;
	}

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1774820608415929789L;

	private int statusCode;
	private String info;
	private Object data;

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
