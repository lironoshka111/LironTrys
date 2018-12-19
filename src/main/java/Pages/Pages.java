package Pages;

import java.util.function.Supplier;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;


import io.appium.java_client.pagefactory.AppiumFieldDecorator;



public class Pages {
	
	private static <T> T getPage (Supplier<? extends T>supp ){
		T page = supp.get();
		PageFactory.initElements(new AppiumFieldDecorator(SetUpPage.driver), page);

		return page; 
	
		
	}
	
	public static MainPage main() {
		return getPage(MainPage::new);
	}
	public static SetUpPage Setup() {
		return getPage(SetUpPage::new);
	}
	
}
