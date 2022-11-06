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
