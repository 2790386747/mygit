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
        	 System.out.println("����������ѧ�ţ��Ա�����ȷ���������˲���:");
         studentNo = scan.nextLine();
         System.out.println("���������ľ�����:");
         oldPassword = scan.nextLine();
         System.out.println("����������������:");
         newfirstPassword = scan.nextLine();
         System.out.println("���ٴ��������������룬������Ҫ�ٴ�ȷ��:");
         newsecondPassword = scan.nextLine();
         if(newfirstPassword.equals(newsecondPassword)) {
        	 StudentBiz studentBiz = new StudentBiz();
         studentBiz.modifyPassword(studentNo,oldPassword,newfirstPassword); break;
         }
         else {
        	  System.out.println("����������������벻һ�£����������룺");
         }
         }
         
        
	}
}
