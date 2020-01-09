package view;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import biz.StudentBiz;

public class ModifyPasswordUI {
	public static void show() throws IOException {
         Scanner scan = new Scanner(System.in);
         String studentNo;
         String oldPassword;
         String newfirstPassword;
         String newsecondPassword;
         while(true){
        	 System.out.println("请输入您的学号，以便我们确认是您本人操作:");
         studentNo = scan.nextLine();
         System.out.println("请输入您的旧密码:");
         oldPassword = scan.nextLine();
         System.out.println("请输入您的新密码:");
         newfirstPassword = scan.nextLine();
         System.out.println("请再次输入您的新密码，我们需要再次确认:");
         newsecondPassword = scan.nextLine();
         if(newfirstPassword.equals(newsecondPassword)) {
        	 StudentBiz studentBiz = new StudentBiz();
         studentBiz.modifyPassword(studentNo,oldPassword,newfirstPassword); break;
         }
         else {
        	  System.out.println("您两次输入的新密码不一致，请重新输入：");
         }
         }
         
        
	}
}
