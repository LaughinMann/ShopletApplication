package pages_kelvin;
import java.util.ArrayList;

/**
 * Singleton class representing a user's cart.
 * @author Kelvin Dhoman
 *
 */
public class Cart {
	
	// Variables
    public ArrayList<Product> itemsInCart;
    public Double subTotal;
    public Double totalPrice;
    public Double totalTax;

    private static Cart _instance = null;
    
    /**
     * Private constructor for the cart
     */
    private Cart()
    {
    	this.itemsInCart = new ArrayList<Product>();
        this.subTotal = 0.0;
        this.totalPrice = 0.0;
        this.totalTax = 0.0;
    }
    
    /**
     * Retrieves the singleton instance of a Cart object.
     * @return The current user's cart.
     */
    public static Cart getInstance()
    {
    	if (_instance == null)
    		_instance = new Cart();
    	
    	return _instance;
    }
    
    /**
     * Add a product to the user's cart.
     * @param productToAdd The product to add to the cart.
     */
    public void addProduct(Product productToAdd)
    {
    	itemsInCart.add(productToAdd);
    	System.out.println("ITEMS NOW IN CART: " + itemsInCart.size());
    }
    
    /**
     * Retrieves the user's cart size.
     * @return An int value of the size of the cart.
     */
    public int getCartSize()
    {
    	return itemsInCart.size();
    }

    void removeProductFromCart(String productName)
    {
    	Product targetProductToRemove = null;
    	
        for (int i = 0; i < itemsInCart.size(); i++)
        {
            if (itemsInCart.get(i).productName == productName)
            {
            	targetProductToRemove = itemsInCart.get(i);
                itemsInCart.remove(targetProductToRemove);
            }
        }
    }
    
    /**
     * Calculates the total of the user's cart before tax is applied.
     * @return The double value of the user's cart cost before tax.
     */
    public Double calculatePreTaxTotal()
    {
        double tempTotal = 0.0;

        for (Product product : itemsInCart) {
            tempTotal += product.getProductPrice();
        }

        return tempTotal;
    }
    
    /**
     * Calculates the tax amount alone not grand total.
     * @return The tax amount of the cart.
     */
    public Double calculateTaxTotal()
    {
    	return calculatePreTaxTotal() * 0.06;
    }
    
    /**
     * Calculates the grand total of the whole cart with amount and tax combined.
     * @return The grand total of the cost of the cart.
     */
    public Double calculateGrandTotal()
    {
    	return calculatePreTaxTotal() + calculateTaxTotal();
    }
}
