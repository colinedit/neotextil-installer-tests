Feature: Installing neoTextil

  @Install
  Scenario Outline: Using the installation wizard
    When I click Next
    When I agree
    When I select the Photoshop version "<Version>"
    When I close
    Examples:
      | Version   |
      | 2020      |
