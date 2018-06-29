package selenium.third.BingTranslator;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AppTest 
{
	WebDriver driver;
	WebElement txtArea,translateArea;
	 JavascriptExecutor executor;
//	 FileInputStream fs;
//    String txt1;
	
    @BeforeClass
    public void OpenBing() throws Exception 
    {
    	System.setProperty("webdriver.chrome.driver","D:\\Neha Workspace\\chromedriver_win32\\chromedriver.exe");
    	driver=new ChromeDriver();
    	driver.get("https://www.bing.com/translator");
    	txtArea = driver.findElement(By.id("t_sv"));
    	translateArea = driver.findElement(By.id("t_tv"));
        executor=(JavascriptExecutor)driver;
//    	 Properties p = new Properties();
//    	 fs = new FileInputStream("C:\\Users\\nehavarshney\\eclipse-workspace\\BingTranslator\\src\\test\\java\\bing.properties");
//    	 p.load(fs);
//    	 p.getProperty(txt1);
    	 
    }
    
    @AfterClass
	public void after()
	{
		//driver.quit();
	}
    
    @Test(priority=1)
    public void sameText()
    {
    	txtArea.sendKeys("neha");
    	txtArea.clear();
    	Assert.assertEquals("neha","neha");
    	
    }
    
    @Test(priority=2)
    public void dropDownListAndOptionSelect()
    {
    	Select iValue = new Select(driver.findElement(By.id("t_sl")));
	    iValue.selectByVisibleText("English");
		System.out.println(iValue);
		txtArea.sendKeys("neha Hola");
		executor.executeScript("window.scrollBy(0,200)");
		Select oValue = new Select(driver.findElement(By.id("t_tl")));
		oValue.selectByVisibleText("Japanese");
		System.out.println(oValue);
    }
 
    @Test(priority=3)
    public void switchLanguage() {
    	driver.findElement(By.id("t_revIcon")).click();
    	txtArea.clear();
    	txtArea.sendKeys("おっす"); 
    	//Assert.assertEquals("おっす","Whoa");
    }
    
    @Test(priority=4)
    public void historyButtonTranslation()
    {
		executor.executeScript("window.scrollBy(0,200)");
    	driver.findElement(By.className("ttl_histbtn")).click();
    	txtArea.clear();
    	txtArea.sendKeys("neha Hola");
    }
}
