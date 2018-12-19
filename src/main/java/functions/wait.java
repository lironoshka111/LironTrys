package functions;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pages.SetUpPage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;

public class wait {
	

	
	public static void WaitIsDisplayed (MobileElement Element ) {
		SetUpPage.wait.until(ExpectedConditions.visibilityOf(Element));
	}
	
	public static void WaitAttributeToBeNotEmpty (MobileElement Element ,String attribute) {
		SetUpPage.wait.until(ExpectedConditions.attributeToBeNotEmpty(Element, attribute));
	}
	
	public static void WaitIsClickAble(MobileElement Element ) {
		SetUpPage.wait.until(ExpectedConditions.elementToBeClickable(Element));
	}
	
	public static void WaitIsDisplayedText(MobileElement Element , String text) {
		SetUpPage.wait.until(ExpectedConditions.textToBePresentInElement(Element, text));
	}
	
	public static void WaitDisplayList(List <MobileElement> lst ) {
		SetUpPage.wait.until(ExpectedConditions.visibilityOfAllElements((MobileElement)lst));
	}
	
	
	
}
