package org.unify.framework.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.unify.services.port.BasketServiceInputPort;
import org.unify.services.usecases.BasketServiceUseCase;

@Configuration
public class BasketServiceInputPortConfiguration {

    @Bean
    public BasketServiceUseCase basketServiceUseCase()
    {
        return new BasketServiceInputPort();
    }

}
