
package basetest;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBaseClass {
  public static WebDriver driver;
  public Properties properties;
  public Logger logger;

  @BeforeClass
  public void setup() throws IOException {
    logger=LogManager.getLogger(this.getClass());
    logger.info("Setting up browser, properties");
    //Reading and loading property file to get url and browser details
    FileReader file=new FileReader("./src/test/resources/config.properties");
    properties=new Properties();
    properties.load(file);

    //Setting up browser
    String browser=properties.getProperty("browser.name");
    switch (browser) {
      case "chrome" : driver=new ChromeDriver(); break;
      case "edge" : driver=new EdgeDriver(); break;
      case "firefox": driver=new FirefoxDriver(); break;
      default : logger.info("Invalid browser name."); return;
    }

    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.get(properties.getProperty("website.URL"));
    driver.manage().window().maximize();
   // Thread.sleep(5000);
    }


  @AfterClass
  public void tearDown() {
    logger.info("tearing down setup");
    driver.quit();
  }
}

