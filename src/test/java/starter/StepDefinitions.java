package starter;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.en.And;
import cucumber.api.java.Before;
import cucumber.api.java.After;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class StepDefinitions {

  ChromeDriver driver;

  @Before
  public void i_open_the_installer() {
    ChromeOptions opts = new ChromeOptions();
    opts.setBinary("/Volumes/neoTextilSetup/Install neoTextil.app/Contents/MacOS/Install neoTextil");
    System.setProperty("webdriver.chrome.driver", "src/test/resources/webdriver/mac/chromedriver");
    driver = new ChromeDriver(opts);
  }

  @When("^I click Next$")
  public void i_click_Next() {
    System.out.println("helo");
    try {
      Thread.sleep(1000);
    }
    catch (InterruptedException e) {}
  }

  @After
  public void quit() {
    driver.quit();
  }
}
