package actions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.constants.Constants;

public class KeywordActions {
  
	WebDriver driver;
	//launching browser
	public void launchBrowser() {
		driver=new ChromeDriver();
	}
	
	public void launchUrl() {
		driver.get(Constants.url);
	}
	
    public By objectLocator(String xpathName) throws IOException {
    	File file=new File("./src/test/resources/PropertyFile/Locators1.properties");
        FileInputStream fis=new FileInputStream(file);
        Properties prop=new Properties();
        prop.load(fis);
        
        String xpath=prop.getProperty(xpathName);
        return By.xpath(xpath);
        
    }
    
    
    public void enterData(String eleName,String data) throws IOException {
    	//reading locator from properties file
    	driver.findElement(objectLocator(eleName)).sendKeys(data);;
    }
    
    public void click(String eleName) throws IOException {
    	driver.findElement(objectLocator(eleName)).click();
    }
    
    public void quite() {
    	driver.quit();
    }
}
