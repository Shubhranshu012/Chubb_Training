
public class ToBeSent {
	private String recipient;
	
	ToBeSent(String x){
		this.recipient=x;
	}
	void check() throws NotFoundException{
		
		//db check
		boolean found=false;
		if(found) {
			
		}
		else {
			throw new NotFoundException("User Not Found");
		}
		
	}
	void Update(int amount) {
		//update the Amount in the db also
	}
}
