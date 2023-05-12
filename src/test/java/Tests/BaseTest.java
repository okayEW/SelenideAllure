package Tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BaseTest {

     protected TestInfo testInfo;
     protected static Logger logger;
     public void SetUpDriver(){
          WebDriverManager.chromedriver().setup();
          Configuration.browser = "chrome";
          Configuration.driverManagerEnabled = true;
          Configuration.headless = false;
     }
     @BeforeEach
     public void Init(TestInfo testInfo){
          SetUpDriver();
          logger = LoggerFactory.getLogger(BaseTest.class);
          logger.info("Test started:\t" + testInfo.getDisplayName());
          }
     @AfterEach
     public void TearDown(TestInfo testInfo){
          logger.info("Test finished:\t" + testInfo.getDisplayName());
          Selenide.closeWebDriver();
     }
}