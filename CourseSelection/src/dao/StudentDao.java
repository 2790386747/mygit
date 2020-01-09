package dao;
import entity.IEntity;
import entity.Student;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Set;





public class StudentDao implements IDao {

	private static StudentDao instance;
	private HashMap<String, IEntity> students= new HashMap<String, IEntity>();
	private Student student= new Student();
	
	 //增加从文件读取的功能
		private StudentDao() throws FileNotFoundException {
			getUsersFromInputStream("student.txt");
		}
		
		public void processUserString(String userString) {

			String[] userFields = userString.split(",");
			Student u = new Student();
//			System.out.println(userFields.length+"***");
//			for(int i=0;i<userFields.length;i++){
//				System.out.println(userFields[i]);
//			}
//			System.out.println("*****");
			u.setStudentNo(userFields[0]);
			u.setStudentName(userFields[1]);
			u.setStudentGender(userFields[2]);
			u.setStudentAge(Integer.parseInt(userFields[3]));
			u.setStudentDepartment(userFields[4]);
			u.setStudentPassword(userFields[5]);
			students.put(u.getStudentNo(), u);
			
//			u.s(userFields[0]);
//			u.setCardPwd(userFields[1]);
//			u.setUserName(userFields[2]);
//			u.setCall(userFields[3]);
//			u.setAccount(Integer.parseInt(userFields[4]));
//			users.put(u.getCardId(), u);

		}
//
		//读取文件，以InputStream的形式读取
		private void getUsersFromInputStream(String isName) throws FileNotFoundException {

			FileInputStream fs = new FileInputStream(isName);
			byte[] content = new byte[1024];
			int i = 0;
			int conInteger = 0;
			while (true) {
				try {
					conInteger = fs.read();
				} catch (IOException e) {
					e.printStackTrace();
				}
				if (-1 == conInteger) {
					break;
				} else if ('\r' == (char) conInteger || '\n' == (char) conInteger) {
					try {
						this.processUserString(new String(content, "GBK").trim());
						i = 0;
					} catch (UnsupportedEncodingException e) {
						e.getStackTrace();
					}
					continue;
				} else {
					content[i] = (byte) conInteger;
					i++;
				}
			}
		}
//		
		
		// 存盘操作
		public void update1() throws IOException {
			Set<String> userSet = students.keySet();
			StringBuffer uStringBuffer = new StringBuffer();
			for (String cardId : userSet) {
				Student u = (Student) students.get(cardId);
//				System.out.println(u.getStudentNo()+"*****");
				String uString = u.getStudentNo() + "," + u.getStudentName() + "," + u.getStudentGender() + "," + u.getStudentAge() + ","
						+ u.getStudentDepartment() +","  + u.getStudentPassword()+ ","+"\r\n";
				uStringBuffer.append(uString);
			}
			putUserToFile(uStringBuffer.toString(), "student.txt");
		}
		
		// 写入文件的函数
		private void putUserToFile(String uString, String osName) throws IOException {
			try {
				FileOutputStream fos = new FileOutputStream(osName);
				try {
					fos.write(uString.getBytes("GBK"));
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}

			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
	
		
		
		public static StudentDao getInstance() throws FileNotFoundException {
			if (instance == null) {
				synchronized (StudentDao.class) {
					if (instance == null) {
						instance = new StudentDao();
					}
				}
			}
			return instance;
		}
//	public static StudentDao getInstance() {
//		if(instance == null) {
//			synchronized(StudentDao.class) {
//				if(instance == null) {
//					instance = new StudentDao();
//					return instance;
//				}
//			}
//		}
//		return instance;
//	}
	@Override
	public void insert(IEntity entity) {
		// TODO Auto-generated method stub
		Student st = (Student)entity;
		students.put(st.getStudentNo(), st);
		
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
	public HashMap<String, IEntity> getAllEntities() {
		// TODO Auto-generated method stub
		return students;
	}

	@Override
	public IEntity getEntity(String Id) {
		// TODO Auto-generated method stub		
		return students.get(Id);
	}

}
