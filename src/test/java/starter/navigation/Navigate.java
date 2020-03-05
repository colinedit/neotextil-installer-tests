package starter.navigation;

import org.openqa.selenium.By;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

public class Navigate extends PageObject {

  public void click_next() {
    find(By.id("welcome-next-agreement")).click();
  }
  public void license_agree() {
    find(By.id("agreement-checkbox")).click();
    find(By.id("agreement-next-destination")).click();
  }
  public void select_photoshop_version() {
    find(By.xpath("/html/body/div[2]/div/div/div/section/div[2]/div[2]/div/span/a")).click();
    find(By.id("desination-back-installation")).click();
  }
  public void close() {
    long frequencyMs = 250;
    boolean done = false;

    while (!done) {
      try {
        Thread.sleep(frequencyMs); // This frequency is arbitrary
        done = find(By.id("summary-close"))
          .isPresent();
        // System.out.println("[WAIT] " + frequencyMs + "ms.");
        frequencyMs *= 1.618;
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
