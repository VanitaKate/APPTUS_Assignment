package Test_Cases;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Configurations.BaseClass;
import Page_Objects.DefaultPage;
import Page_Objects.HomePage;
import Page_Objects.LoginPage;

public class TC1_DefaultPage001 extends BaseClass{
@Test
	public void VerifyDefaultPageAndSignIn() throws Throwable {
		driver=setUp();
		driver.get("http://Automationpractice.com/");
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		DefaultPage DP=new DefaultPage(driver);
		DP.clickSignInBtn();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		LoginPage LP=new LoginPage(driver);	
		LP.enterLoginEmailAddress("jetblue@grr.la");
		LP.enterLoginPassword("jetblue");
		LP.enterLoginEmailAddress("jetblue@grr.la");
		LP.enterLoginPassword("jetblue");
		if (LP.iseMailBlank()) {
			System.out.println("Entered value disappears on auto page refresh");
		}else
		LP.clickSubmitButton();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		System.out.println("User logged in succesfully.");
		HomePage HP=new HomePage(driver);
		HP.selectTShirtCat();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Catgory 'T-Shirts' is selected");
		HP.selectShortSeelve();
		System.out.println("Short sleeve T-Shirt is selected");
		HP.addToCart();
		System.out.println("Short sleeve T-Shirt is added to cart");
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		/*
		 * List<WebElement> list= new ArrayList<WebElement>();
		 * list=driver.findElements(By.className("iframe")); System.out.println(list);
		 */
		boolean isProceedBtn=HP.isProceedToChkout();
		System.out.println("Is Proceed to CheckOut displayed: "+isProceedBtn);
		boolean flag=HP.chkMsgDisplayed();
		System.out.println("Is message displayed: "+flag);
		System.out.println("Short sleeve T-Shirt is added to cart");
		String msg=HP.vrfyMessage();
		System.out.println("Message Displayed on screen: "+msg);
		String productName=HP.labelProduct();
		String colorSize=HP.labelColorSize();
		String quantity=HP.labelQuantity();
		String totalPrice=HP.labelTotal();
		System.out.println("Product Name:" +productName +"\ncolorSize:" +colorSize+ "\nQuantity"+quantity+"\nTotalPrice" +totalPrice);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		HP.clickProceedToChkOut();
		tearDown();
	}

}
