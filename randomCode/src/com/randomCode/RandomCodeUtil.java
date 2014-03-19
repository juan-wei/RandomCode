package com.randomCode;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.filechooser.FileSystemView;

/**
 * @author Administrator
 * 随机码的生成
 * 随机码共三种类型：纯数字，纯大写字母，数字和大写字母的组合
 * 随机码的长度可控
 */
public class RandomCodeUtil {

	public RandomCodeUtil() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 生成指定类型指定长度的随机码
	 * @param type 指定随机码类型
	 * @param length 指定随机码长度
	 * @return 指定类型的随机码
	 */
	public ArrayList<RandomCode> generate(String type, int length, int nums){
		ArrayList<RandomCode> codes = new ArrayList<RandomCode>(nums);
		for (int i = 0; i<nums; i++) {
			
			codes.add(generateCode(type, length));
		}
		return codes;
	}
	private RandomCode generateCode(String type, int length){
		
		RandomCode code = null;
		if (type != null){
			if (type.equalsIgnoreCase("character")) {
				//生成纯字母随机码
				code = generateCharacterCode(length);
			}else if (type.equalsIgnoreCase("numeric")) {
				//生成纯数字随机码
				code = generateNumericCode(length);
			}else if (type.equalsIgnoreCase("mixture")) {
				//生成字母数字混合随机码
				code = generateCharacterNumericCode(length);
			}
		}
		return code;
	}
	public void saveCode(ArrayList<RandomCode> codes) {
		
		File file = new File(FileSystemView.getFileSystemView().getHomeDirectory(),"code.txt");
		if (file.exists() != true) {  
	            try {  
	                file.createNewFile();  
	            } catch (IOException e) {  
	                e.printStackTrace(); 
	            }  
	    }  
		try {
			FileWriter fileWriter = new FileWriter(file);
			BufferedWriter writer = new BufferedWriter(fileWriter);
			for (RandomCode randomCode : codes) {
				writer.write(randomCode.toString());
				writer.newLine();
				writer.flush();
				System.out.println(randomCode.toString());
			}
			writer.close();
			fileWriter.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * 指定长度的纯大写字母随机码
	 * @param length -- 随机码长度
	 * @return 纯大写字母随机码
	 */
	private RandomCode generateCharacterCode(int length){
		RandomCode characterCode = new CharacterCode(length);
		StringBuilder builder = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			builder.append((char)(random.nextInt(26)+65));
		}
		characterCode.setCode(builder.toString());
		return characterCode;
		
	}
	
	/**
	 * 指定长度的纯数字随机码
	 * @param length -- 随机码长度
	 * @return 纯数字随机码
	 */
	private RandomCode generateNumericCode(int length) {
		RandomCode numericCode = new NumericCode(length);
		StringBuilder builder = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			builder.append(random.nextInt(10));
		}
		numericCode.setCode(builder.toString());
		return numericCode;
	}
	
	/**
	 * 指定长度的大写字母与数字组合的随机码
	 * @param length -- 随机码长度
	 * @return 大写字母与数字组合的随机码
	 */
	private RandomCode generateCharacterNumericCode(int length) {
		RandomCode characterNumericCode = new CharacterNumericCode(length);
		StringBuilder builder = new StringBuilder();
		Random random1 = new Random();
		Random random2 = new Random();
		for (int i = 0; i < length; i++) {
			int index = random1.nextInt(2);
			switch (index) {
			case 0:
				builder.append(random2.nextInt(10));
				break;
			case 1:
				builder.append((char)(random2.nextInt(26)+65));
				break;
			default:
				break;
			}
		}
		characterNumericCode.setCode(builder.toString());
		return characterNumericCode;
	}
}
