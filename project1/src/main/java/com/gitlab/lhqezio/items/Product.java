package com.gitlab.lhqezio.items;

public abstract class Product extends Item {
    private double price;
    private int quantity;
    private String description;
    private double discount;
    private int cartQuantity;

    public Product(String name, String manufacturer, double price, double discount, int quantity, String description, String id) {
        super(name, manufacturer, description, id);
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.discount = discount;
        this.cartQuantity = 0;
    }

    public double getPrice() {
        return price;
    }

    ;

    public int getQuantity() {
        return quantity;
    }

    ;

    public String getDescription() {
        return description;
    }

    ;

    public double getDiscount() {
        return discount;
    }

    ;

    @Override
    public String toString() {
        return getManufacturer() + " " + getName() + "\n" + Math.round(getPrice()) +"$  NOW ONLY: "+ Math.round(getPrice()-getDiscount())+"$\n"+getDiscountPercentage()+"% OFF"+ "\n" + getDescription() + "\n";
    }

    public abstract String getCategory();

    public double getDiscountPercentage() {
        return Math.ceil((getDiscount() / getPrice()) * 100);
    }

    public int discountCompareTo(Product other) {
        return this.getDiscountPercentage() < other.getDiscountPercentage() ? 1 : -1;
    }
}

