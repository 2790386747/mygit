package biz;
import java.util.*;
import java.io.*;
import dao.*;
import entity.Course;


public class CourseBiz {
	
     public static void print() throws FileNotFoundException{
    	 CourseDao courseDao = CourseDao.getInstance();
//    	 CourseDao courseDao = new CourseDao();
    	 Set keySet = courseDao.getAllEntities().keySet();
    	 Iterator it = keySet.iterator();
    	     System.out.println("------------�����ѧ�ڿ�ѡ�γ��б�------------");
    	 while(it.hasNext()){
    		 Object key = it.next();
    		 Course value = (Course)courseDao.getAllEntities().get(key);
    		 System.out.println("*�γ̱�ţ�"+key+"------�γ����ƣ�"+value.getCourseName()+"-----�γ�ѧ�֣�"+value.getCourseGrade()+"*");
    	 }
    	     System.out.println("----------------------------------------");
     }
}
