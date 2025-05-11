package org.unify.framework.configuration;


import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.unify.framework.adapters.ShoppingServiceInputAdapter;
import org.unify.services.usecases.BasketServiceUseCase;
import org.unify.services.usecases.ShoppingServiceUseCase;

import java.io.IOException;
import java.util.Scanner;


@Slf4j
@Configuration
@Profile("test")
@RequiredArgsConstructor
public class ShoppingServiceInputAdapterTest implements ShoppingServiceUseCase {

    private final BasketServiceUseCase basketServiceUseCase;

    @EventListener(ApplicationReadyEvent.class)
    @Override
    public void cashRegister() throws IOException {
        log.info("**********************************************************");
        log.info("********** CASH REGISTER STARTED IN TEST MODE *************");
        log.info("**********************************************************");
        log.info("**************DISABLE SYSTEM IN *****************");
    }
}
