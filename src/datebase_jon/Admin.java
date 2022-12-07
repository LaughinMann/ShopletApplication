package datebase_jon;

/**
 * Admin User element
 * @author Kelvin Dhoman
 *
 */
public class Admin extends User {
	
	Boolean isAdmin;
	
	/**
	 * Constructor for an admin user
	 */
	public Admin()
	{
		super();
		isAdmin = true;
	}
	
	/**
	 * Function to cancel an order
	 * @param order the order to cancel.
	 */
	public void cancelorder(Order order)
	{
		
	}
	
	/**
	 * Approve a seller's account
	 * @param seller The seller account to approve.
	 */
	public void approveSeller(Seller seller)
	{
		
	}
	
	/**
	 * Deny a seller's account
	 * @param seller The seller account to deny.
	 */
	public void denySeller(Seller seller)
	{
		
	}
	
	/**
	 * Delete a review
	 * @param review The review to delete
	 */
	public void deleteReview(Review review)
	{
		
	}
	
	/**
	 * Create a user
	 * @param username The username to create a user with
	 * @param password The password for the new user
	 * @param email The email of the new user
	 * @return A user object that is created
	 */
	public User createUser(String username, String password, String email)
	{
		return null;
	}
}
