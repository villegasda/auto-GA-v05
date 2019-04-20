# verify the certain functionality of Upgrade website.
# The use cases are twofold (web and API).
Feature: Web and Api Challenge

  Scenario: Verify via the UI that as a borrower - you are seeing loan offers, upon filling the required form fields
  with valid inputs.
    Given the 'Credit Tech' page is loaded
      And fill $"2000" 'Load Amount' field in 'Apply for a personal loan' page
      And choose "Pay off Credit Cards" option of 'Load Purpose' dropdown in 'Apply for a personal loan' page
      And click 'Check your Rate' button in 'Apply for a personal loan' page
    When fill 'Fist Name' first name field in 'Credit Card' page
      And fill 'Last Name' last name field in 'Credit Card' page
      And fill "Morro Drive, Nevada City, CA 95959, US" home address field in 'Credit Card' page
      And fill "California" city field in 'Credit Card' page
      And fill "CA" state field in 'Credit Card' page
      And fill "90010" zip code field in 'Credit Card' page
      And fill "01/01/2000" date of birth field in 'Credit Card' page
      And fill $"100000" individual annual income field in 'Credit Card' page
      And fill $"5000" additional annual income field in 'Credit Card' page
      And fill random 'Email' email address field in 'Credit Card' page
      And fill "Testing@challenge123" field in 'Credit Card' page
      And check 'Terms of Use' field in 'Credit Card' page
      And click 'Check your Rate' button in 'Credit Card' page
    When getting 'Your Loan Amount' value in 'Offer' top page
      And getting 'ARP' value in 'Offer' top page
      #the following 'Loan Term' field I could not find in the UI web site
#      And getting 'Loan Term' value in 'Offer' top page
      And getting 'Monthly Payment' value in 'Offer' top page
      And click 'Sign Out' in the top right corner in 'Offer' top page
    When the 'Login Credit Terch' page is loaded
      And fill 'Credentials' created in 'Login' page
    Then validate 'Loan Amount' match with info previously in 'Offer' top page
      And validate 'ARP' match with info previously in 'Offer' top page
      #Not found field
#      And validate 'Loan Term' match with info previously in 'Offer' top page
      And validate 'Monthly Payment' match with info previously in 'Offer' top page


#  API : Write a test that makes a GET request to the API mentioned in the user story and does the
#  following using the response content (include any other validations that you deem necessary):
  Scenario: GET request to validate its content
    Given GET CreateApi endpoint is configured
    Then the status code should be 200
      ## I dont have a valid list about the names
      #And Validate all the state names returned are valid,
      And validate total states count is "48"
      And Validate only one state has a min age of 19
      And Validate that "Alabama" should be the 'label' of the state that has a min age of 19
      And Validate that "Georgia" is the only state with min loan amount requirement of $3005