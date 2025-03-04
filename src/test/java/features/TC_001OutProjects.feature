Feature: Our Projects

  Scenario: Checking the Projects whether opening properly or not
    Given User launch the browser
    Then User navigates to the URL "https://adurigroup.com/"
    And User verify the page title as "Aduri Group - Most Trusted Real Estate Company in Hyderabad" visible successfully
    Then User clicks on each Image present on the WebPage under Our Projects
    Then User capture each page title of Opened window
    And User close the browser
