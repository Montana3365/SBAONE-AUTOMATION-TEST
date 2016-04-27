package regression_for_2_1_4_release;

import java.io.File;
import java.util.concurrent.TimeUnit;

//import javax.swing.text.html.HTMLDocument.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;

public class US799_New_landing_dashboard_and_login_page_styles_Regression {
	public WebDriver mydriver;
	String myurl;
	String Email;
	String PassW;
	String WrongPassW;
@Before
public void US799_New_landing_dashboard_and_login_page_styles_MainSetup()throws Exception{
	myurl="https://certify.qa.sba-one.net/";
	Email="akanamontana@gmail.com";
	PassW="Map Effect Applied Furniture 3365";
	WrongPassW="just doing testing";
		
	File file = new File("C:\\SBA-AUTOMATION-TEST\\SBAONE-REGRESSION-TEST\\libs\\IEDriverServer32b.exe");
	System.setProperty("webdriver.ie.driver", file.getAbsolutePath());	
	File file1 = new File("C:\\SBA-AUTOMATION-TEST\\SBAONE-REGRESSION-TEST\\libs\\chromedriver.exe");
	System.setProperty("webdriver.chrome.driver", file1.getAbsolutePath());
	//mydriver=new InternetExplorerDriver();
	//mydriver=new ChromeDriver();
	mydriver=new FirefoxDriver();	
		
}
@Test
public void US799_New_landing_dashboard_and_login_page_styles_MainTest()throws Exception{
//Open Firefox, Chrome or IE and navigate to valid URL.
	mydriver.navigate().to(myurl);
	mydriver.manage().window().maximize();
//Verify that the log-in and a create account link are present and visible on the dashboard.
	if(mydriver.getPageSource().contains("LOGIN")){
		System.out.println("The login link is present and visible on the landing page, Pass");
		mydriver.findElement(By.xpath(".//*[@id='gov_login_box']/form[1]/button")).click();
		Thread.sleep(4000);
		if(mydriver.getPageSource().contains("SIGN IN TO CERTIFY.SBA.GOV")){
			System.out.println("The login link is present and Active on the landing page, Pass");
		}
		else{
			System.out.println("The login link is present But Not Active on the landing page, Failed");

		}
		}
	else{
		System.out.println("The login link is Not present and visible on the landing page, Failed");

	}
//Navigate back to the landing page.
	mydriver.navigate().back();
	Thread.sleep(3000);
	if(mydriver.getPageSource().contains("CREATE ACCOUNT")){
	System.out.println("The CREATE ACCOUNT link is present and visible on the landing page, Pass");
	mydriver.findElement(By.xpath(".//*[@id='gov_login_box']/form[2]/button")).click();
	Thread.sleep(4000);
	if(mydriver.getPageSource().contains("Please create a certify.sba.gov account")){
		System.out.println("The CREATE ACCOUNT link is present and Active on the landing page, Pass");
			}
	else{
	System.out.println("The CREATE ACCOUNT link is present But Not Active on the landing page, Failed");

		}
		}
	else{
	System.out.println("The CREATE ACCOUNT link is Not present and visible on the landing page, Failed");

		}	
//Navigate back to the landing page.
	 mydriver.navigate().back();
	 Thread.sleep(3000);
//Verify that the HOME, AM I ELIGIBLE and the HELP text are present and active on the landing page.
	 if(mydriver.getPageSource().contains("HOME")){
	System.out.println("The HOME Button is present and visible on the landing page, Pass");			
			}
	else{
	System.out.println("The The HOME Button is Not present and visible on the landing page, Failed");

		}
	//Navigate back to the landing page.
		//mydriver.navigate().back();
	Thread.sleep(3000);
	if(mydriver.getPageSource().contains("AM I ELIGIBLE")){
	System.out.println("The AM I ELIGIBLE link is present and visible on the landing page, Pass");
	mydriver.findElement(By.xpath(".//*[@id='js-navigation-menu']/li[2]/a")).click();
	Thread.sleep(4000);
	if(mydriver.getPageSource().contains("Prepare for Certification")){
		System.out.println("The AM I ELIGIBLE link is present and Active on the landing page, Pass");
				}
	else{
	System.out.println("The AM I ELIGIBLE link is present But Not Active on the landing page, Failed");

		}
			}
	else{
	System.out.println("The AM I ELIGIBLE link is Not present and visible on the landing page, Failed");

	}	
//Navigate back to the landing page.
		mydriver.navigate().back();	 
//verify that the NEW FEATURES,Welcome certify.SBA.gov! and COMING SOON links are active and present on the landing page.
		Thread.sleep(4000);	 
	if(mydriver.getPageSource().contains("New Features")){
	System.out.println("The New Features notes is present and visible on the landing page, Pass");			
		}
	else{
	System.out.println("The New Features notes is Not present and visible on the landing page, Failed");

		}
		
	Thread.sleep(3000);
	if(mydriver.getPageSource().contains("Upcoming Activities")){
	System.out.println("The COMING SOON notes is present and visible on the landing page, Pass");
		}
	else{
	System.out.println("The COMING SOON notes is present and visible on the landing page, Failed");

				}	
		 
	Thread.sleep(4000);
	if(mydriver.getPageSource().contains("Welcome to certify.SBA.gov")){
	System.out.println("The  Welcome to certify.SBA.gov text is present and visible on the landing page, Pass");
			}
	else{
	System.out.println("The Welcome to certify.SBA.gov text is Note present and visible on the landing page, Failed");
	}	 
//Verify that the HELP button is active and present on the landing page.
	Thread.sleep(3000);
	if(mydriver.getPageSource().contains("FAQ")){
	System.out.println("The HELP link is present and visible on the landing page, Pass");
	Thread.sleep(4000);
	mydriver.get("http://certify.qa.sba-one.net");
	mydriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	

	String main_window=mydriver.getWindowHandle();
	System.out.println("Before switching, title is ="+mydriver.getTitle());
	
	
	mydriver.findElement(By.xpath(".//*[@id='js-navigation-menu']/li[3]/a")).click();
	
	
	java.util.Set<String> S1=mydriver.getWindowHandles();
	java.util.Iterator<String> i1=S1.iterator();
	while(i1.hasNext()){
		String Second_window=i1.next();
		if(!main_window.equalsIgnoreCase(Second_window)){
			mydriver.switchTo().window(Second_window);
			Thread.sleep(1000);
			System.out.println("After switching title is ="+mydriver.getTitle());
			mydriver.close();
		}
		
	}
	
		
		
	mydriver.switchTo().window(main_window);
	System.out.println("Back to manin_window "+mydriver.getTitle());
	
//Verify and validate the Find Out button for the AM I ELIGIBLE program.
	Thread.sleep(3000);
	if(mydriver.getPageSource().contains("Find Out")){
	System.out.println("The Find Out Button for the AM I ELIGIBLE Program is present and visible on the landing page, Pass");
	mydriver.findElement(By.xpath(".//*[@id='hp']/div[4]/div/div[2]/div/form/input")).click();
	Thread.sleep(4000);
	if(mydriver.getPageSource().contains("The WOSB Federal Contract Program")){
	System.out.println("The Find Out Button for the AM I ELIGIBLE Program is present and Active on the landing page, Pass");
				}
	else{
	System.out.println("The Find Out Button for the AM I ELIGIBLE Program is present But Not Active on the landing page, Failed");

		}
			}
	else{
	System.out.println("The Find Out Button for the AM I ELIGIBLE Program is Not present and visible on the landing page, Failed");

	}	
//Navigate back to the landing page.
	mydriver.navigate().back();	
Thread.sleep(3000);	
//Locate the log-in button and click on it.
  mydriver.findElement(By.xpath(".//*[@id='gov_login_box']/form[1]/button")).click();
  
  Thread.sleep(3000);
//Login to dashboard, Locate the email search box and enter a valid email.
	mydriver.findElement(By.xpath(".//*[@id='user_email']")).sendKeys(Email);
//Locate the password search box and enter a valid password.
	mydriver.findElement(By.xpath(".//*[@id='user_password']")).sendKeys(PassW);
//Locate the Sign-in button and click on it to login.
	mydriver.findElement(By.xpath(".//*[@id='business_signin']")).click();
	Thread.sleep(3000);
	if(mydriver.getPageSource().contains("Signed in successfully")){
	mydriver.findElement(By.xpath(".//*[@id='labelid']")).click();
	System.out.println("User Successfully Sign-in to the Dashboard, Login-Validated.");

	}
	else{
	System.out.println("Successful sign in alert message not present");
	}
//Locate the my profile button and click on it.
	mydriver.findElement(By.xpath(".//*[@id='js-navigation-menu2']/li[3]/a")).click();
	Thread.sleep(3000);
//Verify that user is being directed to the right profile.
	if(mydriver.getPageSource().contains("akana")){
	System.out.println("User first name has been verify and maches, Pass.");
	}
	else{
	System.out.println("User first name has been verify But Did not mache, failed.");
	}
//Verify last name.
	if(mydriver.getPageSource().contains("montana")){
	System.out.println("User Last name has been verify and maches, Pass.");
	}
	else{
	System.out.println("User Last name has been verify But Did not mache, failed.");
	}
//Verify Email.
	if(mydriver.getPageSource().contains("akanamontana@gmail.com")){
	System.out.println("User email  has been verify and maches, Pass.");
	}
	else{
	System.out.println("User email has been verify But Did not mache, failed.");
	}	
	
//Locate the Logout button and click on it to log out.
	mydriver.findElement(By.xpath(".//*[@id='js-navigation-menu']/li[6]/a")).click();
	Thread.sleep(3000);
//Locate the alert message upon successful logout and close it.
	if(mydriver.getPageSource().contains("Signed out successfully")){
	mydriver.findElement(By.xpath(".//*[@id='labelid']")).click();
	}
	else{
	System.out.println("Invalid Error message upon successful logged-out is not activated, failed.");
	}	
	
//Attempt to log-in with wrong password after three times and verify if the system luck your account for 15 munites.
	mydriver.findElement(By.xpath(".//*[@id='gov_login_box']/form[1]/button")).click();

	mydriver.findElement(By.xpath(".//*[@id='user_email']")).sendKeys(Email);
	//Locate the password search box and enter a valid password.
	mydriver.findElement(By.xpath(".//*[@id='user_password']")).sendKeys(WrongPassW);
	//Locate the Sign-in button and click on it to login.
	mydriver.findElement(By.xpath(".//*[@id='business_signin']")).click();
//Locate the invalid login error message and accept it.
	Thread.sleep(3000);
	if(mydriver.getPageSource().contains("Invalid email or password")){
	mydriver.findElement(By.xpath(".//*[@id='labelid']")).click();
	}
	else{
	System.out.println("Invalid Error message upon entering an invalid password not activated, failed.");
	}	
	
//Attempt the  invalid password for the 2nd time and click on the continue button.
	mydriver.findElement(By.xpath(".//*[@id='user_email']")).sendKeys(Email);
    mydriver.findElement(By.xpath(".//*[@id='user_password']")).sendKeys(WrongPassW);
    mydriver.findElement(By.xpath(".//*[@id='business_signin']")).click();
//Verify that User sees Error message(You have one more attempt before your account is locked).
    Thread.sleep(3000);
	if(mydriver.getPageSource().contains("You have one more attempt before your account is locked")){
	System.out.println("Error message(You have one more attempt before your account is locked) is being activated upon the second time user entered a wrong password, Pass.");
	mydriver.findElement(By.xpath(".//*[@id='labelid']")).click();
	}
	else{
	System.out.println("Error message(You have one more attempt before your account is locked) is NOT being activated upon the second time user entered a wrong password, failed.");
	}	
Thread.sleep(3000);	
//Attempt the Wrong password again for the 3rd time and verify if user is being lucked out of the system.
    mydriver.findElement(By.xpath(".//*[@id='user_email']")).sendKeys(Email);
    mydriver.findElement(By.xpath(".//*[@id='user_password']")).sendKeys(WrongPassW);
    mydriver.findElement(By.xpath(".//*[@id='business_signin']")).click();
//Verify that User sees Error message(You have one more attempt before your account is locked).
  Thread.sleep(3000);
   if(mydriver.getPageSource().contains("Your account has been locked, please wait 24 hours")){
	System.out.println("Error message(Your account has been locked, please wait 24 hours) is being activated upon the 3rd time user entered a wrong password, Pass.");
	mydriver.findElement(By.xpath(".//*[@id='labelid']")).click();
}
    else{
	System.out.println("Error message(Your account has been locked, please wait 24 hours) is Not being activated, failed.");
}	
//Verify that User sees Error message(Your account has been locked, please wait 24 hours).
   Thread.sleep(3000);
	if(mydriver.getPageSource().contains("Your account has been locked, please wait 24 hours")){
	System.out.println("Error message(Your account has been locked, please wait 24 hours) is being activated upon the second time user entered a wrong password, Pass.");
	}
	else{
	System.out.println("Error message(Your account has been locked, please wait 24 hours) is Not being activated, Failed");
   Thread.sleep(3000);
	if(mydriver.getPageSource().contains("Your account has been locked, please wait 24 hours")){
	System.out.println("Error message(Your account has been locked, please wait 24 hours) is being activated upon the 3rd time user entered a wrong password, Pass.");
	mydriver.findElement(By.xpath(".//*[@id='labelid']")).click();
	}
	else{
	System.out.println("Error message(You have one more attempt before your account is locked) is NOT being activated upon the second time user entered a wrong password, failed.");
	}	
	
}
// Now, attempt logging in with valid data and verify if user is lucked out as stated before.
	mydriver.findElement(By.xpath(".//*[@id='user_email']")).sendKeys(Email);
	mydriver.findElement(By.xpath(".//*[@id='user_password']")).sendKeys(PassW);
	mydriver.findElement(By.xpath(".//*[@id='business_signin']")).click();
	Thread.sleep(5000);
//Verify if Error message(Your account has been locked, please wait 24 hours) is being activated even with valid login data.
	if(mydriver.getPageSource().contains("Your account has been locked, please wait 24 hours")){
	System.out.println("Error message(Your account has been locked, please wait 24 hours) is being activated upon the 4th time user entered Valid credentials, Pass.");
	mydriver.findElement(By.xpath(".//*[@id='labelid']")).click();
	}
	else{
	System.out.println("Your account has been locked, please wait 24 hours) is NOT being activated upon the 4th time user entered valid credentials, failed.");
	}
	

	
	
	}}
@After
public void US799_New_landing_dashboard_and_login_page_styles_EndTest()throws Exception{
	mydriver.quit();
}
 

}
