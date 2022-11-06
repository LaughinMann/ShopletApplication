import java.util.ArrayList;

public class Cart {
    public ArrayList<Product> itemsInCart;
    public Double subTotal;
    public Double totalPrice;
    public Double totalTax;

    public Cart()
    {
        this.subTotal = 0.0;
        this.totalPrice = 0.0;
        this.totalTax = 0.0;
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

    public Double calculateTotal()
    {
        double tempTotal = 0.0;

        for (Product product : itemsInCart) {
            tempTotal += product.getProductPrice();
        }

        return tempTotal;
    }
}
