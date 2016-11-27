package package1;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Grid_3 {
  WebDriver driver;
  String baseUrl, nodeUrl;
  
  WebDriver driver2;
  String nodeUrl2;
  
  @BeforeTest
  public void setUp() throws MalformedURLException {
	  baseUrl = "http://newtours.demoaut.com/";
	  //This gets executed in Firefox in backgroud I see it in processes and passes
	  //I must specify    
      //  id : http://192.168.56.1:5555, OS : mixed OS
	  //    http://192.168.0.3:5555  or whatever port I choose or not choose take this value from the Grid home page
	  // and also environment variables for the drivers because here they are set and work but they do not on Linux and Mac
	  //  nodeUrl = "http://192.168.8.1:5588/wd/hub";   samsung
	  //   nodeUrl = "http://192.168.0.5:5555/wd/hub";    dell   VISTA   promeni se na 5560 na vtoroto svyrzvane s -Dwebdriver...  mu specifinah port -port 5560
	  // COPY FROM THE CONNECTED LIST IN GRID CONSOLE
	  nodeUrl2 = "http://192.168.56.1:5590/wd/hub";
	  nodeUrl = "http://192.168.0.3:5570/wd/hub";  //If localhost it works if before execute I register a node from the localhost
	  //  {message=unknown error: Chrome version must be >= 52.0.2743.0  a to e  49  na Dell maximum za Vista
	  // USPQH !!!!!  slojih chromedriver.exe 2.13 na Dell v syshtata papka na selenium-server-standalone  i proraboti vsichko s -Dwebdriver  i se vijdashe v Teamviewer browsera a ne beshe background
	  //cmd code
	  // HP15 WIN10
	  // java -jar selenium-server-standalone-3.0.1.jar -role hub
	  // DELL WIN VISTA 
	  // java -Dwebdriver.chrome.driver=chromedriver.exe -jar selenium-server-standalone-3.0.1.jar -role webdriver -hub http://192.168.0.4:4444/grid/register -port 5560 -browser browserName=chrome,maxInstances=2,maxSession=2
	  // linux also geckodriver.exe but different one for linux and mac
	  // Samsung LINUX UBUNTU 
	  // java -Dwebdriver.gecko.driver=geckodriver -jar selenium-server-standalone-3.0.1.jar -role webdriver -hub http://192.168.0.4:4444/grid/register -port 5570 -browser browserName=firefox,maxInstances=2,maxSession=2
	  // HP15 WIN10
	  // java -Dwebdriver.chrome.driver=C:\developer\SeleniumDrivers\chromedriver.exe -jar selenium-server-standalone-3.0.1.jar -role webdriver -hub http://localhost:4444/grid/register -port 5580 -browser browserName=chrome,maxInstances=1,maxSession=1
	  // java -Dwebdriver.gecko.driver=C:\developer\SeleniumDrivers\geckodriver.exe -jar selenium-server-standalone-3.0.1.jar -role webdriver -hub http://localhost:4444/grid/register -port 5590 -browser browserName=firefox,maxInstances=2,maxSession=2
	  DesiredCapabilities capability = DesiredCapabilities.firefox();  //chrome,firefox,opera,ie,edge,android,ios,mac safari
	  capability.setBrowserName("firefox");  //chrome
	  //capability.setCapability("marionette", true);
	  //when I specify only the browser grid auto selects the machine to run the test on
	  //capability.setPlatform(Platform.LINUX);
	  driver = new RemoteWebDriver(new URL(nodeUrl), capability);
	  driver2 = new RemoteWebDriver(new URL(nodeUrl2), capability);
  }
  
  @AfterTest
  public void tearDown(){
	  driver.quit();
	  driver2.quit();
  }
  
  @Test
  public void simpleTest(){
	  driver2.get(baseUrl);
	  Assert.assertEquals("Welcome: Mercury Tours", driver2.getTitle());
	  driver.get(baseUrl);
	  Assert.assertEquals("Welcome: Mercury Tours", driver.getTitle());
  }
  
}
