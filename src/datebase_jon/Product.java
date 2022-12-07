package datebase_jon;

public class Product {
    public Integer product_id;
    public Integer seller_id;
    public Integer amount_sold;
    public String name;
    public Integer price;
    public boolean available;
    public Integer availableQuantity;
    public boolean discountCodeActive;
    public String discountCode;
    public Double discountPercentage;
    public String description;
    
    /**
     * Default Constructor
     */
    public Product()
    {
    	
    }

    /**
     * A Product Item that will be created by GUI and then sent to the database.
     * @param associatedSellerId The Seller ID.
     * @param productName The Product Name.
     * @param productPrice the Product Price.
     * @param productDescription The Product description.
     * @param available If available or not.
     * @param availableQuantity The available quantity.
     * @param discountCodeActive If a discount code exists for the product.
     */
    public Product(Integer productId, String productName, Integer productPrice, String productDescription, boolean available, Integer availableQuantity, boolean discountCodeActive)
    {
    	this.product_id = productId;
        this.name = productName;
        this.description = productDescription;
        this.price = productPrice;
        this.available = available;
        this.availableQuantity = availableQuantity;
        this.discountCodeActive = discountCodeActive;
    }

    /**
     * Returns the product price.
     * @return Product price
     */
    public Integer getProductPrice() {
        return price;
    }

    /**
     * Sets the product's price
     * @param productPrice The new product price.
     */
    public void setProductPrice(Integer productPrice) {
        this.price = productPrice;
    }

    /**
     * Returns the item's available quantity.
     * @return The quantity of the item available.
     */
    public Integer getQuantity() {
        return availableQuantity;
    }

    /**
     * Set the quantity of the item available.
     * @param availableQuantity The available quantity.
     */
    public void setQuantity(Integer availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    /**
     * Gets the product description.
     * @return Returns the product description.
     */
    public String getProductDescription() {
        return description;
    }

    /**
     * Sets the product description of the product.
     * @param productDescription The product description.
     */
    public void setProductDescription(String productDescription) {
        this.description = productDescription;
    }
}
