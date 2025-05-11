package org.unify.framework.adapters;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.unify.framework.config.StockConfig;
import org.unify.model.Product;
import org.unify.model.Shop;
import org.unify.model.Stock;
import org.unify.services.usecases.StockInitializerUseCase;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class StockInitializerInputAdapter implements StockInitializerUseCase {

    private final StockConfig stockConfig;

    @EventListener(ContextRefreshedEvent.class)
    public void init()
    {
        var productModels= stockConfig.getProducts().stream().map(products -> new Product(products.getName(),products.getPrice(),products.getDiscount(),products.getUnit())).toList();
        Stock stock = new Stock(productModels);
        Shop.initStock(stock);
        log.info("******************** Here is the list of available products: ********************");
        log.info("******************** Thank you for selecting the products online: ***************");
        log.info("******************** For example: PriceBasket Apples Milk Bread ******************");
        productModels.forEach(product -> log.info(product.toString()));
    }
}