package org.unify.framework.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "stock")
@Data
public class StockConfig {
    List<ProductConfig> products;
}
