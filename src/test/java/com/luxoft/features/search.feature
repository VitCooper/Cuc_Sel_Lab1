Feature: Google search
  Scenario Outline:
    Given we are on google main page
    When we enter the "<search_term>" and tap
    Then we see "<search_result>" in any of result in list
    And we see "<search_result>" in title of page

    Examples: Combinations of search terms and results
    | search_term | search_result |
    | Ramin Djawadi | Djawadi |
    | cats | cat |
    | R.Jones Jr | Roy Jones |