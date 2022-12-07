package datebase_jon;

public class Admin extends User {
	
	Boolean isAdmin;
	
	public Admin()
	{
		super();
		isAdmin = true;
	}
	
	public void cancelorder(Order order)
	{
		
	}
	
	public void approveSeller(Seller seller)
	{
		
	}
	
	public void denySeller(Seller seller)
	{
		
	}
	
	public void deleteReview(Review review)
	{
		
	}
	
	public User createUser(String username, String password, String email)
	{
		return null;
	}
}
