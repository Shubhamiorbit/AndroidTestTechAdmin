package AndroidTest.AndroidTest;

import java.time.Duration;
import java.util.Collections;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;



public class Patient_Centre extends Base{
	
	Base base=new Base();
	public Patient_Centre(AndroidDriver<MobileElement> driver) {
		super.driver = driver;
	}

	public void AddPatient() throws InterruptedException{
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"Patient Center\"]")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.ViewGroup[@content-desc=\"Add Patient\"]")));
		element.click();
		driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view."
				+ "ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view."
				+ "ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]/android.widget.EditText[1]")).sendKeys("AutoPatient01");
		driver.findElement(By.xpath("")).sendKeys("PatientFirstName");
		driver.findElement(By.xpath("")).sendKeys("PatientLastName");
		driver.findElement(By.xpath("")).sendKeys("MRNAUTO9001");
		By yearLocator = By.xpath("//android.widget.TextView[@text='1998']");

	    for (int i = 0; i < 20; i++) {

	        try {
	            WebElement year = driver.findElement(yearLocator);
	            if (year.isDisplayed()) {
	                year.click();
	                System.out.println(" Year 1998 selected");
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
	    Thread.sleep(5000);
	    driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/"
        		+ "android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/"
        		+ "android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]/android.widget.Spinner[1]")).click();
	    driver.findElement(By.xpath("//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"Male\"]")).click();
	    
	    
	}

}
