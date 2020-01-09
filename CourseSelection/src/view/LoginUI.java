package view;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import biz.StudentBiz;

public class LoginUI {	

	public static void show() throws IOException {
		Scanner scanner;
		String studentNo;
		String studentPassword;
		StudentBiz studentBiz;
		scanner = new Scanner(System.in);
		System.out.println("«Î ‰»Î—ß∫≈£∫");
		studentNo = scanner.nextLine();
		System.out.println("«Î ‰»Î√‹¬Î£∫");
		studentPassword = scanner.nextLine();
		
		studentBiz = new StudentBiz();
		studentBiz.login(studentNo, studentPassword);
	}
}
