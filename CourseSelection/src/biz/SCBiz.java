package biz;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import dao.CourseDao;
import dao.SCDao;
import dao.StudentDao;
import entity.Course;
import entity.IEntity;
import entity.SC;
import entity.Student;

public class SCBiz{
	
//	CourseDao courseDao = CourseDao.getInstance();
	private SC sc;
  
	public void save() throws IOException{
		SCDao sCDao = SCDao.getInstance();
		sCDao.update1();
	}
	
  public void selection() throws IOException{
	  SCDao scDao = SCDao.getInstance();
	  CourseBiz courseBiz = new CourseBiz();
	  courseBiz.print();
	  Scanner scan = new Scanner(System.in);
	  System.out.println("����������ѧ�ţ��Ա�����ȷ���������˲�����");
	  String studentNo = scan.nextLine();
	  System.out.println("����������Ҫѡ��Ŀγ̱�ţ�");
	  String courseNo = scan.nextLine();
	  
	  sc = (SC)scDao.getEntity(studentNo);
	  if(sc==null) {
		  sc = new SC();
		  sc.setStudentNo(studentNo);
		  StringBuffer courseNo1 = new StringBuffer();
		  courseNo1.append(courseNo+",");
		  sc.setCourseNo(courseNo1);
	      CourseDao courseDao = (CourseDao)CourseDao.getInstance();
	      Course course = (Course)courseDao.getEntity(courseNo);
	      int grade = course.getCourseGrade();
		  sc.setGrade(grade);
		  scDao.insert(sc);
		  save();
	  }else {
		  CourseDao courseDao = CourseDao.getInstance();
		  StringBuffer s = new StringBuffer();
		  StringBuffer s1 = new StringBuffer();
		  s =sc.getCourseNo();
		  s1 =sc.getCourseNo();
		  String [] arr = s1.toString().split(",");
		  int flag=0;
		  for(int i=0;i<arr.length;i++) {
			  if(arr[i].equals(courseNo)) flag=1;
		  }
		  if(flag==0) {
			  s.append(courseNo+",");
		  sc.setCourseNo(s);
		  
		  
		  int a = sc.getGrade();
		  a=a+(((Course)courseDao.getEntity(courseNo)).getCourseGrade());
		  sc.setGrade(a);
		  scDao.insert(sc);
		  save();
		  }
		  else System.out.println("��Ǹ�����Ѿ�ѡ�����ſγ̣������ظ�ѡ��");
		  
	  } 
 }
 
  public void withdrawal() throws IOException{
	  SCDao scDao = SCDao.getInstance();
	  CourseDao courseDao = CourseDao.getInstance();
	  CourseBiz courseBiz = new CourseBiz();
	  courseBiz.print();
	  Scanner scan = new Scanner(System.in);
	  
	  System.out.println("����������ѧ�ţ��Ա�����ȷ���������˲�����");
	  String studentNo = scan.nextLine();
	  System.out.println("����������Ҫ��ѡ�Ŀγ̱�ţ�");
	  String courseNo = scan.nextLine();
	  
	  sc = (SC)scDao.getEntity(studentNo);
	  StringBuffer s = new StringBuffer();
	  s = sc.getCourseNo();
	  String[] arr = s.toString().split(",");
	  int flag=0;
	  for(int i=0;i<arr.length;i++) {
		  if(arr[i].equals(courseNo)) flag=1;
	  }
	  if(flag==0) {
		  System.out.println("����û��ѡ�����ſγ̣����ܽ�����ѡ������");
	  }
	  else {
		 s.delete(0, s.length());
		 for(int i=0;i<arr.length;i++) {
			 if(arr[i].equals(courseNo)) continue;
			 s.append(arr[i]+",");
		 }
		  int a = sc.getGrade();
		  a=a-(((Course)courseDao.getEntity(courseNo)).getCourseGrade());
		  sc.setGrade(a);
		  scDao.update1(sc);
		  save();
	  }
 }

  public static void showresult() throws FileNotFoundException{
	Scanner scan = new Scanner(System.in);
	System.out.println("�����������˵�ѧ�ţ��Ա������Ƕ�����ѡ�γ���ѡ�����Ϣ�Ĳ�ѯ:");
	String studentNo = scan.nextLine();
	SCDao scDao = SCDao.getInstance();
	SC sc = (SC)scDao.getEntity(studentNo);
	
	String[] courseNo = (sc.getCourseNo().toString()).split(",");
	System.out.println("����ǰ��ѡ�����¿γ̣���ϸ��Ϣ���£�");
	for(int i=0;i<courseNo.length;i++) {
		Course course = (Course)CourseDao.getInstance().getEntity(courseNo[i]);
		System.out.println("�γ̱��Ϊ"+course.getCourseNo()+",�γ�����Ϊ"+course.getCourseName()+",�γ�ѧ��Ϊ"+course.getCourseGrade());
	}
	
	System.out.println("���ϱ�������ǰ��ѡ�����пγ̵���Ϣ�����ϣ�����ǰ��ѡ��"+courseNo.length+"�ſΣ���ѧ��Ϊ"+sc.getGrade());
 }
}
