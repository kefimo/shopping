package org.unify.model;

import org.unify.model.enums.Unit;
import java.math.BigDecimal;
import java.math.RoundingMode;

public record Product(String name, BigDecimal price, Double discount, Unit unit) {

    public BigDecimal getDiscountAmount()
    {
        return this.price.multiply(new BigDecimal(discount)).divide(new BigDecimal(100), 2, RoundingMode.UNNECESSARY);
    }
    public BigDecimal calculateFinalPrice() {
        return this.price.subtract(getDiscountAmount());
    }

    public boolean isSoup()
    {
        return "Soup".equalsIgnoreCase(name);
    }


    @Override
    public String toString() {
        return name+" - "+price+"£ per "+unit.getValue()+"\n";
    }


    public String displayWithDiscount() {
        return name+" "+discount+" % off: -"+getDiscountAmount()+" \n";
    }
}