package Testing1;

import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
public class TestWithChrome {

	public static void main(String[] args) {
		//System.setProperty("webdriver.chrome.driver", "D:\\AutomationAsessment1\\Mydriver\\chromedriver.exe");
		//System.setProperty("webdriver.gecko.driver", "D:\\Automation1\\Driver\\geckodriver.exe");
		
		//WebDriver driver=new ChromeDriver();
		//WebDriver driver=new FirefoxDriver();
		WebDriver driver=new SafariDriver();
		driver.get(" https://www.getcalley.com/page-sitemap.xml");
		//change dimension here for different size 
		driver.manage().window().setSize(new Dimension(414,896));
		//https://www.getcalley.com/
		//https://www.getcalley.com/calley-call-from-browser/
		//https://www.getcalley.com/calley-pro-features/
		//https://www.getcalley.com/best-auto-dialer-app/
		//https://www.getcalley.com/how-calley-auto-dialer-app-works/
		driver.findElement(By.linkText("https://www.getcalley.com/how-calley-auto-dialer-app-works/")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// Get the current date and time
		
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date());
		
		File ss=(File) ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		//filename
		//String fileName = "screenshot-" + dateFormat.format(currentDate) + ".png";
		String fileName="D:\\Automation1\\FireFox\\Mobile\\414_896\\Screenshot-"+timeStamp+".png";
		//System.out.println(fileName);
		try {
			FileUtils.copyFile(ss, new File(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			driver.quit();
			}

	}

}
