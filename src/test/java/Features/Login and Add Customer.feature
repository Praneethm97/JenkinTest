Feature: Login to nopCommerce application and add customer


  Scenario: Login to nopCommerce
    Given Instantiate browser and enter Url
    When Enter the "admin@yourstore.com" and "admin"
    Then  User click on the login

    Scenario: Add Customer
      Given Click on customersection
      And   Click on customer
      When  Click on Add
      Then  Enter email,password,Firstname,Lastname and Company
      And   Enter date
      Then  Select the gender
      And   click on save button
      Then  User gets the success message "Customer added successfully"

