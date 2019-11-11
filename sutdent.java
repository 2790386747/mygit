package student;

public class student {
	public static void main(String[] args) {
			System.out.println("1、添加学生信息");
			add() ;
			System.out.println("2、删除学生信息");
			remove() ;
			System.out.println("3、修改学生信息");
			alter() ;
	}
public static void add(){
	StringBuffer sb= new StringBuffer(); 
	sb.append ("陈愉");  
	System.out.println ("append添加结果:"+sb);
	sb.insert(0, "184805002"); 
	System.out.println("insert添加结果:"+sb);
    }
public static void remove(){
	StringBuffer sb= new StringBuffer("184805002陈愉");
	sb.delete(2,7); 
	System.out.println("删除指定位置结果:"+sb);
	sb.deleteCharAt(0);  
	System.out.println("删除指定位置结果:"+sb);
	sb.delete(0, sb.length());
	System.out.println("清空缓冲区结果:"+sb);
    }
public static void alter(){
	StringBuffer sb=new StringBuffer ("184805002陈愉");
	sb.setCharAt (1,'6'); 
	System.out.println("修改指定位置结果:"+sb);
	sb.replace(1,3, "84"); 
	System.out.println("替换指定位置结果:"+sb);
	}
}