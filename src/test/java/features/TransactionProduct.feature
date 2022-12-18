Feature: Transaction product 

@product @Android
Scenario Outline: User buy the product
Given Open the list product page
When User choose the "<product>"
And Validate product on detail product page
And User input criteria to "<color>" and "<quantity>" product
Then Tap add cart button
And Validate product on My Cart Page
Then Log in account to proceed payment
And Fill shipping address
And Fill account payment
And Validate checkout deliver data
Then Validate success buy product

  Examples:
    |product				|color		|quantity	|
    |Sauce Lab Back Packs  	|Blue		|2			|