package pages_kelvin;

/**
 * A Product class representation
 * @author Kelvin Dhoman
 *
 */
public class Product {
    public Integer productId;
    public Integer associatedSellerId;
    public String productName;
    public Double productPrice;
    public boolean available;
    public Integer availableQuantity;
    public boolean discountCodeActive;
    public String discountCode;
    public Double discountPercentage;
    public String productDescription;

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
    public Product(Integer associatedSellerId, String productName, Double productPrice, String productDescription, boolean available, Integer availableQuantity, boolean discountCodeActive)
    {
        this.associatedSellerId = associatedSellerId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.available = available;
        this.availableQuantity = availableQuantity;
        this.discountCodeActive = discountCodeActive;
    }

    /**
     * Returns the product price.
     * @return Product price
     */
    public Double getProductPrice() {
        return productPrice;
    }

    /**
     * Sets the product's price
     * @param productPrice The new product price.
     */
    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
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
        return productDescription;
    }

    /**
     * Sets the product description of the product.
     * @param productDescription The product description.
     */
    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }
}
