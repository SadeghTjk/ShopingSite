package com.shadow.shopingsite;

public class Product {
    String pname;
    int price;
    int id;
    int checked;
    
    public Product(){}

    public Product(String pname, int price, int id, int checked) {
        this.pname = pname;
        this.price = price;
        this.id = id;
        this.checked = checked;
    }

    public String getProductName() {
        return pname;
    }

    public int getProductPrice() {
        return price;
    }

    public int getProductId() {
        return id;
    }

    public int getProductChecked() {
        return checked;
    }



    public void setProductName(String pname) {
        this.pname = pname;
    }

    public void setProductPrice(int price) {
        this.price = price;
    }

    public void setProductId(int id) {
        this.id = id;
    }

    public void setProductChecked(int checked) {
        this.checked = checked;
    }
}
