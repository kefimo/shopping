package org.unify.services.usecases;

import javax.management.OperationsException;
import java.io.IOException;

public interface ShoppingServiceUseCase {

    void cashRegister() throws IOException, OperationsException;
}
