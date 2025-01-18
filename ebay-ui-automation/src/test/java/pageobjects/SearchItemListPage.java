
package pageobjects;

import java.util.List;
import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchItemListPage extends PageBaseClass {
  public SearchItemListPage(WebDriver driver) {
    super(driver);
  }

  @FindBy(xpath = "//ul[@class='srp-results srp-list clearfix']//li//div//div[2]//a")
  List<WebElement> itemsList;
  @FindBy(xpath = "//span[normalize-space()='Books']") WebElement booksCategory;
  @FindBy(xpath = "//input[@id='qtyTextBox']") WebElement quantityTextBox;
  @FindBy(xpath = "//div[@id='mainContent']//h1//span") WebElement bookText;
  @FindBy(xpath = "//span[normalize-space()='Books & Magazines']") WebElement booksMagazinesCategory;
  @FindBy(xpath = "//span[contains(text(),'Add to cart')]") WebElement btnAddToCart;


  public String clickFirstBookFromList(String parentWindow, String quantity)
      throws InterruptedException {
    String bookName="";
    for (WebElement ele : itemsList) {
      ele.click();
      Thread.sleep(5000);
      Set<String> childWindow = driver.getWindowHandles();
      for (String windowElement : childWindow) {
        if (!windowElement.equals(parentWindow)) {
          driver.switchTo().window(windowElement);
        }
      }
        try {
          if(booksCategory.isDisplayed() || booksMagazinesCategory.isDisplayed()) {
            quantityTextBox.clear();
            quantityTextBox.sendKeys(quantity);
            bookName = bookText.getText();
            btnAddToCart.click();
            break;
          }
        } catch (Exception e) {
          driver.close();
          driver.switchTo().window(parentWindow);
          childWindow.clear();
        }
      }
    return bookName;
    }
  }


