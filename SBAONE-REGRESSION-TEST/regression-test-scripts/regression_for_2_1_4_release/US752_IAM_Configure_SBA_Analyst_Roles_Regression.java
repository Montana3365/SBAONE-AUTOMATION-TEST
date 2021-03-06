package regression_for_2_1_4_release;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;

public class US752_IAM_Configure_SBA_Analyst_Roles_Regression {
	
	public WebDriver mydriver;
	String myurl;
	String AAEmail;
	String AAPassW;
	String VEmail;
	String VPassW;
	
@Before
public void IAM_Configure_SBA_Analyst_Roles_Setup()throws Exception{
	myurl="https://certify.qa.sba-one.net/users/sign_in";
	AAEmail="analyst1@mailinator.com";
	AAPassW="password";
	VEmail="akanamontana@gmail.com";		
	VPassW="password";		
	File file = new File("C:\\SBA-AUTOMATION-TEST\\SBAONE-REGRESSION-TEST\\libs\\IEDriverServer32b.exe");
	System.setProperty("webdriver.ie.driver", file.getAbsolutePath());	
	File file1 = new File("C:\\SBA-AUTOMATION-TEST\\SBAONE-REGRESSION-TEST\\libs\\chromedriver.exe");
	System.setProperty("webdriver.chrome.driver", file1.getAbsolutePath());
	//mydriver=new InternetExplorerDriver();
	//mydriver=new ChromeDriver();
	mydriver=new FirefoxDriver();	
	
}
@Test
public void IAM_Configure_SBA_Analyst_Roles_MainTest()throws Exception{
//Notes; Role Most be assigned at the database and validated at the front end.
 
//Open Firefox,Chrome or IE and navigate the certify.SBA.gov login page.
	mydriver.navigate().to(myurl);
	mydriver.manage().window().maximize();
// Locate the email search box and enter a valid email for the User who have been assign the analyst role.
	mydriver.findElement(By.xpath(".//*[@id='user_email']")).sendKeys(AAEmail);
//Locate the password search box and enter a valid password.
	mydriver.findElement(By.xpath(".//*[@id='user_password']")).sendKeys(AAPassW);
//Locate the Sign-in button and click on it to login.
	mydriver.findElement(By.xpath(".//*[@id='business_signin']")).click();
	Thread.sleep(3000);
	if(mydriver.getPageSource().contains("Signed in successfully")){
	mydriver.findElement(By.xpath(".//*[@id='labelid']")).click();
		}
	else{
		System.out.println("Successful sign in alert message not present");
		}
	Thread.sleep(3000); 
//Verify that the user that has been assign the analyst role log-in to the analyst dashboard.	
	if(mydriver.getPageSource().contains("Vendor Search")){
		System.out.println("User Successful sign-in to the assigned analyst dashboard, Pass");
		}
	else{
		System.out.println("User Did not Successful sign-in to the assigned analyst dashboard, Failed");
		mydriver.quit();
		}
	Thread.sleep(3000); 
//locate the logout button and click on it.
	mydriver.findElement(By.xpath(".//*[@id='js-navigation-menu']/li[3]/a")).click();
	Thread.sleep(3000);
	if(mydriver.getPageSource().contains("Signed out successfully")){
	mydriver.findElement(By.xpath(".//*[@id='labelid']")).click();
		}
	else{
		System.out.println("Successful sign in alert message not present");
		}
	Thread.sleep(3000); 
	
//Locate the log-in button and click on it.
	mydriver.findElement(By.xpath(".//*[@id='gov_login_box']/form[1]/button")).click();
    Thread.sleep(3000);
// Locate the email search box and enter a valid email for a vendor.
	mydriver.findElement(By.xpath(".//*[@id='user_email']")).sendKeys(VEmail);
//Locate the password search box and enter a valid password.
	mydriver.findElement(By.xpath(".//*[@id='user_password']")).sendKeys(VPassW);
//Locate the Sign-in button and click on it to login.
	mydriver.findElement(By.xpath(".//*[@id='business_signin']")).click();
	Thread.sleep(3000);
	if(mydriver.getPageSource().contains("Signed in successfully")){
	mydriver.findElement(By.xpath(".//*[@id='labelid']")).click();
		}
	else{
	System.out.println("Successful sign in alert message not present");
		}
	Thread.sleep(3000); 
//Verify that the user that has been assign the analyst role log-in to the analyst dashboard.	
	if(mydriver.getPageSource().contains("Business Profile")){
	System.out.println("User Successful sign-in to the BUSINESS PROFILE dashboard, Pass");
		}
	else{
	System.out.println("User Did not Successful sign-in to the BUSINESS PROFILE dashboard, Failed");
	mydriver.quit();
		}
	Thread.sleep(3000); 	

//locate the logout button and click on it.
	mydriver.findElement(By.xpath(".//*[@id='js-navigation-menu']/li[6]/a")).click();
	Thread.sleep(3000);
	if(mydriver.getPageSource().contains("Signed out successfully")){
	mydriver.findElement(By.xpath(".//*[@id='labelid']")).click();
		}
	else{
	System.out.println("Successful sign in alert message not present");
		}
	Thread.sleep(3000);
	
}
@After
public void IAM_Configure_SBA_Analyst_Roles_EndTest()throws Exception{
	mydriver.quit();
}


}
