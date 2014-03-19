package com.randomCode;

//import java.util.Scanner;


public class CodeTest {

	public CodeTest() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int type = Integer.parseInt(args[0]);
		int length = Integer.parseInt(args[1]);
		int nums = Integer.parseInt(args[2]);

		String typesString = null;
		switch (type) {
		case 1:
			typesString = "character";
			break;
		case 2:
			typesString = "numeric";
			break;
		case 3:
			typesString = "mixture";
			break;
		default:
			break;
		}
		RandomCodeUtil util = new RandomCodeUtil();
		util.saveCode(util.generate(typesString, length,nums));
	}

}
