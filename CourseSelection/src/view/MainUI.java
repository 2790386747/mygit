package view;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
public class MainUI {
	public static void main(String[] args) throws IOException{
		Scanner scan = new Scanner(System.in);
		System.out.println("��ӭ����ѧ��ѡ����վ�������������Ҫ����վ��ҳ�н���ѡ�����ǽ�Ϊ������");
		System.out.println("----------��վ��ҳ----------");
		System.out.println("|                         |");
		System.out.println("|1-��¼;   2-ע��;  3-�˳�;  |");
		System.out.println("|                         |");
		System.out.println("--------------------------");
		
		
		System.out.println("����������ѡ��ı�ţ�");
		String a = scan.nextLine();
		switch(a){
		case "1":
			LoginUI.show(); 
			break;
		case "2":
			RegisterUI.show();
			break;
		case "3":
			break;
			}
	}
	
	public static void main1() throws IOException{
		Scanner scan = new Scanner(System.in);
		System.out.println("��ӭ����ѧ��ѡ����վ�������������Ҫ����վ��ҳ�н���ѡ�����ǽ�Ϊ������");
		System.out.println("----------��վ��ҳ----------");
		System.out.println("|                         |");
		System.out.println("|1-��¼;   2-ע��;  3-�˳�;  |");
		System.out.println("|                         |");
		System.out.println("--------------------------");
		
		
		System.out.println("����������ѡ��ı�ţ�");
		String a = scan.nextLine();
		switch(a){
		case "1":
			LoginUI.show(); 
			break;
		case "2":
			RegisterUI.show();
			break;
		case "3":
			System.out.println("�����˳�����վ����л���ı���ʹ�ã�");
			break;
			}
	}
	public static void show() throws IOException {
		System.out.println(" ����������������������ѧ��ҵ�����˵���������������������������");
		System.out.println("|                                  |");
//		System.out.println("|1-ע�᣻2-�޸����룻3-ѡ�Σ�4-��¼��0-�˳�  |");
		System.out.println("|      2-�޸����룻  3-ѡ�Σ�                0-�˳�  |");
		System.out.println("|                                  |");
		System.out.println(" �������������������������������������������������������������������� ");
		Scanner scanner = new Scanner(System.in);
		String option = scanner.nextLine();
		switch (option) {
//		case "1":
//			RegisterUI.show();
//			break;
		case "2":
			ModifyPasswordUI.show();
			break;
		case "3":
            CourseSelection.courseSelection();
			break;
//		case "4":  
//		     LoginUI.show();  
//		     break;
		case "0":
			System.out.println("��ӭ���ı���ʹ�ã����Ѿ��ɹ��˳������˺ţ���ӭ�����´�ʹ�ã�");
			MainUI.main1();
			break;
		}
		
	}
}
