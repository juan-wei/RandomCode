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
//		System.out.println("选择随机码类型：1——纯大写字母；2——纯数字；3——大写字母和数字混合");
//		Scanner scanner = new Scanner(System.in);
//		int type = scanner.nextInt();
//		int length = scanner.nextInt();
//		int nums = scanner.nextInt();
//		scanner.close();
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
