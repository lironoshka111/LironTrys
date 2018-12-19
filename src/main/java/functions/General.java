package functions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import Pages.SetUpPage;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;


public class General  extends wait{

	
	
	public void Click (MobileElement Element  ) {
		WaitIsClickAble(Element);
		WaitIsDisplayed(Element);
		WaitIsClickAble(Element);
		Element.click();
	}
	
	
	public void SendKeys (MobileElement  Element , String text) {
		WaitIsDisplayed(Element);
		Element.sendKeys(text);
		assertEquals(Element.getText(), text , "the text is not ok");

	}
	
	public <T> void CheckLists(List<T> first ,List<T> second ) {
		SoftAssert a = new SoftAssert();
		assertEquals(first.size(), second.size() , "the size of the lists need to be the same ");
		for(int i=0; i<first.size();i++) {
			a.assertEquals(first.get(i), second.get(i), "the two vlaues is not equles");
		}
		a.assertAll();
	}

	public static void RotateHorizontal() {
		SetUpPage.driver.rotate(ScreenOrientation.LANDSCAPE);

	}
	
	public static void RotateVertical() {
		SetUpPage.driver.rotate(ScreenOrientation.PORTRAIT);

	}

}
