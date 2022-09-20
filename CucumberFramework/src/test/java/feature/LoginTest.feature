Feature: Perform Mulitple Actions on Leaftaps WebPage

  Scenario Outline: Test Login page using multiple login credentials including negative credentials
    Given Browser is setup
    And Load the leaftaps webpage using "http://leaftaps.com/opentaps/"
    And maximize the webBrowser and set timeouts
    And Enter the <username> and <password> and click submit button
    And Check if we can land to home page <status>
    And Close Browser once test case passed


  Examples:
    | username            | password    | status      |
    | 'DemoSalesManager'  | 'crmsfa'    | 'positive'  |
    | 'negativeTest'      | 'passwrd'   | 'negative'  |