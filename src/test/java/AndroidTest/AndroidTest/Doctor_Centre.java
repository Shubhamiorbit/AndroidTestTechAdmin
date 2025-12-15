package AndroidTest.AndroidTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;



public class Doctor_Centre extends Base{
	
	Base base=new Base();
	public Doctor_Centre(AndroidDriver<MobileElement> driver) {
		super.driver = driver;
	}

	public void AddDoctor() throws InterruptedException{
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"Doctor Center\"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"Add Doctor\"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//android.widget.EditText[@text=\"APOLLOORG1H1D1\"]")).sendKeys("AutoDoc01");
		driver.findElement(By.xpath("//android.widget.EditText[@text=\"APOLLO_D1\"]")).sendKeys("AutoDocFirstName");
		driver.findElement(By.xpath("//android.widget.EditText[@text=\"ORG1_H1\"]")).sendKeys("AutoDocLastName");
		driver.findElement(By.xpath("//android.widget.EditText[@text=\"General Physician, Cardiologist\"]")).sendKeys("Cardiologist");
		driver.findElement(By.xpath("//android.widget.EditText[@text=\"1\"]")).sendKeys("3");
		driver.findElement(By.xpath("//android.widget.EditText[@text=\"1980-01-01\"]")).sendKeys("1983-02-12");
		driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"male\"]")).click();
		Dimension size = driver.manage().window().getSize();
	    int width = size.getWidth();
	    int height = size.getHeight();
		driver.executeScript("mobile: swipeGesture", ImmutableMap.of("left", width/4,
				"top", height/4,
				"width", width/2,
				"height", height/2,
				"direction", "up",
				"percent",0.8));
		driver.findElement(By.xpath("//android.widget.EditText[@text=\"APOLLO_ORG1_H2 street\"]")).sendKeys("NDA, Pune");
		driver.findElement(By.xpath("//android.widget.EditText[@text=\"Bangalore\"]")).sendKeys("Pune");
		driver.findElement(By.xpath("//android.widget.EditText[@text=\"560076\"]")).sendKeys("411052");
		driver.findElement(By.xpath("//android.widget.EditText[@text=\"KA\"]")).sendKeys("MH");
		driver.findElement(By.xpath("//android.widget.EditText[@text=\"IN\"]")).sendKeys("IN");
		driver.findElement(By.xpath("//android.widget.EditText[@text=\"APOLLO_ORG1_H1_D1\"]")).sendKeys("AutoDoctor");
		driver.findElement(By.xpath("//android.widget.EditText[@text=\"9988776655\"]")).sendKeys("9874563215");
		driver.findElement(By.xpath("//android.widget.EditText[@text=\"APOLLO_ORG1_H1_D1@mailinator.com\"]")).sendKeys("autodoc@mailinator.com");
		driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Save\"]")).click();		
	}
}
