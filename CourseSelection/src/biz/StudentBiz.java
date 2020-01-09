package biz;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import dao.StudentDao;
import entity.IEntity;
import entity.Student;
import view.MainUI;
public class StudentBiz {
	StudentDao studentDao;
	private Student student;
	//登录
	public void login(String studentNo, String studentPassword) throws IOException {

		studentDao = StudentDao.getInstance();
		student = (Student) studentDao.getEntity(studentNo);
		if (student == null) {
			System.out.println("用户不存在，请继续选择：");
			MainUI.main1();
		} else if (student.getStudentPassword().equals(studentPassword)) {
			System.out.println("登录成功，请根据您的需要在学生业务主菜单中进行选择：");
			MainUI.show();
		} else {
			System.out.println("密码不正确");
			MainUI.main1();
		}

	}
	public void save() throws IOException{
		StudentDao studentDao = StudentDao.getInstance();
		studentDao.update1();
	}
	//注册，业务逻辑实现
	public void register(String studentNo, 
						String studentName, 
						String studentGender, 
						int studentAge, 
						String studentDepartment, 
						String firstPassword, 
						String secondPassword) throws IOException {
		if(firstPassword.equals(secondPassword)) {
			student = new Student();
			student.setStudentNo(studentNo);
			student.setStudentName(studentName);
			student.setStudentGender(studentGender);
			student.setStudentAge(studentAge);
			student.setStudentDepartment(studentDepartment);
			student.setStudentPassword(firstPassword);
			
			studentDao = StudentDao.getInstance();
			
			studentDao.insert(student);
			int flag=0;
			while(true){
				if(flag==1) break;
				System.out.println("您已将您的个人信息完善成功，请您确认您的信息是否正确，不需改动请按1进行保存，需改动请按0进行修改：");
				Scanner scan = new Scanner(System.in);
				String option  = scan.nextLine();
				switch(option){
				case "1": save(); System.out.println("恭喜您注册成功！请根据您的需要在学生业务主菜单中选择：");
			 MainUI.main1();  break;
				case "0": flag=1; MainUI.main1(); break;
				}
			}
			
		}else {
			System.out.println("您两次输入的密码不一致,请重新选择");
			MainUI.main1();
		}
	}
	
	public void modifyPassword(String studentNo,String oldPassword,String newPassword) throws IOException{
		StudentDao studentDao = StudentDao.getInstance();
		student = (Student) studentDao.getEntity(studentNo);
		if (student == null) {
			System.out.println("用户不存在，请继续选择：");
			MainUI.show();
		} else if (student.getStudentPassword().equals(oldPassword)) {
			student.setStudentPassword(newPassword);
			save();
			System.out.println("您已修改成功，请记住您当前修改的新密码,以便于您的下次登录！请在嘘声业务主菜单中继续选择：");
			MainUI.show();
		}else {
			System.out.println("您输入的旧密码错误，您没有权限进行修改，请重新选择：");
			MainUI.show();
		}
	}
	
}
