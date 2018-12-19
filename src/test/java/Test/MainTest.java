package Test;





import org.openqa.selenium.ScreenOrientation;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.Pages;
import Pages.SetUpPage;
import functions.General;

public class MainTest {

	@BeforeClass
	public void Rotate () {
		General.RotateHorizontal();
	}
	@Test(priority =1 )
	public void CheckHistoryWindow() {
		Pages.main().CleanHistory();
	}

	@Test(priority = 2)
	public void Test1 () {
		Pages.main().Caulate("2+3=5");
	}
	@Test (priority = 3)
	public void Test2 () {
		Pages.main().Caulate("10-2=8");
	}
	@Test (priority= 4)
	public void Test3 () {
		Pages.main().Caulate("(10-2)*2!=20");
	}
	@Test(priority = 5)
	public void Test4 () {
		Pages.main().Caulate("sin(30)=0.5");
	}
	
	@Test(priority = 6)
	public void CheckHistory() {
		
		Pages.main().CheckHistory();
	}
}
