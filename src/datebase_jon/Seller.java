package datebase_jon;

public class Seller extends User {
	
	Integer seller_id;
	Boolean accountActive;
	Product[] sellerInventory;
	Double totalRevenue;

	public Seller()
	{
		super();
		seller_id = user_id;
		accountActive = approval;
	}
	
	public void updateItem(Product itemToEdit, Double newPrice, Integer newQuantity, String newDescription)
	{
		
	}
	
	public Product createNewItem()
	{
		return null;
	}
	
	public void deleteProduct(Product product)
	{
		
	}
	
	public void setSellerInventory()
	{

	}
	
	public Product[] getSellerInventory()
	{
		return sellerInventory;
	}
}
