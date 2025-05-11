package org.unify.services.usecases;

import org.unify.model.Product;



import java.util.List;

public interface DiscountStrategyUseCase {

    List<Product> updateDiscountProductByStrategyDiscount(String[] products);


}
