package view;
import java.util.*;

import biz.SCBiz;

import java.io.*;
public class CourseSelection {
	
//	private static final String String = null;

	//ѡ�ε���ҳ
    public static void courseSelection() throws IOException{
    	Scanner scan = new Scanner(System.in);
    	int flag=0;
    	while(true) {
    		if(flag==1) break;
    	System.out.println("��ӭ����ѡ��ϵͳ,�����������Ҫ��ѡ�����˵��н���ѡ��");
    	System.out.println("************ѡ�����˵�***********");
    	System.out.println("*                             *");
		System.out.println("*1-��ѡ; 2-��ѡ; 3-��ѡ���;4- �˳�*");
		System.out.println("*                             *");
		System.out.println("*******************************");
		
		String option = scan.nextLine();
		SCBiz scBiz = new SCBiz();
		switch(option){
		case "1":
			scBiz.selection();
			break;
			
		case "2":
			scBiz.withdrawal();
			break;
			
		case "3":
			scBiz.showresult();
			break;
			
		case "4": flag=1;
		System.out.println("�����˳�ѡ��ϵͳ�������������Ҫ��������Ҫ���еĲ���");
		MainUI.show();
			break;
		}
    	}
		
	}
}
