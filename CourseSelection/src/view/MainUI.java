package view;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
public class MainUI {
	public static void main(String[] args) throws IOException{
		Scanner scan = new Scanner(System.in);
		System.out.println("欢迎来到学生选课网站，请根据您的需要在网站主页中进行选择，我们将为您服务：");
		System.out.println("----------网站主页----------");
		System.out.println("|                         |");
		System.out.println("|1-登录;   2-注册;  3-退出;  |");
		System.out.println("|                         |");
		System.out.println("--------------------------");
		
		
		System.out.println("请输入您所选择的编号：");
		String a = scan.nextLine();
		switch(a){
		case "1":
			LoginUI.show(); 
			break;
		case "2":
			RegisterUI.show();
			break;
		case "3":
			break;
			}
	}
	
	public static void main1() throws IOException{
		Scanner scan = new Scanner(System.in);
		System.out.println("欢迎来到学生选课网站，请根据您的需要在网站主页中进行选择，我们将为您服务：");
		System.out.println("----------网站主页----------");
		System.out.println("|                         |");
		System.out.println("|1-登录;   2-注册;  3-退出;  |");
		System.out.println("|                         |");
		System.out.println("--------------------------");
		
		
		System.out.println("请输入您所选择的编号：");
		String a = scan.nextLine();
		switch(a){
		case "1":
			LoginUI.show(); 
			break;
		case "2":
			RegisterUI.show();
			break;
		case "3":
			System.out.println("您已退出该网站，感谢您的本次使用！");
			break;
			}
	}
	public static void show() throws IOException {
		System.out.println(" ———————————学生业务主菜单—————————————");
		System.out.println("|                                  |");
//		System.out.println("|1-注册；2-修改密码；3-选课；4-登录；0-退出  |");
		System.out.println("|      2-修改密码；  3-选课；                0-退出  |");
		System.out.println("|                                  |");
		System.out.println(" —————————————————————————————————— ");
		Scanner scanner = new Scanner(System.in);
		String option = scanner.nextLine();
		switch (option) {
//		case "1":
//			RegisterUI.show();
//			break;
		case "2":
			ModifyPasswordUI.show();
			break;
		case "3":
            CourseSelection.courseSelection();
			break;
//		case "4":  
//		     LoginUI.show();  
//		     break;
		case "0":
			System.out.println("欢迎您的本次使用，您已经成功退出您的账号，欢迎您的下次使用！");
			MainUI.main1();
			break;
		}
		
	}
}
