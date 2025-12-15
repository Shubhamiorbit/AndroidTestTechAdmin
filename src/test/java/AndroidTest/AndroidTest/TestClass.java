package AndroidTest.AndroidTest;

import java.net.MalformedURLException;

import org.testng.annotations.Test;


public class TestClass {
	
	Base newbase = new Base();

	
	@Test
	
	public void LoginasTenant() throws MalformedURLException, InterruptedException {
		newbase.mailinatorDriver();
		newbase.openapp();
		newbase.loginusingstoredemailandpassword();
		newbase.getotpfrompublicinbox();
		Thread.sleep(10000);
		Nurse_Centre nursecentre = new Nurse_Centre(newbase.getDriver());
		nursecentre.AddNurse();
		Doctor_Centre doctorcentre = new Doctor_Centre(newbase.getDriver());
		doctorcentre.AddDoctor();
		Patient_Centre patientcentre = new Patient_Centre(newbase.getDriver());
		patientcentre.AddPatient();
	}	
}
