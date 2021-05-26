Feature: Irish lotto verification
  As a user
  iI want to search lotto result
  So i can see lotto result as per date selection
  @Smoke
  Scenario: Verify Irish lotto result
    Given User is on homepage "https://www.oddsking.com/lotto/irish"
    When User click on result and select date and click filter button
    Then User can see result between selected date

