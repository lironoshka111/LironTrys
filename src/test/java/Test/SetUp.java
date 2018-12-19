package Test;


import org.testng.annotations.Test;

import Pages.Pages;


public class SetUp  {
	

	   @Test
	 public  void ConnectToTheDevice()  {
		   Pages.Setup().Connect("Galaxy A8 (2018)","520075f8b416554d" ,"8.0.0" );
 
	   }

}
