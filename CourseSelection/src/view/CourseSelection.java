package view;
import java.util.*;

import biz.SCBiz;

import java.io.*;
public class CourseSelection {
	
//	private static final String String = null;

	//选课的主页
    public static void courseSelection() throws IOException{
    	Scanner scan = new Scanner(System.in);
    	int flag=0;
    	while(true) {
    		if(flag==1) break;
    	System.out.println("欢迎进入选课系统,请根据您的需要在选课主菜单中进行选择：");
    	System.out.println("************选课主菜单***********");
    	System.out.println("*                             *");
		System.out.println("*1-正选; 2-退选; 3-正选结果;4- 退出*");
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
		System.out.println("您已退出选课系统，请根据您的需要输入您所要进行的操作");
		MainUI.show();
			break;
		}
    	}
		
	}
}
