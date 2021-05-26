Feature: Registration  verification for Oddsking
  As a User
  I want to register
  So i can play lotto.
  @Regression
  Scenario: Verify registration with valid inputs
    Given User is on homepage "https://www.oddsking.com/"
    When User enter details for registration
    Then User can see thanks for joining message


