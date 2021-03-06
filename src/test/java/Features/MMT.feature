Feature: Book A Filght Ticket with LowCost
  Scenario Outline: Check for the Flight Avalabilty
    Given Navigate to <url>
    When Select DepatureCity
    And Select ArrivalCity
    And Select Depature Date
    Then Select the No of travellers
    And Select Class of Travelling
    And Select Type of Fare
    And Search for the flights
    Examples:
      | url                       |
      |https://www.makemytrip.com/|
    Scenario: Select the lowest cost flight()
      Given wait for the page to load
      When get The price of each flight
      Then select the lowest cost flight

