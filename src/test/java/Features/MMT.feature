Feature: Book A Filght Ticket with LowCost
  @FlightAvalabilty
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



