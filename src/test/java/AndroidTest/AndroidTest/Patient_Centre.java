package AndroidTest.AndroidTest;

import java.time.Duration;
import java.util.Collections;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.ImmutableMap;

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
	    driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"bloodGroupInput\"]")).click();
	    driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"bloodGroup_optionText_AB+\"]")).click();
	    driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"contactNameInput\"]")).sendKeys("EthixPatientContactName");
	    driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"phoneInput\"]")).sendKeys("8855236668");
	    driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"emailInput\"]")).sendKeys("Ethixpatient01@mailinator.com");
	    Dimension size = driver.manage().window().getSize();
	    int width = size.getWidth();
	    int height = size.getHeight();
		driver.executeScript("mobile: swipeGesture", ImmutableMap.of("left", width/4,
				"top", height/4,
				"width", width/2,
				"height", height/2,
				"direction", "up",
				"percent",0.5));
		Thread.sleep(5000);
	    driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"streetInput\"]")).sendKeys("NA");
	    driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"cityInput\"]")).sendKeys("Pune");
	    driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"pincodeInput\"]")).sendKeys("411058");
	    driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"stateInput\"]")).sendKeys("MH");
	    driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"countryInput\"]")).sendKeys("IN");
	    driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"ageInput\"]")).sendKeys("57");
	    driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"doctorCodeInput\"]")).sendKeys("EthixDoctor001");
	    driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"addPatientButton\"]")).click();
	    
	    String patientcreatedpromptmessage = driver.findElement(By.xpath("//android.widget.TextView[@text=\"Patient Information Saved successfully!\"]")).getText();
		String expectedpromptmessage= "Patient Information Saved Successfully!";
		boolean isEqual = patientcreatedpromptmessage.equals(expectedpromptmessage);
	    
	    
	}

}
