Feature: Book A Filght Ticket with LowCost
  Scenario Outline: Check for the low cost and book a ticket
    Given Navigate to <url>
    When Select DepatureCity
    And Select ArrivalCity
    And Select Depature Date And return Date
    Then Search for the city
    Examples:
      | url                       |
      |https://www.makemytrip.com/|
