package org.unify.framework.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.unify.model.enums.Unit;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductConfig {
    private String name;
    private BigDecimal price;
    private Double discount;
    private Unit unit;
}
