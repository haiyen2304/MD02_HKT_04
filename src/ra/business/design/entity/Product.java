package ra.business.design.entity;

import ra.business.design.validate.ProductValidate;

import java.util.Scanner;

public class Product implements IModel{
    private String productId;
    private String productName;
    private double productPrice;
    private String productDescription;
    private int stock;
    private Catalog catalog;
    private Boolean status=true;

    public Product() {}

    public Product(String productId, String productName, double productPrice, String productDescription, int stock, Catalog catalog, Boolean status) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
        this.stock = stock;
        this.catalog = catalog;
        this.status = status;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public void inputData(Scanner sc) {
        if (this.getProductId() == null || this.getProductId().isEmpty()) {
            this.productId = ProductValidate.inputProductId(sc);
        }
        this.productName = ProductValidate.inputProductName(sc);
        this.productPrice = ProductValidate.inputProductPrice(sc);
        this.productDescription = ProductValidate.inputProductDescription(sc);
        this.stock = ProductValidate.inputProductStock(sc);
        this.catalog = ProductValidate.inputCatalog(sc);
        this.status = ProductValidate.inputProductStatus(sc);

    }

    @Override
    public void displayData() {
        System.out.printf("[ ID: %-5s | Name: %-15s | Price: %-10f | Description: %-20s | Stock: %-5d | Catalog: %-5s | Status: %-5s ]\n",
                this.productId,
                this.productName,
                this.productPrice,
                this.productDescription,
                this.stock,
                this.catalog,
                this.status?"Sell": "Not for sale");
    }
}
