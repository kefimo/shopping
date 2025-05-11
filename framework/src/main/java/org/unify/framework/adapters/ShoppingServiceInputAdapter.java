package org.unify.framework.adapters;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.unify.services.usecases.BasketServiceUseCase;
import org.unify.services.usecases.ShoppingServiceUseCase;

import javax.management.OperationsException;
import java.io.IOException;
import java.util.Scanner;


@Slf4j
@RequiredArgsConstructor
@Configuration
@Profile("!test")
public class ShoppingServiceInputAdapter  implements ShoppingServiceUseCase{
    protected final BasketServiceUseCase basketServiceUseCase;

    @EventListener(ApplicationReadyEvent.class)
    @Override
    public void cashRegister() throws IOException, OperationsException {
        log.info("**********************************************************");
        log.info("******************** CASH REGISTER STARTED****************");
        log.info("**********************************************************");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            log.info("Entrez les articles à ajouter au panier. Tapez 'stop' pour terminer.");
            String input = scanner.nextLine().trim();
            var command= input.split("\\s+");
            if ("stop".equalsIgnoreCase(input)) {
                break;
            }
            if (!input.isEmpty()) {
               String result = basketServiceUseCase.shopping(command);
               log.info(result);
            } else {
                log.info("L'article est vide, veuillez entrer un article valide.");
            }
        }
        scanner.close();
    }
}
