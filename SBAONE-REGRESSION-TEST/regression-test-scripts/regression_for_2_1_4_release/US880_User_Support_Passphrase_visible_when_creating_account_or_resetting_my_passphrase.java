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

public class US880_User_Support_Passphrase_visible_when_creating_account_or_resetting_my_passphrase {
	public WebDriver mydriver;
	String myurl;
	String Email;
	String PassW;
	String Passphrass;
	String FN;
	String LN;
	String PN;
	String Re_PassW;
	
	
@Before
public void US880_User_Support_Passphrase_visible_when_creating_account_or_resetting_my_passphrase_Setup()throws Exception{
	myurl="https://certify.qa.sba-one.net/";
	Email="akanamontana@gmail.com";
	PassW="password";
	Passphrass="The Quick Brown Fox Jumps Over The Lazy Dog";
	
	
	
	    File file = new File("C:\\SBA-AUTOMATION-TEST\\SBAONE-REGRESSION-TEST\\libs\\IEDriverServer32b.exe");
		System.setProperty("webdriver.ie.driver", file.getAbsolutePath());	
		File file1 = new File("C:\\SBA-AUTOMATION-TEST\\SBAONE-REGRESSION-TEST\\libs\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file1.getAbsolutePath());
		//mydriver=new InternetExplorerDriver();
		//mydriver=new ChromeDriver();
		mydriver=new FirefoxDriver();	
	
		
}
@Test
public void US880_User_Support_Passphrase_visible_when_creating_account_or_resetting_my_passphrase_Maintest()throws Exception{
	//Open fireFox, Chrome or IE and navigate to to to the certify.sba.gov landing page.
	  mydriver.navigate().to(myurl);
	  mydriver.manage().window().maximize();
	//locate the create account button and click on it.
	  mydriver.findElement(By.xpath(".//*[@id='gov_login_box']/form[2]/button")).click();
	Thread.sleep(4000);
	//verify that the word Password on the password search box has been changed to Passphrase.
	if(mydriver.getPageSource().contains("Passphrase")){
	  System.out.println("The word password on the password search box has been successfully updated, Pass");	
	
	}
	else{
		  System.out.println("The word password on the password search box has not been successfully updated, Failed");	
           mydriver.quit();
	}
	
	
	
	//Verify that a link (Show my typing) is been created for users to view their password when typing.
	if(mydriver.getPageSource().contains("Show my typing")){
		  System.out.println("The link for users to view their password when typing is successfully implemented on the registration page, Pass");	
	//Locate the Passphrase search boxes and enter a passphrase.
		  mydriver.findElement(By.xpath(".//*[@id='user_password']")).sendKeys(Passphrass);
		  mydriver.findElement(By.xpath(".//*[@id='user_password_confirmation']")).sendKeys(Passphrass);
		  Thread.sleep(4000);
	//Locate the Show my typing link and click on it.
		  mydriver.findElement(By.xpath(".//*[@id='new_user']/div/div[1]/div/div[1]/div[2]/div[2]/a")).click();
		  Thread.sleep(3000);
    //Verify that the link 'Hide my typing' is activated and click on it to hide passphrase.
		  if(mydriver.getPageSource().contains("Hide my typing")){
	  System.out.println("The Hide my typing link is activated, Pass");
	  mydriver.findElement(By.xpath(".//*[@id='new_user']/div/div[1]/div/div[1]/div[2]/div[2]/a")).click();

	
	}
	
			else{
				  System.out.println("The Hide my typing link is not activated, Failed");	
		           mydriver.quit();
			}
		  
		  
		  System.out.println(mydriver.findElement(By.xpath(".//*[@id='user_password']")).getText());
		  
     
	//Verify that the passphrase entered matches the display passphrase.
		  if(mydriver.getPageSource().contains("The Quick Brown Fox Jumps")){
			  System.out.println("The passphrass entered successfully matches the display passphrass, 'show my typing' link is active, Failed");	
			
			}
			else{
				  System.out.println("The passphrass entered  successfully matches the display passphrass, 'show my typing' link is active, Pass");	
		           
			}
		  
		  
		}
		else{
			  System.out.println("The link for users to view their password when typing is not successfully implemented on the registration page, Pass, Failed");	
	          mydriver.quit();
		}
	//Locate the home button and click on it.
mydriver.navigate().back();
Thread.sleep(4000);
    //Locate the login button and click on it.
	mydriver.findElement(By.xpath(".//*[@id='gov_login_box']/form[1]/button")).click();

	Thread.sleep(2000);
    if(mydriver.getPageSource().contains("SIGN IN TO CERTIFY.SBA.GOV")){
    	System.out.println("Text Present, Login page validated. Test Pass");
    	}		
    	else{
    	System.out.println("Text Not Present, Login page Not validated. Test Failed");
    	}	
  //Enter a valid email.
    mydriver.findElement(By.xpath(".//*[@id='user_email']")).sendKeys(Email);
  //Enter a valid password.
    mydriver.findElement(By.xpath(".//*[@id='user_password']")).sendKeys(PassW);
  //Click on the "Submit" Button.
    mydriver.findElement(By.xpath(".//*[@id='business_signin']")).click();
    Thread.sleep(3000);
	if(mydriver.getPageSource().contains("Signed in successfully")){
		mydriver.findElement(By.xpath(".//*[@id='labelid']")).click();
	}
	else{
		System.out.println("Successful sign in alert message not present");
	}
	Thread.sleep(3000);
  //Locate the my profile button and click on it.
	mydriver.findElement(By.linkText("My Profile")).click();
	//Verify and click on the link Edit Password.
	if(mydriver.getPageSource().contains("Edit Passphrase")){
		mydriver.findElement(By.xpath(".//*[@id='dashboard-index']/div[2]/div/div/a")).click();
		System.out.println("Edith Password link is present and active, Pass");

	}
	else{
		System.out.println("Edith Password link is not present nor active, Failed");
	}
	//Verify if the Edit password text has been updated to Edit Passphrase.
	if(mydriver.getPageSource().contains("Edit Passphrase")){
		System.out.println("User is being navigated to the change password page, PASS");
		System.out.println("The Edith Password text has successfully updated to Edit Passphrase, PASS");

        
	}
	else{
		System.out.println("User is not being navigated to the change password page, Failed");
          mydriver.quit();
	}
	//Verify if the New password and new password confirmation search boxes has been updated to New passphrase and New passphrase confirmation.
	Thread.sleep(3000);
	if(mydriver.getPageSource().contains("New passphrase")){
		System.out.println("The New password text was successfully updated to New passphrase, Pass");
	}
	else{
		System.out.println("The New password text was Not successfully updated to New passphrase, Failed");
		mydriver.quit();
	} 
	Thread.sleep(3000);
	if(mydriver.getPageSource().contains("New passphrase confirmation")){
		System.out.println("The New passphrase confirmation text was successfully updated to New passphrase, Pass");
	}
	else{
		System.out.println("The New passphrase confirmation text was Not successfully updated to New passphrase, Failed");
		mydriver.quit();
	} 
	//Locate the the new passphrase search boxes and enter a passphrase.
    mydriver.findElement(By.xpath(".//*[@id='user_password']")).sendKeys(Passphrass);
    mydriver.findElement(By.xpath(".//*[@id='user_password_confirmation']")).sendKeys(Passphrass);
    Thread.sleep(4000);
  //Locate the Show my typing link and click on it.
	  mydriver.findElement(By.xpath(".//*[@id='edit_user']/div[2]/p/a")).click();
	  Thread.sleep(3000);
//Verify that the link 'Hide my typing' is activated and click on it to hide passphrase.
	  if(mydriver.getPageSource().contains("Hide my typing")){
System.out.println("The Hide my typing link is activated, Pass");
mydriver.findElement(By.xpath(".//*[@id='edit_user']/div[2]/p/a")).click();

}
		else{
			  System.out.println("The Hide my typing link is not activated, Failed");	
	           mydriver.quit();
		}
 //Locate the logout button and click on it.
	  mydriver.findElement(By.xpath(".//*[@id='js-navigation-menu']/li[6]/a")).click();
	  Thread.sleep(5000);
	  if(mydriver.getPageSource().contains("Signed out successfully")){
			System.out.println("Signed out was successfull, Pass");
			mydriver.findElement(By.xpath(".//*[@id='labelid']")).click();

		}
		else{
			System.out.println("Signed out successfull pop up alert not activated, Failed");
			
		} 
  //Click on the login button.
		mydriver.findElement(By.xpath(".//*[@id='gov_login_box']/form[1]/button")).click();
  //Verify if the Forgot your password text on the sign-in page has been updated to Forgot your passphrase.
		Thread.sleep(3000);
		if(mydriver.getPageSource().contains("Forgot your passphrase")){
			System.out.println("The Forget password text on the sign-in was successfully updated to New passphrase, Pass");
		}
		else{
			System.out.println("The Forget password text on the sign-in was Not successfully updated to New passphrase, Failed");
			mydriver.quit();
		} 
   //Click on the Forget password link.
		mydriver.findElement(By.xpath(".//*[@id='hp']/div[2]/div[1]/div[3]/span[1]/a")).click();
   //Verify that all the word password on the forget your passphrase page are all updated to passphrase.
		Thread.sleep(3000);
		if(mydriver.getPageSource().contains("Forgot Passphrase")){
			System.out.println("The Forgot Password text was successfully updated to Forgot Passphrase, Pass");
		}
		else{
			System.out.println("The Forgot Password text was Not successfully updated to Forgot Passphrase, Failed");
			mydriver.quit();
		} 
		
		
		if(mydriver.getPageSource().contains("Send reset passphrase instructions")){
			System.out.println("The Send rest password instructions text on the sign-in was successfully updated to Send rest passphrase instructions, Pass");
		}
		else{
			System.out.println("The Send rest password instructions text on the sign-in was Not successfully updated to Send rest passphrase instructions, Failed");
			mydriver.quit();
		} 
  //click on the home button
		mydriver.findElement(By.xpath(".//*[@id='js-navigation-menu']/li[1]/a")).click();
	
}
@After
public void US880_User_Support_Passphrase_visible_when_creating_account_or_resetting_my_passphrase_Endtest()throws Exception{
	mydriver.quit();
		
} 

}
