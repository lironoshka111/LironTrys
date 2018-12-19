package Pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;

import functions.General;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;


public class MainPage extends General{
	@AndroidFindBy(xpath = "//*[@text = '+']")
    private MobileElement PlusBtn;
	@AndroidFindBy(xpath = "//*[@text = '−']")
	private MobileElement MinousBtn;
	@AndroidFindBy(id = "com.sec.android.app.popupcalculator:id/bt_parenthesis")
	private MobileElement BracketsBtn;
	@AndroidFindBy(xpath = "//*[@text = '=']")
    private MobileElement EqualBtn;
	@AndroidFindBy(xpath = "//*[@text = '×']")
	private MobileElement MultiplyBtn;
	@AndroidFindBy(xpath = "//*[@text = 'sin']")
	private MobileElement SinBtn;
	@AndroidFindBy(xpath = "//*[@text = 'היסטוריה']")
	private MobileElement HistoryBtn;
	@AndroidFindBy(xpath = "//*[@text = 'נקה היסטוריה']")
	private MobileElement CleanHistoryBtn;
	@AndroidFindBy(id = "com.sec.android.app.popupcalculator:id/txtCalc")
    private MobileElement ResultTxt;
	@AndroidFindBy(id = "com.sec.android.app.popupcalculator:id/bt_clear")
    private MobileElement ClearBtn;
	@AndroidFindBy(id = "com.sec.android.app.popupcalculator:id/historyResult")
    private List<MobileElement> HistoryResult;
	@AndroidFindBy(id = "com.sec.android.app.popupcalculator:id/historyExpression")
    private List<MobileElement> HistoryExpression;
	//private HashMap<String, String> expression = new  HashMap<>();
	private static List<String> saveExpression=new ArrayList<String>();

	public void CleanHistory() {
		if(HistoryBtn.isEnabled()) {
			Click(HistoryBtn);
			Click(CleanHistoryBtn);
			 assertTrue(!HistoryBtn.isEnabled(), "the clean history button didnt work");
		}
	
	}
	public void ClickNumber(Character ch) {
		MobileElement TypeNumber= SetUpPage.driver.findElement(By.xpath("//*[@text = '"+ch+""+"']"));
		Click(TypeNumber);
	}
	public String GetTheResult() {
		Click(EqualBtn);
		WaitAttributeToBeNotEmpty(ResultTxt,"text");
		String result =ResultTxt.getText();
		Click(ClearBtn);
		assertEquals(ResultTxt.getText(), "" , "the clear mthod is not working");
		return result ;
	}
	
	// check if the expression is equles or not equles not the result and sava the exprssion and the result
	public void Caulate(String ex ) {
		ex.replaceAll(" ", "");
		boolean equles = true;
		String[] ExpressionAndResultArray = {};
		if(ex.contains("!=")) {
			equles= false;
			ExpressionAndResultArray = ex.split("!=");
		}
		else if (ex.contains("=")) {
			ExpressionAndResultArray = ex.split("=");
		}
		else {
			assertTrue(false , "you need a = sign in your expression");
		}
		String expression = ExpressionAndResultArray[0];
		for (int i = 0; i < expression.length(); i++) {
			if(Character.isDigit(expression.charAt(i))) {
				ClickNumber(expression.charAt(i));
			}
			else {
			switch (expression.charAt(i)) {
			case 's':
				if(ex.substring(i, i+4).equals("sin("))
					Click(SinBtn);
				i = i+3;
				break;
			case '(':
			case ')':
				Click(BracketsBtn);
				break;
			case '-':
				Click(MinousBtn);
				break;
			case '+':
				Click(PlusBtn);
				break;
			case '*':
				Click(MultiplyBtn);
				break;
			
			default:
				assertTrue(false , "the char is invilide");
				break;
			}
			}
		}
		String txt = ResultTxt.getText();
		String result =  GetTheResult();
		String expectedResult = ExpressionAndResultArray[1];
		if(equles) {
			assertEquals(expectedResult,result ,"the result  that show is not equels to the expected result");

		}
		else {
			assertNotEquals(expectedResult, result ,"the results need to be diffrent");
		}
		saveExpression.add(txt+"="+result);

	}
	
	// compare the list of the save expression and the list of the expression in the history window
	public void CheckHistory() {
		RotateVertical();
		Click(HistoryBtn);
		List<String> HistoryFullExpressionlst = new ArrayList<>();
			for (int i=0;i<HistoryExpression.size(); i++) {
				HistoryFullExpressionlst.add(HistoryExpression.get(i).getText()+HistoryResult.get(i).getText());
			
			}
	
			CheckLists(HistoryFullExpressionlst,saveExpression );
		}
		
	

	
	
	
}
