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
	//��¼
	public void login(String studentNo, String studentPassword) throws IOException {

		studentDao = StudentDao.getInstance();
		student = (Student) studentDao.getEntity(studentNo);
		if (student == null) {
			System.out.println("�û������ڣ������ѡ��");
			MainUI.main1();
		} else if (student.getStudentPassword().equals(studentPassword)) {
			System.out.println("��¼�ɹ��������������Ҫ��ѧ��ҵ�����˵��н���ѡ��");
			MainUI.show();
		} else {
			System.out.println("���벻��ȷ");
			MainUI.main1();
		}

	}
	public void save() throws IOException{
		StudentDao studentDao = StudentDao.getInstance();
		studentDao.update1();
	}
	//ע�ᣬҵ���߼�ʵ��
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
				System.out.println("���ѽ����ĸ�����Ϣ���Ƴɹ�������ȷ��������Ϣ�Ƿ���ȷ������Ķ��밴1���б��棬��Ķ��밴0�����޸ģ�");
				Scanner scan = new Scanner(System.in);
				String option  = scan.nextLine();
				switch(option){
				case "1": save(); System.out.println("��ϲ��ע��ɹ��������������Ҫ��ѧ��ҵ�����˵���ѡ��");
			 MainUI.main1();  break;
				case "0": flag=1; MainUI.main1(); break;
				}
			}
			
		}else {
			System.out.println("��������������벻һ��,������ѡ��");
			MainUI.main1();
		}
	}
	
	public void modifyPassword(String studentNo,String oldPassword,String newPassword) throws IOException{
		StudentDao studentDao = StudentDao.getInstance();
		student = (Student) studentDao.getEntity(studentNo);
		if (student == null) {
			System.out.println("�û������ڣ������ѡ��");
			MainUI.show();
		} else if (student.getStudentPassword().equals(oldPassword)) {
			student.setStudentPassword(newPassword);
			save();
			System.out.println("�����޸ĳɹ������ס����ǰ�޸ĵ�������,�Ա��������´ε�¼����������ҵ�����˵��м���ѡ��");
			MainUI.show();
		}else {
			System.out.println("������ľ����������û��Ȩ�޽����޸ģ�������ѡ��");
			MainUI.show();
		}
	}
	
}
