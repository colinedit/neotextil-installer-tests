package starter;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.en.And;
import cucumber.api.java.Before;
import cucumber.api.java.After;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import starter.navigation.Navigate;

public class StepDefinitions {

  ChromeDriver driver;
  Navigate nav;

  @Before
  public void i_open_the_installer() {
    ChromeOptions opts = new ChromeOptions();
    opts.setBinary("/Volumes/neoTextilSetup/Install neoTextil.app/Contents/MacOS/Install neoTextil");
    System.setProperty("webdriver.chrome.driver", "src/test/resources/webdriver/mac/chromedriver");
    driver = new ChromeDriver(opts);
  }

  @When("^I click Next$")
  public void i_click_Next() {
    nav.click_next();
  }

  @When("^I agree$")
  public void i_agree() {
    nav.license_agree();
  }
  @When("^I select Photoshop$")
  public void i_select_photoshop_ver() {
    nav.select_photoshop_version();
  }
@When("^I close$")
public void i_close() {
  nav.close();
}

  @After
  public void quit() {
    driver.quit();
  }
}
