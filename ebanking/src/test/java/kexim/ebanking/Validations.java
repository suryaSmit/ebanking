package kexim.ebanking;

import org.testng.Reporter;

public class Validations {
	
	public static boolean compareText(String actText, String expText) {
		return actText.contains(expText);
	}
}
