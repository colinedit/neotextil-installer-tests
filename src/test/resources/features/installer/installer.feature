Feature: Installing neoTextil

  @Install
  Scenario Outline: Using the installation wizard
    When I select the language "<Lang>"
    When I click Next
    When I agree
    When I select the Photoshop version "<Version>"
    When I close
    Examples:
      | Lang  | Version |
      | ca-ca | 2020    |
      | de-de | 2020    |
      | en-en | 2020    |
      | es-es | 2020    |
      | fr-fr | 2020    |
      | it-it | 2020    |
      | pt-pt | 2020    |
      | zh-zh | 2020    |
