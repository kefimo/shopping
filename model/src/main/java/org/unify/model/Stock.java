package org.unify.model;


import org.unify.model.exception.ProductNotFoundException;

import java.util.List;


public record Stock (List<Product> products){


    public Product getProductByName(String name)
    {
       return products.stream()
                    .filter(product -> product.name().equalsIgnoreCase(name))
                    .findFirst()
                    .orElseThrow( () -> new ProductNotFoundException("Product not found: " + name));

    }

}
