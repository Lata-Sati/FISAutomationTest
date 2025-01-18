
package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageBaseClass {
  WebDriver driver;
  public PageBaseClass(WebDriver driver){
    this.driver=driver;
    PageFactory.initElements(driver, this);
  }
}
