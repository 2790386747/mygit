package user;

public class Storage {
	private int[] cells=new int [10];
    private char inPos,outPos;
    private int count;
    public synchronized void put(int num){
   	 try{
   		 while (count==cells.length){
   			 this.wait ();
   			 
   		 }
   		 cells[inPos]=num;
   		 System.out.println("第"+cells[inPos]+"个用户登录");
   		 inPos++;
   		 if(inPos==cells.length)
   			 inPos=0;
   		 count++;
   		 this.notify();
   	 }catch(Exception e){
   		 e.printStackTrace();
   	 }
    }
    public synchronized void get(){
   	 try{
   		 while(count==0){
   			 this.wait();
   		 }
   		// int data=cells[outPos];
   		 System.out.println("第"+cells[inPos]+"个用户注销");
   		 outPos++;
   		 if(outPos==cells.length)
   			 outPos=0;
   		 count--;
   		 this.notify();
   	 }catch(Exception e){
   		 e.printStackTrace();
   	 }
    }
}



