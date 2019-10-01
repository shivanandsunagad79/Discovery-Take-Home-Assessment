#Author: shivanand sunagad
@homeTask
Feature: See popular shows in discovery app
  Scenario: See all popular shows and write its title and duration to a text file
    Given I want to navigate to discovery app to see popular shows
    When I go to last video to explore it
    And I verify the more shows available and few are added
    Then create a new text file and write all show title and its duration