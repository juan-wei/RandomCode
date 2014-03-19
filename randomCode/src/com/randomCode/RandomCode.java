package com.randomCode;

public class RandomCode {

	private String codeType;
	private int length;
	private String code;
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public RandomCode() {
		// TODO Auto-generated constructor stub
	}
	
	public  RandomCode(String type) {
		super();
		codeType = type;
	}
	
	public RandomCode(String codeType, int length) {
		super();
		this.codeType = codeType;
		this.length = length;
	}

	public String getCodeType() {
		return codeType;
	}

	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return code;
	}
}
