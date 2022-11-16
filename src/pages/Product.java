package pages;
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

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getQuantity() {
        return availableQuantity;
    }

    public void setQuantity(Integer availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }
}
