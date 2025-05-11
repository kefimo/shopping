Feature: User Login

  Scenario Outline: Good shopping experience
    Given the stock is <initialized>
    When the user enter his <command>
    Then the result will be <result>
    Examples:
      | initialized | command                                   | result                                                                                       |
      | true        | "PriceBasket Apples Milk Bread"           | "Subtotal: £3.1\nApples 10.0 % off: -0.10 \nTotal price: £3.00\n"                            |
      | true        | "PriceBasket Apples Milk Bread soup soup" | "Subtotal: £4.40\nApples 10.0 % off: -0.10 \nBread 50.0 % off: -0.40 \nTotal price: £3.90\n" |
      | true        | "PriceBasket Milk Bread"                  | "Subtotal: £2.1\n(No offers available)\nTotal price: £2.1\n"                                 |

  Scenario Outline: BAD shopping experience
    Given the stock is <initialized>
    When the user enter his <command>
    Then the result will throw an <exception> with <message>
    Examples:
      | initialized | command            | exception                   | message                                                      |
      | true        | "ANYTHING Apples"  | "InvalidOperationException" | "The operation 'ANYTHING' does not exist or is not allowed." |
      | true        | "PriceBasket Guda" | "ProductNotFoundException"  | "Product not found: Guda"                                    |