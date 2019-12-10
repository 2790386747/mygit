package 模拟银行存取款系统;

public class User {
	private String cardId;  //卡号
	private String cardPwd;  //密码
	private String userName;  //帐户名
	private String call;  //手机号
	private int account;  //存款额
	public String getCardId(){
		return cardId;
	} 
	public void setCardId (String cardId){
		this.cardId= cardId;
	}
	public String getCardPwd(){
		return cardPwd;
	}
	public void setCardPwd(String cardPwd){
	  this.cardPwd	=cardPwd;
		
	}
	public String getUserName(){
		return userName;
		
	}
	public void setUserName(String userName){
	   this.userName =userName;
		
	}
	public String getCall(){
		return userName;
		
	}
	public void setCall(String call){
		this.call = call;
	}
	public int getAccount(){
		return account;
	}
	public void setAccount(int account){
		this.account = account;
	}
}
