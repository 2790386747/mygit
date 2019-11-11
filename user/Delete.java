package user;

public class Delete implements Runnable{
	private Storage st;
	Delete(Storage st){
		this.st=st;
		
	}
	public void run(){
		while(true){
			st.get();
			try{
				Thread.sleep(1000);
			} catch(InterruptedException e){
			e.printStackTrace();
		}
	}

}
}
