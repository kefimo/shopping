package org.unify.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Basket {


    private  List<Product> products = new ArrayList<>();

    public Basket(List<Product> products)
    {
        this.products.addAll(products);
    }
    public void updateProductAfterCalculateDiscount(List<Product> products)
    {
        this.products.clear();
        this.products.addAll(products);
    }
    public void updateDiscountProduct()
    {
        var productsUpdated= this.products.stream().map(product ->
                switch(product.name().toLowerCase())
                {
                    case "bread" ->  updateDiscountCaseBread(product);
                    case "apple" -> updateDiscountCaseApple(product);
                    default -> product;
                }).toList();

        this.updateProductAfterCalculateDiscount(productsUpdated);
    }

    public Product updateDiscountCaseBread(Product product)
    {
        var counts = this.products.stream().filter(Product::isSoup).count();
        if(counts>1)
            return new Product(product.name(),product.price(),50d,product.unit());
        else
            return product;
    }

    public Product updateDiscountCaseApple(Product product)
    {
      return new Product(product.name(),product.price(),10d,product.unit());
    }

    public BigDecimal calculateDiscount() {
        return products.stream().map(Product::getDiscountAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal calculateSubtotals() {
        return products.stream().map(Product::price)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal calculateTotals() {
        return products.stream()
                .map(product -> {
                    if (product.discount() != 0)
                        return product.calculateFinalPrice();
                    return product.price();
                })
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public String display() {
        var subTotal = calculateSubtotals();
        StringBuilder sb = new StringBuilder();
        sb.append("Subtotal: £").append(subTotal).append("\n");
        if(calculateDiscount().compareTo(BigDecimal.ZERO)>0)
        {
            products.stream().filter(product -> product.discount()>0).forEach(product -> sb.append(product.displayWithDiscount()));
        }else{
            sb.append("(No offers available)").append("\n");
        }

        sb.append("Total price: £").append(calculateTotals()).append("\n");
        return sb.toString();
    }
}
