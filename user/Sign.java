package user;

public class Sign implements Runnable{
    private Storage st;
    private char num;
    Sign(Storage st){
  	  this.st=st;
    }
    public void run(){
  	  while(true){
  		  st.put(num++);
  	  }
    }
}
