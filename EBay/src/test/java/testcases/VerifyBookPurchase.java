
package testcases;

import basetest.TestBaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.CartPage;
import pageobjects.HomePage;
import pageobjects.SearchItemListPage;

public class VerifyBookPurchase extends TestBaseClass {

  @Test(description = "TC001, Verify the cart with the selected book")
  public void verifyCart() throws InterruptedException {
    logger.info("Initiating the test case");
    //Reading the quantity of books to be added to cart from property file
    String quantityOfBooks=properties.getProperty("book.quantity");
    //Home page object creation
    HomePage homePageObject=new HomePage(driver);

    logger.info("send Book text search to search page");
    homePageObject.sendTextToSearchBox("Book");
    //Search item list page object creation
    String parentWindow=driver.getWindowHandle();
    SearchItemListPage searchItemListPage=new SearchItemListPage(driver);
    logger.info("Iterating list of element to find first book");
    String bookName=searchItemListPage.clickFirstBookFromList(parentWindow, quantityOfBooks);
    //Cart page object creation
    CartPage cartPage=new CartPage(driver);
    int bookCountFromCart=cartPage.getBookCountFromCartIcon();
    String bookNameFromCart=cartPage.getBookName();

    logger.info("Asserting book name and quantity in the cart");
    Assert.assertEquals(bookCountFromCart, Integer.parseInt(quantityOfBooks));
    Assert.assertEquals(bookName, bookNameFromCart);
    logger.info("Test case executed successfully");
    }
  }

