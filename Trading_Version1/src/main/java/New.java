import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class New {

	static WebDriver driver;
@Test
public void OpenAirbnb()
{

	System.setProperty("webdriver.chrome.driver","/Users/Roselin/eclipse-workspace/chromedriver 15");
	driver=new ChromeDriver();
	driver.get("https://www.airbnb.co.in/");
}
@AfterTest
public void close()
{
	driver.quit();
	driver.close();
}
}
