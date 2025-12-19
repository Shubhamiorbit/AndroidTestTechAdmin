package AndroidTest.AndroidTest;
import java.time.Duration;
import java.util.Collections;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class Nurse_Centre extends Base{
	
	Base base=new Base();
	public Nurse_Centre(AndroidDriver<MobileElement> driver) {
		super.driver = driver;
	}

	public void AddNurse() throws InterruptedException, RuntimeException{
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"Nurse Center\"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"Add Nurse\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"input-nurse-code\"]")).sendKeys("AutoNurse01");
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.EditText[2]")).click();
		driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"input-first-name\"]")).sendKeys("AutoFirstNurseName");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"input-last-name\"]")).sendKeys("AutoLastNurseName");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Nurse Type*\"]/android.widget.EditText")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"GENERAL\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/"
				+ "android.widget.ScrollView/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"GENERAL\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Gender*\"]/android.widget.EditText")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"male\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"input-nurse-experience\"]")).sendKeys("3");
	
		Thread.sleep(3000);
		driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Birth Date*\"]/android.widget.EditText")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/date_picker_header_year\"]")).click();
		Thread.sleep(5000);
		By yearLocator = By.xpath("//android.widget.TextView[@text='1983']");

	    for (int i = 0; i < 20; i++) {

	        try {
	            WebElement year = driver.findElement(yearLocator);
	            if (year.isDisplayed()) {
	                year.click();
	                System.out.println(" Year 1983 selected");
	                break;
	            }
	        } catch (Exception e) {
	            System.out.println(" 1983 not visible yet, swiping...");
	        }

	        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
	        Sequence swipe = new Sequence(finger, 1);

	        swipe.addAction(finger.createPointerMove(
	                Duration.ZERO,
	                PointerInput.Origin.viewport(),
	                540, 950   
	        ));

	        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));

	        swipe.addAction(new Pause(finger, Duration.ofMillis(200)));

	        swipe.addAction(finger.createPointerMove(
	                Duration.ofMillis(600),
	                PointerInput.Origin.viewport(),
	                540, 1450    // End point (your screen center top)
	        ));

	        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

	        driver.perform(Collections.singletonList(swipe));

	        Thread.sleep(300);
	    }

	    By okBtn = By.id("android:id/button1");
	    driver.findElement(okBtn).click();

	    System.out.println("Date Selection Completed Successfully");
	
		driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"input-shared-phone\"]")).sendKeys("+917894561234");
		driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"input-address-street1\"]")).sendKeys("Warje, Pune-42");
		Dimension size = driver.manage().window().getSize();
	    int width = size.getWidth();
	    int height = size.getHeight();
		driver.executeScript("mobile: swipeGesture", ImmutableMap.of("left", width/4,
				"top", height/4,
				"width", width/2,
				"height", height/2,
				"direction", "up",
				"percent",0.8));
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"input-address-city\"]")).sendKeys("Pune");
		driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"input-address-pincode\"]")).sendKeys("411042");
		
		driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"input-address-state\"]")).sendKeys("MH");
		driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"input-address-country\"]")).sendKeys("IN");
		driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"input-contact-name\"]")).sendKeys("NurseContactName");
		driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"input-contact-phone\"]")).sendKeys("+919876543215");
		driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"input-contact-email\"]")).sendKeys("nurseauto01@mailinator.com");
		driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Save Nurse\"]")).click();
		

		String doctorcreatedpromptmessage = driver.findElement(By.xpath("//android.widget.TextView[@text=\"Nurse Information Saved successfully!\"]")).getText();
		String expectedpromptmessage= "Nurse Information Saved Successfully!";
		boolean isEqual = doctorcreatedpromptmessage.equals(expectedpromptmessage);

	}
}
