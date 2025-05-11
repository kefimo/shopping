package org.unify.framework.bdd.steps;

import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.unify.model.Shop;
import org.unify.model.Stock;
import org.unify.model.exception.InvalidOperationException;
import org.unify.services.usecases.BasketServiceUseCase;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Slf4j
public class BasketTest {

    @Autowired
    private BasketServiceUseCase basketServiceUseCase;
    private String results;
    private Exception capturedException;

    @ParameterType("true|false") // Ajout du ParameterType dans les Steps
    public Boolean booleanValue(String value) {
        return Boolean.parseBoolean(value);
    }

    @Given("the stock is {booleanValue}")
    public void user_has_valid_token(Boolean validToken) {
        Stock stock = Shop.getStock();
        Assert.assertFalse(stock.products().isEmpty());
    }

    @When("the user enter his {string}")
    public void user_enters_valid_command(String input) throws Exception {
        try {
            var command = input.split("\\s+");
            results = basketServiceUseCase.shopping(command);
        }catch (Exception e) {
            this.capturedException = e;
        }
    }

    @Then("the result will be {string}")
    public void result_will_be(String result) throws Exception {
        log.info(this.results);
        Assert.assertEquals(result,results);
    }

  //  @Then("the result will throw an <exception> with <message>")
    @Then("the result will throw an {string} with {string}")
    public void the_result_will_be_an_exception(String expectedException, String expectedMessage) throws ClassNotFoundException {
        assertThat(capturedException)
                .isInstanceOf(Class.forName("org.unify.model.exception."+expectedException))
                .hasMessage(expectedMessage);
    }
}