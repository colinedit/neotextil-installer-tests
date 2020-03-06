package starter.navigation;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class Navigate extends PageObject {

  public void click_next() {
    find(By.id("welcome-next-agreement")).click();
  }

  public void license_agree() {
    find(By.id("agreement-checkbox")).click();
    find(By.id("agreement-next-destination")).click();
  }

  public void select_photoshop_version(String photoshopVersion) {
    find(By.xpath(".//*[text()[contains(.,\"" + photoshopVersion + "\")]]")).click();
    find(By.id("desination-back-installation")).click();
  }

  public void close() {
    long frequencyMs = 100;
    boolean done = false;

    while (!done) {
      try {
        Thread.sleep(frequencyMs); // This frequency is arbitrary
        done = find(By.id("summary-close")).isPresent();
        // System.out.println("[WAIT] " + frequencyMs + "ms.");
        frequencyMs *= 1.1;
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    find(By.id("summary-close")).click();
  }

  public void select_language(String lang) {
    Select dropdown = new Select(find(By.id("language-select")));
    dropdown.getOptions().stream()
        .filter(option -> option.getAttribute("value").toLowerCase().contains(lang.toLowerCase()))
        .findFirst()
        .ifPresent(option -> dropdown.selectByValue(option.getAttribute("value")));
  }
}
