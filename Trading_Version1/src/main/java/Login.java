import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.SeleniumServer;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Login {
	
	static WebDriver driver;
	static WebElement e1,e2,e3,e4,lf,lf1;
	String url="https://www.google.com";
	
/*** Browser configuration ****/
	
	@Test
	public void loginpage() throws IOException
	{
		System.out.print("login page 1");
		System.setProperty("webdriver.chrome.driver","/Users/Roselin/eclipse-workspace/chromedriver 15");
		driver=new ChromeDriver();
		driver.get("https://www.airbnb.co.in/");
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		//System.out.print(e1);
        
	}

/*** Take Screenshot ****/	
	
	 public void screenshot() throws IOException
     {
     TakesScreenshot ts=((TakesScreenshot)driver);
     File f=ts.getScreenshotAs(OutputType.FILE);
     File n=new File("/Users/Roselin/T.jpeg");
     FileUtils.copyFile(f,n);
     SeleniumServer s=new SeleniumServer(null);
    Set<String> l=driver.getWindowHandles();
    

     }
	 
/*** Multiple Window handling ***/
	
	 public void multiplewindow() 
	{
		e1=driver.findElement(By.xpath("//button[@name=\"newbrowsertab\"]"));
		Actions a=new Actions(driver);
		a.moveToElement(e1).click().build().perform();
		Set<String> ls=driver.getWindowHandles();
        java.util.Iterator<String> it=ls.iterator();
        while(it.hasNext())
        {
        	String s=it.next();
        	driver.switchTo().window(s);
            driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    		System.out.print(driver.getCurrentUrl());
    		
    		    		
        }
        e2=driver.findElement(By.xpath("//h2[contains(text(),'Free Tutorials for Automation')]"));
        if(e2.isDisplayed())
        {
        	String s1="success";
        	System.out.print(s1);
        }
}

public void multipleframes()
{
	e3=driver.findElement(By.xpath("//a[@href=\"#Multiple\"]"));
	Actions a1=new Actions(driver);
	a1.moveToElement(e3).click().build().perform();
	e4=driver.findElement(By.xpath("//input[@type='text']"));
    e4.sendKeys("enables");
	
	
	
}

public void iframelufthansa()
{
	try
	{
	lf1=driver.findElement(By.xpath("//iFrame[1]]"));
	
	if(lf1.isEnabled())
	{
		System.out.print("true");
	}
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.switchTo().frame(lf1);
	
	//WebDriverWait wb=new WebDriverWait(driver,10);
	//wb.until(ExpectedConditions.visibilityOf(lf));
	String str=lf1.getText();
	System.out.print(str);

	//lf1.click();
	driver.manage().timeouts().implicitlyWait(110, TimeUnit.SECONDS);

	}
	catch(StaleElementReferenceException se)
	{
		System.out.print(se);
	}
	
}
public void expedia()
{

	WebElement ex=driver.findElement(By.xpath("//iFrame[@src=\"https://bid.g.doubleclick.net/xbbe/pixel?d=KAE\"]"));
	
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ex);
	ex.click();
	

}
	 
/**** closing session ****/

public void quit()
	 {
		 driver.close();
		 driver.quit();
	 }


	 
	 
public static void main(String args[]) throws IOException
	{
        new Login().loginpage();
        //new Login().screenshot();
        //new Login().multiplewindow();
        //new Login().multipleframes();
        //new Login().iframelufthansa();
        new Login().expedia();
        //new Login().quit();
	}
   
}
