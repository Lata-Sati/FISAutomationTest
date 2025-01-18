
package testcases;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;
public class VerifyBPIs extends TestBase {
  Response response;
  List<String> bpiList;

  @Test(description = "TC001, Verify BPI values in response body")
  public void testBpiData() {
    logger.info("------Starting testBpiData------");
    response = RestAssured.get(pp.getProperty("URL"));
    Assert.assertEquals(response.getStatusCode(), 200, "Response status code is not 200");

    // Read the 'array' property from the config.properties file
    String bpiFromFile=pp.getProperty("BPIS");
    bpiList=List.of(bpiFromFile.split(","));

    // Extract the 'bpi' field from the response body and validating them against the list of BPIs retrieved from the config file
    String bpiPath = "bpi";
    for (String bpi : bpiList) {
      Assert.assertTrue(response.jsonPath().getMap(bpiPath).containsKey(bpi),bpi + " not present in BPI");
    }
    logger.info("------Ending testBpiData, Test Passed! BPI contains USD, GBP, and EUR with correct GBP description.-------");
  }

  @Test(description = "TC002, Verify GBPDescription in response body",dependsOnMethods = {"testBpiData"})
  public void testGBPDescription() {
    logger.info("-------Starting testDescription-------");

    // Extract the 'description' field for GBP from the response body and validate it
    for (String bpiVal : bpiList) {
      if (bpiVal.equals("GBP")) {
        String jsonPathVar = "bpi." + bpiVal + ".description";
        String actualDescription = response.jsonPath().getString(jsonPathVar);
        Assert.assertEquals(actualDescription, "British Pound Sterling","GBP description is incorrect");
      }
    }
    logger.info("-------Ending testGBPDescription, Test Passed! GBP description is 'British Pound Sterling--------");
  }
}
