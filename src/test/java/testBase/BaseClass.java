package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.LogManager;//log4j
import org.apache.logging.log4j.Logger;   //log4j

public class BaseClass {
	
    public static WebDriver driver;
    
  public Logger logger ; // log4j
  
  public Properties p;
	
	@BeforeClass (groups = { "Master", "Sanity", "Regression" }) //Step8 groups added
	@Parameters ({"os","browser"})
	public void setup(String os , String br) throws IOException
	{
		//Loading config.properties file
		
		FileReader file = new FileReader("./src//test//resources//config.properties");
		p = new Properties();
		p.load(file);
		
		
		
		logger = LogManager.getLogger(this.getClass());
		
		switch(br.toLowerCase())
		{
			case "chrome" : driver=new ChromeDriver(); break;
			case "edge" : driver=new EdgeDriver(); break;
			case "firefox" : driver=new FirefoxDriver(); break;
			default :  System.out.println("Invalid Browser..."); break;
		}
		
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(p.getProperty("appURL")); // Reading URL from properties file
		driver.manage().window().maximize();
	}
	
	public String randomString()
	{
		String generatedString = RandomStringUtils.randomAlphabetic(6);
		
		return generatedString;
		
	}
		public String randomNumber()
		{
			String generatedNumber = RandomStringUtils.randomNumeric(10);
			
			return generatedNumber;
		
	}
		
		public String randomPass()
		{
			String generatedPass = RandomStringUtils.randomAlphabetic(8);
			
			return generatedPass;
		}
		
		public String captureScreen(String tname) throws IOException {

			String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
					
			TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
			File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
			
			String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
			File targetFile=new File(targetFilePath);
			
			sourceFile.renameTo(targetFile);
				
			return targetFilePath;
		}
			
	@AfterClass (groups = { "Master", "Sanity", "Regression" }) //Step8 groups added
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.quit();
	
	}
	
	
}
