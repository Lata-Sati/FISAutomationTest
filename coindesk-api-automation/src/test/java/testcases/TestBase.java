
package testcases;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;
import org.testng.annotations.BeforeClass;

public class TestBase {
  public Properties pp;
  public Logger logger;

  @BeforeClass
  void setup() throws IOException {
    FileReader fileReader= new FileReader("./src//test//resources//config.properties");
    pp=new Properties();
    pp.load(fileReader);
    logger=Logger.getLogger(this.getClass().getName());
  }

}
