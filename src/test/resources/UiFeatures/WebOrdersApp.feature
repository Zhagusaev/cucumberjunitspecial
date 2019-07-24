@ui @WebOrders
Feature: Testing WebOrders Application


  @orders1
  Scenario: Verify create order module
    Given user logs in with credentials username "Tester" password "test"
    Then user clicks on Order
    Then User creates orders
      | Quantity | Customer name | Street | City       | Zip   | Card | Card Nr   | Expire Date |
      | 1        | James         | York   | Chicago    | 60001 | Visa | 123456789 | 01/22       |
      | 1        | Chris         | Devon  | Des Plains | 80001 | Visa | 876543212 | 03/24       |
      | 2        | Sarah         | Clark  | New York   | 63452 | Visa | 423123123 | 09/22       |
    Then User click on View Orders
    And User verifies that orders are created
      | Customers name |
      | James          |
      | Chris          |
      | Sarah          |

  @orders2
  Scenario: Verifying log in functionality with valid credentials
    Given user logs in with credentials username "Tester" password "test"
    Then verify user logs in to Web Order homepage

  @orders3
  Scenario: Verifying log in functionality with Invalid credentials
    Given user logs in with credentials username "Tester" password "testt"
    Then Verify user get error message "Invalid Login or Password."
