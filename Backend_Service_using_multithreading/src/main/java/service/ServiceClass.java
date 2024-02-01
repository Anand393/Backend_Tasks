package service;
import java.util.concurrent.CompletableFuture;
public class ServiceClass {
	
	public CompletableFuture<String> asyncMethod(){
		
		return CompletableFuture.supplyAsync(() -> {
			
			try {
				
				Thread.sleep(1000);
				
			} catch (InterruptedException e) {
				
				Thread.currentThread().interrupt();
				// TODO: handle exception
			}
			
			return "Thread completed !!!";
		});
		
	}

}
