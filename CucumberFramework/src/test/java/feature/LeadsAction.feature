Feature: Perform Mulitple Actions on Leaftaps WebPage like Create, Edit, Merge, Duplicate and Delete leads

Background: Call Browser and login to the portal
Given Browser is setup 
And Load the leaftaps webpage using "http://leaftaps.com/opentaps/"
And maximize the webBrowser and set timeouts
And Enter the username "DemoSalesManager" and password "crmsfa" and click submit button
And Click on crmsfa link and move to Leads tab

  Scenario: Test case to create a lead successfully
    Given Click on Create Leads link
    Then Enter the necessary details in the CreateLead form
    And Click Submit button and the lead should be created successfully.
    And Close Browser once test case passed

  Scenario:  Test case to edit a lead successfully
    Given Click on Find Leads link
    And Click on Phone
    And Pass "99" for Phone Number in the text box
    And Click on FindLead Button
    And Click first found data from the table
    Then Click on Edit link and update the existing company name to "TCS"
    And Click Submit button and the lead should be created successfully.
    And Close Browser once test case passed

  Scenario:  Test case to duplicate a lead successfully
    Given Click on Find Leads link
    And Click on Phone
    And Pass "99" for Phone Number in the text box
    And Click on FindLead Button
    And Click first found data from the table
    Then Click on Duplicate Lead link
    And Click Submit button and the lead should be created successfully.
    Then Close Browser once test case passed

  Scenario:  Test case to Merge a lead successfully
    Given Click on Merge Leads link
    And Click First lookup
    And Find using firstname as "Hari"
    And Click on FindLead Button
    Then Find first occurring lead ID from the table and click it
    And Switch Back to parent Window
    And Click Second lookup
    And Find using firstname as "babu"
    And Click on FindLead Button
    And Click First occurring lead ID and Click Merge
    Then Click on Find Leads link
    And Pass the first lead ID
    And Click on FindLead Button
    And Check if the lead ID exist or not
    Then Close Browser once test case passed

  Scenario:  Test case to Delete a lead successfully
    Given Click on Find Leads link
    And Click on Phone
    And Pass "9" for Phone Number in the text box
    And Click on FindLead Button
    And Find first occurring lead ID from the table and click it
    Then Click on Delete link
    And Click on Find Leads link
    And Pass the first lead ID
    And Click on FindLead Button
    And Check if the lead ID exist or not
    Then Close Browser once test case passed