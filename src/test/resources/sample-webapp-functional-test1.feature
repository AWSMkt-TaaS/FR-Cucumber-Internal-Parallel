@SPRINT100
Feature: Validate the web site pages
Navigate to the Test page.
Enter the values in two text boxes. 
Hit concatenate button to populate the result in the third textbox.
Validate the result populated is as expected.

  Scenario Outline: Test1 - Concatenate two strings in the Test page
    Given I am using app url in <targetbrowser> browser to navigate to the Test page
      And I have entered "abc" into the first text box
      And Then I have entered "def" into the second text box
     When I press concatenate button
     Then the result should be "abcdef" on the third text box 
  
  @FUNCTIONAL
    Examples: 
      | targetbrowser | 
      | ie            | 
      | chrome        |
    
  @SMOKE
  Examples: 
    | targetbrowser | 
    | ie            | 

    

   
 
    
   
