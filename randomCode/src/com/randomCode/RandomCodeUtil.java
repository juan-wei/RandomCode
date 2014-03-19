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
 * ����������
 * ����빲�������ͣ������֣�����д��ĸ�����ֺʹ�д��ĸ�����
 * �����ĳ��ȿɿ�
 */
public class RandomCodeUtil {

	public RandomCodeUtil() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * ����ָ������ָ�����ȵ������
	 * @param type ָ�����������
	 * @param length ָ������볤��
	 * @return ָ�����͵������
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
				//���ɴ���ĸ�����
				code = generateCharacterCode(length);
			}else if (type.equalsIgnoreCase("numeric")) {
				//���ɴ����������
				code = generateNumericCode(length);
			}else if (type.equalsIgnoreCase("mixture")) {
				//������ĸ���ֻ�������
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
	 * ָ�����ȵĴ���д��ĸ�����
	 * @param length -- ����볤��
	 * @return ����д��ĸ�����
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
	 * ָ�����ȵĴ����������
	 * @param length -- ����볤��
	 * @return �����������
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
	 * ָ�����ȵĴ�д��ĸ��������ϵ������
	 * @param length -- ����볤��
	 * @return ��д��ĸ��������ϵ������
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
