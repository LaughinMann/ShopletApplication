package pages;
import java.util.ArrayList;

public class Cart {
    public ArrayList<Product> itemsInCart;
    public Double subTotal;
    public Double totalPrice;
    public Double totalTax;

    private static Cart _instance = null;
    
    private Cart()
    {
    	this.itemsInCart = new ArrayList<Product>();
        this.subTotal = 0.0;
        this.totalPrice = 0.0;
        this.totalTax = 0.0;
    }
    
    public static Cart getInstance()
    {
    	if (_instance == null)
    		_instance = new Cart();
    	
    	return _instance;
    }
    
    public void addProduct(Product productToAdd)
    {
    	itemsInCart.add(productToAdd);
    	System.out.println("ITEMS NOW IN CART: " + itemsInCart.size());
    }
    
    public int getProductInCartCount()
    {
    	return itemsInCart.size();
    }

    void removeProductFromCart(Product product)
    {
        for (int i = 0; i < itemsInCart.size(); i++)
        {
            if (itemsInCart.get(i) == product)
            {
                itemsInCart.remove(product);
            }
        }
    }

    public Double calculatePreTaxTotal()
    {
        double tempTotal = 0.0;

        for (Product product : itemsInCart) {
            tempTotal += product.getProductPrice();
        }

        return tempTotal;
    }
    
    public Double calculateTaxTotal()
    {
    	return calculatePreTaxTotal() * 0.06;
    }
    
    public Double calculateGrandTotal()
    {
    	return calculatePreTaxTotal() + calculateTaxTotal();
    }
}
