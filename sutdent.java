package student;

public class student {
	public static void main(String[] args) {
			System.out.println("1�����ѧ����Ϣ");
			add() ;
			System.out.println("2��ɾ��ѧ����Ϣ");
			remove() ;
			System.out.println("3���޸�ѧ����Ϣ");
			alter() ;
	}
public static void add(){
	StringBuffer sb= new StringBuffer(); 
	sb.append ("����");  
	System.out.println ("append��ӽ��:"+sb);
	sb.insert(0, "184805002"); 
	System.out.println("insert��ӽ��:"+sb);
    }
public static void remove(){
	StringBuffer sb= new StringBuffer("184805002����");
	sb.delete(2,7); 
	System.out.println("ɾ��ָ��λ�ý��:"+sb);
	sb.deleteCharAt(0);  
	System.out.println("ɾ��ָ��λ�ý��:"+sb);
	sb.delete(0, sb.length());
	System.out.println("��ջ��������:"+sb);
    }
public static void alter(){
	StringBuffer sb=new StringBuffer ("184805002����");
	sb.setCharAt (1,'6'); 
	System.out.println("�޸�ָ��λ�ý��:"+sb);
	sb.replace(1,3, "84"); 
	System.out.println("�滻ָ��λ�ý��:"+sb);
	}
}