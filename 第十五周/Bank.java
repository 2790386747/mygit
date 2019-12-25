package 银行系统IO流;

import java.util.Scanner;	

public class Bank {
	int account;
    private static User user;
    
    public static void main(String[] args){
 	   Bank b = new Bank();
 	   b.login();
 	   b.operate();
    }
    //账户金额存入、取出、查询
    public void operate(){
 	   Bank b = new Bank();
 	   while (true){
 		   System.out.println("请输入您要进行的操作类型，按回车键结束");
 		   System.out.println("存款：1" + "\t" + " 取款： 2" + "\t" + "余额：3" +"退出：0");
 		   //系统输入
 		   Scanner in = new Scanner(System .in);
 		   String s = in.nextLine();//输入的操作类型
 		   if("1".equals(s)||"2".equals(s)){
 			   int num = 0;
 			   try{
 				   System.out.print("输入存取金额： ");
 				   num = Integer.parseInt(in.nextLine());
 			   }catch(Exception e){
 				   System.out.println("金额输入错误！");
 				   continue;
 			   }
 			   
 			   switch(s){
 			   case "1"://存款
 				   b.income(num);
 				   break;
 			   case"2"://取款
 				   b.takeout(num);
 				   break;
 			   }
 		   }else if ("3".equals(s)){
 			   b.show();
 		   }else if ("0".equals(s)){
 			   System.out.println("退出系统！");
 			   return;
 		   }else{
 			   System.out.println("请输入0~3之间的数字选择相关操作！");
 		   }
 	   }
    }
    //用户登录网上银行
    public void login(){
 	   DBUtil dbutil = DBUtil.getInstance();
 	   Bank b = new Bank();
 	   System.out.println("------------欢迎进入网上银行！--------------");
 	   System.out.println("请输入您的选择  1-注册      0-退出");
 	   Scanner in = new Scanner (System.in);
 	   String s = in.nextLine();
 	   if("1".equals(s)){
 		   b.register();
 		   b.save();
 		   System.out.println("注册成功！");
 	   }
 	   while(true){
 		   System.out.println("请输入银行卡号：");
 		   String cardId = in.nextLine();
 		   System.out.println("请输入银行卡密码：");
 		   String cardPwd = in.nextLine();
 		   user = dbutil.getUser(cardId);
 		   //目录
 		   if(dbutil.getUsers().containsKey(cardId)
 		       &&user.getCardPwd().equals(cardPwd)){
 			   System.out.println("登陆成功！欢迎" + user.getUserName() + "女士/先生");
 			   break;
 		   }else{
 			   System.out.println("银行卡号或密码错误！");
 			   continue;
 		   }
 	   }
    }
    //注册
    public void register(){
    	User u=new User();
		Scanner scanner=new Scanner(System.in);
		System.out.println("输入卡号：");
		u.setCardId(scanner.nextLine());
		System.out.println("输入用户名：");
		u.setUserName(scanner.nextLine());
		System.out.println("输入密码：");
		u.setCardPwd(scanner.nextLine());
		System.out.println("输入手机号：");
		u.setCall(scanner.nextLine());
		System.out.println("输入金额：");
		u.setAccount(scanner.nextInt());
		DBUtil dbUtil=DBUtil.getInstance();	
		dbUtil.addUser(u);
	}
    public void save(){
    	DBUtil dbUtil=DBUtil.getInstance();
		dbUtil.update();
    }
    //存款
    public void income(int num){
   	 account = user.getAccount() + num;
   	 user.setAccount(account);
   	 System.out.println("存入金额" + num + "元成功！");
    }
    //取款
    public void takeout(int num){
   	 if(user.getAccount() >= num){
   		 account = user.getAccount() - num;
   		 user.setAccount(account);
   		 System.out.println("取出金额" + num + "元成功！");
   	 }else{
   		 System.out.println("金额不足，取款失败");
   	 }
    }
    //查询余额
    public void show(){
   	 account = user.getAccount();
		System.out.println("账户总余额为" + account + "元");
    }
    
}
