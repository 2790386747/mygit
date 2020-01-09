package dao;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import entity.*;
public class SCDao implements IDao {
	private static SCDao instance;
	private HashMap<String, IEntity> scs = new HashMap<String, IEntity>();
	
	private SC sc;
	
	//���Ӵ��ļ���ȡ�Ĺ���
			private SCDao() throws FileNotFoundException {
				getUsersFromInputStream("sc.txt");
			}
			
			public void processUserString(String userString) {

				String[] userFields = userString.split("/");
				SC u = new SC();
//				System.out.println(userFields.length+"***");
//				for(int i=0;i<userFields.length;i++){
//					System.out.println(userFields[i]);
//				}
//				System.out.println("*****");
				u.setStudentNo(userFields[0]);
				u.setGrade(Integer.parseInt(userFields[1]));
				StringBuffer s = new StringBuffer();
				s.append(userFields[2]);
				u.setCourseNo(s);
				scs.put(u.getStudentNo(), u);
				
//				u.s(userFields[0]);
//				u.setCardPwd(userFields[1]);
//				u.setUserName(userFields[2]);
//				u.setCall(userFields[3]);
//				u.setAccount(Integer.parseInt(userFields[4]));
//				users.put(u.getCardId(), u);

			}
	//
			//��ȡ�ļ�����InputStream����ʽ��ȡ
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
			
			// ���̲���
			public void update1() throws IOException {
				Set<String> userSet = scs.keySet();
				StringBuffer uStringBuffer = new StringBuffer();
				for (String cardId : userSet) {
					SC u = (SC) scs.get(cardId);
					String uString =  u.getStudentNo() + "/" +u.getGrade() + "/" + u.getCourseNo()  
					+ "\r\n";
					
//					String uString =  "ѧ��ѧ�ţ�"+u.getStudentNo() + "|" + "ѧ����ѧ�֣�" +u.getGrade() + "|" +"ѧ����ѡ�����пγ̣�"+ u.getCourseNo()  
//							+ "\r\n";
					uStringBuffer.append(uString);
				}
				putUserToFile(uStringBuffer.toString(), "sc.txt");
			}
			
			// д���ļ��ĺ���
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
	
	public static SCDao getInstance() throws FileNotFoundException {
		if(instance == null) {
			synchronized(SCDao.class) {
				if(instance == null) {
					instance = new SCDao();
					return instance;
				}
			}
		}
		return instance;
	}
	
	@Override
	public void insert(IEntity ientity) {
		// TODO Auto-generated method stub
          scs.put(((SC)ientity).getStudentNo(),(SC)ientity);
          System.out.println("��ϲ������ѡ�ɹ����������ѡ�����˵���ѡ����Ҫ���еĲ�����");
	}
	
	
	@Override
	public void delete() {
		// TODO Auto-generated method stub
		 
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
   
	}
	
	public void update1(IEntity ientity) {
		// TODO Auto-generated method stub
		scs.put(((SC)ientity).getStudentNo(),(SC)ientity);
        System.out.println("��ϲ������ѡ�ɹ����������ѡ�����˵���ѡ����Ҫ���еĲ�����");
	}

	@Override
	public HashMap<String, IEntity> getAllEntities() {
		// TODO Auto-generated method stub
		return scs;
	}

	@Override
	public IEntity getEntity(String Id) {
		// TODO Auto-generated method stub
		return scs.get(Id);
	}

}
