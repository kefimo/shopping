package org.unify.services.port;

import org.unify.model.Basket;
import org.unify.model.Product;
import org.unify.model.exception.InvalidOperationException;
import org.unify.services.usecases.BasketServiceUseCase;

import java.util.Arrays;
import java.util.List;
import static org.unify.model.enums.Commands.PRICEBASKET;
public class BasketServiceInputPort implements BasketServiceUseCase {


    @Override
    public String shopping(String[] lines) {
        var command = lines[0];

        String[] products = new String[lines.length - 1];
       if(PRICEBASKET.name().equalsIgnoreCase(command)){
                System.arraycopy(lines, 1, products, 0, lines.length - 1);
                List<Product> productsBasket = Arrays.stream(products).map(stock::getProductByName).toList();
                Basket basket = new Basket(productsBasket);
                basket.updateDiscountProduct();
                return basket.display();
        }
       throw new InvalidOperationException(command);
    }
}

