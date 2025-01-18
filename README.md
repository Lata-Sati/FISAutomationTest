This git repo consist of 2 Automation Projects which are defined as follows :-

###  1. ebay-ui-automation
This project automates book search and add to cart scenario.
## How to start the project
**Build the project using Maven:**
   ```sh
   mvn clean install
   ```

**Run the tests:**
   ```sh
   mvn test
   ```
## Project Structure

- `src/main/java`: Contains the main application code.
- `src/test/java`: Contains following folders:
   - `src/test/java/pageObjects`: Contains the HomePage, SearchListPage, and CartPage classes, each with their respective web elements and actions. The PageBaseClass initializes the web elements defined in the classes using PageFactory.
   - `src/test/java/testBase`: Contains the TestBaseClass with setup and teardown methods for driver initialization and closing, as well as methods for creating a logger object and loading property files.
   - `src/test/java/testCases`: Contains test cases that search for a product, add it to the cart, and verify the product in the cart.
- `src/test/java/resources`: Contains the following files:
    - `config.properties`: Contains the configuration details like browser, url, quantity of book to be added.
    - `log4j.properties`: Contains the configuration details for log4j.
- `pom.xml`: Maven configuration file having all the related dependencies.
- `runtest.xml': TestNG configuration file to run the test cases.
   
### 2. coindesk-api-automation
This project automates validation of Coindesk's GET api.coindesk.com/v1/bpi/currentprice.json API response for BPIs.
## How to start the project
**Build the project using Maven:**
   ```sh
   mvn clean install
   ```

**Run the tests:**
   ```sh
   mvn test
   ```
