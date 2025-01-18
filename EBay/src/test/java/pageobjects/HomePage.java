
package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBaseClass{

  public HomePage(WebDriver driver) {
    super(driver);
  }

  @FindBy(xpath = "//*[contains(@placeholder,'Search for anything')]") WebElement searchBox;

  public void sendTextToSearchBox(String text) {
    searchBox.sendKeys(text);
    searchBox.submit();
  }

  }




