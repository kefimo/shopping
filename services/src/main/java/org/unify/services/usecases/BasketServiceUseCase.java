package org.unify.services.usecases;

import org.unify.model.Shop;
import org.unify.model.Stock;

import javax.management.OperationsException;

public interface BasketServiceUseCase {

     Stock stock = Shop.getStock();
     String shopping(String[] list) throws OperationsException;

}
