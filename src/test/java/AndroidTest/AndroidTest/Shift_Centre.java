package AndroidTest.AndroidTest;

import org.openqa.selenium.By;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Shift_Centre extends Base {
	
	Base base=new Base();
	public Shift_Centre(AndroidDriver<MobileElement> driver) {
		super.driver = driver;
	}
	
	public void AddShift()
	{
		driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Shift Center\"]")).click();
		driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Add Shift\"]")).click();
		driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Select Shift Name\"]")).sendKeys("EthixAutoShift");
		driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/"
				+ "android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.EditText[1]")).sendKeys("EthixAutoShiftCode");
	}
}
