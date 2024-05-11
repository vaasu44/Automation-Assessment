package Testing1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.Shutterbug;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Test2Automation {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\AutomationAsessment1\\Mydriver\\chromedriver.exe");
		//System.setProperty("webdriver.gecko.driver", "D:\\Automation1\\Driver\\geckodriver.exe");
		
		//WebDriver driver=new FirefoxDriver();
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.dealsdray.com/");
		//change dimension here for different size 
		driver.manage().window().maximize();
		
		String username="prexo.mis@dealsdray.com";
		String password="prexo.mis@dealsdray.com";
		String path="D:/Automation1/XLS File/demo-data.xlsx";
		
		
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//*[@class=\"MuiBox-root css-79elbk\"]//child::button")).click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement order = driver.findElement(By.xpath("//*[@class=\"css-sukebr\"]/child::button"));
		Actions action=new Actions(driver);
		action.moveToElement(order).click().perform();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement orders = driver.findElement(By.xpath("//*[@class=\"expansion-panel submenu\"]/child::div"));
		action.moveToElement(orders).click().perform();
		
		driver.findElement(By.xpath("//*[@class=\"MuiBox-root css-0\"]/child::button")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement upload = driver.findElement(By.xpath("//*[@class=\"MuiFormControl-root MuiTextField-root css-i44wyl\"]/descendant::input"));
		//upload.click();
		//File file = new File(path);
        upload.sendKeys(path);
        
        driver.findElement(By.xpath("//*[@class=\"MuiBox-root css-1xi4464\"]/child::button")).click();
        
     // Taking a screenshot of the final output
        Shutterbug.shootPage(driver,Capture.FULL,true).save("D:\\Automation1\\Test2\\");
		
		//driver.quit();

	}

}
