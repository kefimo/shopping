Pricing a basket: </br>

Write a program and associated unit tests that can price a basket of goods taking into
account some special offers.</br>
</br>
The goods that can be purchased, together with their normal prices are:</br>
• Soup – 65p per tin</br>
• Bread – 80p per loaf</br>
• Milk – £1.30 per bottle</br>
• Apples – £1.00 per bag</br>
Current special offers:</br>

• Apples have a 10% discount off their normal price this week</br>
• Buy 2 tins of soup and get a loaf of bread for half price</br>
The program should accept a list of items in the basket and output the subtotal, the
special offer discounts and the final price.</br>
Input should be via the command line in the form PriceBasket item1 item2 item3 …</br>
For example:</br>
PriceBasket Apples Milk Bread

Output should be to the console, for example:</br>
Subtotal: £3.10</br>
Apples 10% off: -10p</br>
Total: £3.00</br>
If no special offers are applicable the code should output :</br>
Subtotal: £1.30</br>
(No offers available)</br>
Total price: £1.30</br>
The code and design should meet these requirements, but be sufficiently flexible to</br>
allow future changes to the product list and/or discounts applied.</br>
The code should be well structured, commented, have error handling and be tested</br>



The project is structured as follows: bootstrap, framework, model, and service.

The project follows a hexagonal architecture,


Root|
    |-------bootstrap: contains main class to bootstrap the application </br>
    |-------framework: structured into four main components: bootstrap, framework, model, and service. The framework layer contains all implementations of the business use cases, while the framework layer integrates all external frameworks and technologies used in the project.</br>
    |-------model contains model of application, it should be</br>
    |-------services contains interfaces, or implementations of somes uses cases</br>