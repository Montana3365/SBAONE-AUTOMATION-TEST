package all_production_test;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class US855_Improve_Text_Work_In_Progress_From_All_pages {
	public WebDriver mydriver;
	String myurl;
	String Email;
	String PassW;
	String Aemail;
	String ApassW;
	
	@Before
public void US855_Improve_Text_Work_In_Progress_From_All_pages_Setup()throws Exception{
	myurl="https://certify.sba.gov/";
	Email="donald.patti@cedarpointconsulting.com";
	PassW="They call me Ishmael";
	Aemail="arun@enquizit.com";
	ApassW="Be at least 8 characters";
		
	File file = new File("C:\\SBA-AUTOMATION-TEST\\SBAONE-REGRESSION-TEST\\libs\\IEDriverServer32b.exe");
	System.setProperty("webdriver.ie.driver", file.getAbsolutePath());	
	File file1 = new File("C:\\SBA-AUTOMATION-TEST\\SBAONE-REGRESSION-TEST\\libs\\chromedriver.exe");
	System.setProperty("webdriver.chrome.driver", file1.getAbsolutePath());
	//mydriver=new InternetExplorerDriver();
	//mydriver=new ChromeDriver();
	mydriver=new FirefoxDriver();			
	}
	@Test
public void US855_Improve_Text_Work_In_Progress_From_All_pages_MainTest()throws Exception{
	//Open Firefox,IE or Chrome and navigate to the Certify.SBA.gov landing page.
	    mydriver.navigate().to(myurl);
	    mydriver.manage().window().maximize();
	//Verify if the text 'If you don�t find what you need, visit SBA.gov' is present on the landing page.
	    if(mydriver.getPageSource().contains("Your experience is important to us")){
	    	System.out.println("Test 'If you don�t find what you need, visit SBA.gov' is updated on the landing page, Pass");
	    }
	    else{
	    	System.out.println("Test 'If you don�t find what you need, visit SBA.gov' is Not on the landing page");

	    }
    //Locate the Find Out button and click on it.
	    mydriver.findElement(By.xpath(".//*[@id='hp']/div[4]/div/div[2]/div/form/input")).click();
	    Thread.sleep(3000);
	//Verify if the text 'If you don�t find what you need, visit SBA.gov' is present on the Am I Eligible page.
	    if(mydriver.getPageSource().contains("Your experience is important to us")){
	    	System.out.println("Test 'Your experience is important to us. Please email us at  certify@sba.gov with comments or suggestions' is updated on the Am I Eligible page, Pass");
	    }
	    else{
	    	System.out.println("Test 'Your experience is important to us. Please email us at  certify@sba.gov with comments or suggestions' is Not being updated on the Am I Eligible page, Failed");
	   mydriver.quit();
	    }
	mydriver.navigate().back();
	Thread.sleep(3000);

	//Locate the Create account button and click on it.
    mydriver.findElement(By.xpath(".//*[@id='gov_login_box']/form[2]/button")).click();
    Thread.sleep(3000);

  //Verify if the text 'If you don�t find what you need, visit SBA.gov' is present on the Create account page.
    if(mydriver.getPageSource().contains("Your experience is important to us")){
    	System.out.println("Test 'Your experience is important to us. Please email us at  certify@sba.gov with comments or suggestions' is updated on the Create account page, Pass");
    }
    else{
    	System.out.println("Test 'Your experience is important to us. Please email us at  certify@sba.gov with comments or suggestions' is Not being updated on the Create account page, Failed");
   mydriver.quit();
    }
	mydriver.navigate().back();
	Thread.sleep(3000);

 //Locate the Log-in button and click on it.
	mydriver.findElement(By.xpath(".//*[@id='gov_login_box']/form[1]/button")).click();
    Thread.sleep(3000);

  //Verify if the text 'If you don�t find what you need, visit SBA.gov' is present on the login page.
    if(mydriver.getPageSource().contains("Your experience is important to us")){
    	System.out.println("Test 'Your experience is important to us. Please email us at  certify@sba.gov with comments or suggestions' is updated on the Login page, Pass");
    }
    else{
    	System.out.println("Test 'Your experience is important to us. Please email us at  certify@sba.gov with comments or suggestions' is Not being updated on the Login page, Failed");
   mydriver.quit();
    }
	mydriver.navigate().back();
	Thread.sleep(3000);

	//Locate the Log-in button and click on it.
	mydriver.findElement(By.xpath(".//*[@id='gov_login_box']/form[1]/button")).click();	
	//Locate the email search box and enter a valid email.
	mydriver.findElement(By.xpath(".//*[@id='user_email']")).sendKeys(Email);
	//Locate password search box and enter a valid password.
	mydriver.findElement(By.xpath(".//*[@id='user_password']")).sendKeys(PassW);
	//Click on the sign-in button.
	mydriver.findElement(By.xpath(".//*[@id='business_signin']")).click();	
	Thread.sleep(3000);
	if(mydriver.getPageSource().contains("Signed in successfully")){
		mydriver.findElement(By.xpath(".//*[@id='labelid']")).click();
	}
	else{
		System.out.println("Successful sign in alert message not present");
	}
    Thread.sleep(4000);
	  //Verify if the text 'If you don�t find what you need, visit SBA.gov' is present on the Vendor dashboard.
	    if(mydriver.getPageSource().contains("Your experience is important to us")){
	    	System.out.println("Test 'Your experience is important to us. Please email us at  certify@sba.gov with comments or suggestions' is updated on the Vendor dashboard, Pass");
	    }
	    else{
	    	System.out.println("Test 'Your experience is important to us. Please email us at  certify@sba.gov with comments or suggestions' is Not being updated on the Vendor dashboard, Failed");
	   mydriver.quit();
	    }
  // locate the sign out button and click on it.
		mydriver.findElement(By.xpath(".//*[@id='js-navigation-menu']/li[6]/a")).click();
		Thread.sleep(3000);
		if(mydriver.getPageSource().contains("Signed out successfully")){
			mydriver.findElement(By.xpath(".//*[@id='labelid']")).click();
		}
		else{
			System.out.println("Successful sign in alert message not present");
		}	
		//Locate the Log-in button and click on it.
		mydriver.findElement(By.xpath(".//*[@id='gov_login_box']/form[1]/button")).click();	
		//Locate the email search box and enter a valid analyst email.
		mydriver.findElement(By.xpath(".//*[@id='user_email']")).sendKeys(Aemail);
		//Locate password search box and enter a valid analyst password.
		mydriver.findElement(By.xpath(".//*[@id='user_password']")).sendKeys(ApassW);
		//Click on the sign-in button.
		mydriver.findElement(By.xpath(".//*[@id='business_signin']")).click();	
		Thread.sleep(3000);
		if(mydriver.getPageSource().contains("Signed in successfully")){
			mydriver.findElement(By.xpath(".//*[@id='labelid']")).click();
		}
		else{
			System.out.println("Successful sign in alert message not present");
		}
        Thread.sleep(4000);
		  //Verify if the text 'If you don�t find what you need, visit SBA.gov' is present on the Vendor dashboard.
		    if(mydriver.getPageSource().contains("Your experience is important to us")){
		    	System.out.println("Test 'Your experience is important to us. Please email us at  certify@sba.gov with comments or suggestions' is updated on the Vendor dashboard, Pass");
		    }
		    else{
		    	System.out.println("Test 'Your experience is important to us. Please email us at  certify@sba.gov with comments or suggestions' is Not being updated on the Vendor dashboard, Failed");
		   mydriver.quit();
		    }

		 // locate the sign out button and click on it.
			mydriver.findElement(By.xpath(".//*[@id='js-navigation-menu']/li[3]/a")).click();
			Thread.sleep(3000);
			if(mydriver.getPageSource().contains("Signed out successfully")){
				mydriver.findElement(By.xpath(".//*[@id='labelid']")).click();
			}
			else{
				System.out.println("Successful sign in alert message not present");
			}	
	}

@After
public void US855_Improve_Text_Work_In_Progress_From_All_pages_Endtest()throws Exception{
	mydriver.quit();
}
}






	