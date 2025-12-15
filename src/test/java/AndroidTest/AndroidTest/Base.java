package AndroidTest.AndroidTest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.github.bonigarcia.wdm.WebDriverManager;



public class Base {
	protected AndroidDriver driver;
	String email="";
	String password="";
	String otp;
	String otp1;
	WebDriver driver2;
	
		
	public void openapp() throws MalformedURLException {
		
		File f=new File("src/test/java");
		File fs = new File(f,"techadmin1012 1.apk");		
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("appium:deviceName", "Samsung_A5");
		cap.setCapability("appium:automationName", "UiAutomator2");
		cap.setCapability("appium:app", fs.getAbsolutePath());				
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"),cap);
		System.out.println("Session started");	
	}
	
	public AndroidDriver<MobileElement> getDriver() {
        return driver;
    }
		public void mailinatorDriver() {
			WebDriverManager.edgedriver().setup();
			driver2=new EdgeDriver();
			driver2.manage().window().maximize();		
			driver2.get("https://www.mailinator.com/");
		}
	public void loginusingstoredemailandpassword() throws InterruptedException {
		
		driver.findElement(By.xpath("//android.widget.EditText[@text=\"Enter Email\"]")).sendKeys("ethix@mailinator.com");
		driver.findElement(By.xpath("//android.widget.EditText[@text=\"Password\"]")).sendKeys("788679282");
		driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Log in\"]")).click();		
		Thread.sleep(10000);				 		
	}
	
public void getotpfrompublicinbox() throws InterruptedException {
		
		
		WebDriverWait wait = new WebDriverWait(driver2,Duration.ofSeconds(10));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class=\"inbox-link\"]")));
		element.click();
//		driver2.findElement(By.xpath("//a[@class=\"inbox-link\"]")).click();
		driver2.findElement(By.id("inbox_field")).sendKeys("ethix");
		driver2.findElement(By.className("primary-btn")).click();
		Thread.sleep(3000);
		driver2.findElement(By.xpath("(//*[contains(text(),'2-factor authentication Email')])[1]")).click();
		Thread.sleep(2000);
		try {
			WebElement iframeElement = driver2.findElement(By.xpath("html/body/div/main/div/div/div[3]/div/div[2]/iframe"));
			driver2.switchTo().frame(iframeElement);
			WebElement otpElement = driver2.findElement(By.xpath("//body[contains(text(), 'OTP')]"));
			String otpText = otpElement.getText();

           
            Pattern pattern = Pattern.compile("\\d{6}");
            Matcher matcher = pattern.matcher(otpText);

            if (matcher.find()) {
                 otp = matcher.group(0);
                System.out.println("Extracted OTP: " + otp);
            } else {
                System.out.println("OTP not found in the email.");
            }

        }  catch (NoSuchElementException n) {
            System.out.println("Email containing OTP not found.");
        } 
		
		System.out.println("Stored OTP: " + otp);
		driver2.close();
		  String otp1 = otp;

			driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.EditText[1]")).sendKeys(otp1.substring(0, 1));
			driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.EditText[2]")).sendKeys(otp1.substring(1, 2));
			driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.EditText[3]")).sendKeys(otp.substring(2, 3));
			driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.EditText[4]")).sendKeys(otp.substring(3, 4));
			driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.EditText[5]")).sendKeys(otp.substring(4, 5));
			driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.EditText[6]")).sendKeys(otp.substring(5, 6));
			Thread.sleep(2000);
			driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Submit\"]")).click();
		}		
}
