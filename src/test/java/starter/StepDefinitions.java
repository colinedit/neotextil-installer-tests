package starter;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.When;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import starter.navigation.Navigate;
import starter.volume.Volume;
import starter.files.Plugins;

public class StepDefinitions {

  ChromeDriver driver;
  Navigate nav;
  Volume vol = new Volume();
  Plugins plug = new Plugins();

  @Before
  public void i_open_the_installer() {
    vol.mount(vol.NT_SETUP_PATH);

    ChromeOptions opts = new ChromeOptions();
    opts.setBinary(
        "/Volumes/neoTextilSetup/Install neoTextil.app/Contents/MacOS/Install neoTextil");
    System.setProperty("webdriver.chrome.driver", "src/test/resources/webdriver/mac/chromedriver");
    driver = new ChromeDriver(opts);
  }

  @After
  public void quit() {
    driver.quit();
    vol.unmount(Volume.volumePath);
  }

  @When("^I click Next$")
  public void i_click_Next() {
    nav.click_next();
  }

  @When("^I agree$")
  public void i_agree() {
    nav.license_agree();
  }

  @When("^I select the Photoshop version \"([^\"]*)\"$")
  public void i_select_the_Photoshop_version(String arg1) {
    nav.select_photoshop_version(arg1);
  }

  @When("^I select the language \"([^\"]*)\"$")
  public void i_select_language(String arg1) {
    nav.select_language(arg1);
  }

  @When("^I close$")
  public void i_close() {
    nav.close();
  }

  @When("^the plug-ins are installed \"([^\"]*)\"$")
  public void the_plug_ins_are_installed(String arg1) {
    assert plug.currentVersionIsInstalled(arg1);
  }

  @When("^the previous version is backed up \"([^\"]*)\"$")
  public void the_previous_version_is_backed_up(String arg1) {
    assert plug.previousVersionIsBackedUp(arg1);
  }

  @When("^the panel is installed, with the old panel backed up$")
  public void the_panel_is_installed_with_the_old_panel_backed_up() {
    assert plug.panelIsBackedUpAndInstalled();
  }

  @When("^the user data has been initialized$")
  public void the_user_data_has_been_initialized() {
    assert plug.userDataIsInstalled();
  }
}
