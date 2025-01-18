
package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends PageBaseClass{
  public CartPage(WebDriver driver) {
    super(driver);
  }

  @FindBy(xpath = "//span[@role='img' and @class='badge']") WebElement cartIcon;
  @FindBy(xpath = "//ul[@class='cart-bucket__vendor-list']//li//h3//a") WebElement bookName;

  public int getBookCountFromCartIcon() {
    return Integer.parseInt(cartIcon.getText());
  }

  public String getBookName() {
    return bookName.getText();
  }
}
