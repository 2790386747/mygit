package user;

public class Example11 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		//System.out.println("3");
        Storage st=new Storage();
        Sign input=new Sign(st);
        Delete output=new Delete(st);
        new Thread(input).start();
        new Thread(output).start();
	}

}