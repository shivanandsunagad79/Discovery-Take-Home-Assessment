#Author: shivanand sunagad
@homeTask
Feature: See all shows in discovery app

  Scenario Outline: See all shows and validate favorite or unfavorite titles under “FAVORITE SHOWS”
    Given I want to navigate to discovery app to see all shows
    When I select shows title contain "<showsTitle>" shows in show tab
    And I verify the selected "<showsTitle>" shows favorites status and set unfavorite to favorite and vice versa
    Then validate the favorite or unfavorite shows under “FAVORITE SHOWS” in My Videos collection

    Examples: 
      | showsTitle |
      | APOLLO     |
