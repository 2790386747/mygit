package dao;
import java.util.*;
import java.io.*;
import entity.*;
public class CourseDao implements IDao {
	
	private static CourseDao instance;
	private HashMap<String, IEntity> courses= new HashMap<String, IEntity>();
	
	public CourseDao() {
	Course course1 = new Course();
	course1.setCourseNo("1");
	course1.setCourseName("概率论");
	course1.setCourseGrade(3);
	courses.put(course1.getCourseNo(),course1);
	
	Course course2 = new Course();
	course2.setCourseNo("2");
	course2.setCourseName("离散数学");
	course2.setCourseGrade(4);
	courses.put(course2.getCourseNo(),course2);
	
	Course course3 = new Course();
	course3.setCourseNo("3");
	course3.setCourseName("大学物理");
	course3.setCourseGrade(5);
	courses.put(course3.getCourseNo(),course3);
	
	Course course4 = new Course();
	course4.setCourseNo("4");
	course4.setCourseName("linux");
	course4.setCourseGrade(5);
	courses.put(course4.getCourseNo(),course4);
	}
	
	
	
	public static CourseDao getInstance() throws FileNotFoundException {
		if(instance == null) {
			synchronized(CourseDao.class) {
				if(instance == null) {
					instance = new CourseDao();
					return instance;
				}
			}
		}
		return instance;
	}
	
	
	@Override
	public void insert(IEntity entity) {
		// TODO Auto-generated method stub
		Course co = (Course)entity;
		courses.put(co.getCourseNo(), co);
//		update1();
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
        
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public HashMap<String, entity.IEntity> getAllEntities() {
		// TODO Auto-generated method stub
		return courses;
	}

	@Override
	public IEntity getEntity(String Id) {
		// TODO Auto-generated method stub
		
		return courses.get(Id);
	}

}
