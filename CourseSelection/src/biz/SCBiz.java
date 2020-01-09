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
	  System.out.println("请输入您的学号，以便我们确认是您本人操作：");
	  String studentNo = scan.nextLine();
	  System.out.println("请输入您所要选择的课程编号：");
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
		  else System.out.println("抱歉，您已经选过该门课程，不能重复选择！");
		  
	  } 
 }
 
  public void withdrawal() throws IOException{
	  SCDao scDao = SCDao.getInstance();
	  CourseDao courseDao = CourseDao.getInstance();
	  CourseBiz courseBiz = new CourseBiz();
	  courseBiz.print();
	  Scanner scan = new Scanner(System.in);
	  
	  System.out.println("请输入您的学号，以便我们确认是您本人操作：");
	  String studentNo = scan.nextLine();
	  System.out.println("请输入您所要退选的课程编号：");
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
		  System.out.println("您还没有选过该门课程，不能进行退选操作！");
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
	System.out.println("请输入您本人的学号，以便于我们对您所选课程正选结果信息的查询:");
	String studentNo = scan.nextLine();
	SCDao scDao = SCDao.getInstance();
	SC sc = (SC)scDao.getEntity(studentNo);
	
	String[] courseNo = (sc.getCourseNo().toString()).split(",");
	System.out.println("您当前已选了如下课程，详细信息如下：");
	for(int i=0;i<courseNo.length;i++) {
		Course course = (Course)CourseDao.getInstance().getEntity(courseNo[i]);
		System.out.println("课程编号为"+course.getCourseNo()+",课程名称为"+course.getCourseName()+",课程学分为"+course.getCourseGrade());
	}
	
	System.out.println("以上便是您当前已选的所有课程的信息，综上，您当前已选了"+courseNo.length+"门课，总学分为"+sc.getGrade());
 }
}
