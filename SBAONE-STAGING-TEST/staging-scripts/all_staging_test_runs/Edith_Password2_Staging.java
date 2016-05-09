package all_staging_test_runs;

	import org.junit.After;
	import org.junit.Before;
	import org.junit.Test;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;

	public class Edith_Password2_Staging {
		public WebDriver  mydriver;
		String myurl;
		String Email;
		String PassW;
		String Old_PassW;
		String New_PassW;
		String New_PassW2;
		
	@Before
	public void Edith_Password2_Regression_Test_Setup()throws Exception{
		mydriver=new FirefoxDriver();
		myurl="https://www.staging-certify.sba.gov/users/sign_in";
		Email="staging2@mailinator.com";
		Old_PassW="Map Effect Applied Furniture 3365";
		
		New_PassW="Derico$336557135393803365";
		New_PassW2="Derico$336557135393803365";

		
		
	}
	@Test
	public void Edith_Password2_Regression_Test_Maintest()throws Exception{
	//Open Firefox,Chrome,and IE and navigate to the valid url.
		mydriver.navigate().to(myurl);
		mydriver.manage().window().maximize();
	//Locate the email search box and enter a valid email.
		mydriver.findElement(By.xpath(".//*[@id='user_email']")).sendKeys(Email);
	//Locate the password search box and enter a valid password.
		mydriver.findElement(By.xpath(".//*[@id='user_password']")).sendKeys(Old_PassW);
	//Locate the user Sign-in button and click on it.
		mydriver.findElement(By.xpath(".//*[@id='business_signin']")).click();
		Thread.sleep(4000);
		if(mydriver.getPageSource().contains("Signed in successfully")){
			mydriver.findElement(By.xpath(".//*[@id='labelid']")).click();}

	else{
		System.out.println("Successful sign in alert message not present");
	}
		
		
		Thread.sleep(3000);
		if(mydriver.getPageSource().contains("Invalid email or password")){

			mydriver.findElement(By.xpath(".//*[@id='labelid']")).click();
			//Locate the email search box and enter a valid email.
			mydriver.findElement(By.xpath(".//*[@id='user_email']")).sendKeys(Email);
		//Locate the password search box and enter a valid password.
			mydriver.findElement(By.xpath(".//*[@id='user_password']")).sendKeys(New_PassW);
		//Locate the user Sign-in button and click on it.
			mydriver.findElement(By.xpath(".//*[@id='business_signin']")).click();
			
			
			Thread.sleep(4000);
			
			
			if(mydriver.getPageSource().contains("Signed in successfully")){
				mydriver.findElement(By.xpath(".//*[@id='labelid']")).click();
			}
			else{
				System.out.println("Successful sign in alert message not present");
			}
			Thread.sleep(3000);
			//Locate the My Profile button on the left navigation and click on it.
					mydriver.findElement(By.linkText("My Profile")).click();
				//Verify and click on the link Edith Password.
					if(mydriver.getPageSource().contains("Edit Passphrase")){
						mydriver.findElement(By.xpath(".//*[@id='dashboard-index']/div[2]/div/div/a")).click();
						System.out.println("Edith Password link is present and active, Pass");

					}
					else{
						System.out.println("Edith Password link is not present nor active, Failed");
					}
			Thread.sleep(3000);
		//Verify that user is navigated to the change password page.
			if(mydriver.getPageSource().contains("Edit Passphrase")){
				System.out.println("User is being navigated to the change password page, PASS");
				System.out.println(mydriver.findElement(By.xpath(".//*[@id='main-content']")).getText());
			}
			else{
				System.out.println("User is not being navigated to the change password page, Failed");
		        mydriver.quit();
			}
			Thread.sleep(3000);
		//Locate the current password search box and enter a valid current password.
			mydriver.findElement(By.xpath(".//*[@id='user_current_password']")).sendKeys(New_PassW);
			Thread.sleep(3000);
		//locate that new password search box and enter the new password you wish to update to.
			mydriver.findElement(By.xpath(".//*[@id='user_password']")).sendKeys(Old_PassW);
			Thread.sleep(4000);
		//Verify the strength of the new password and accept only better or strong password.
			if(mydriver.getPageSource().contains("Strong")){
				System.out.println("Password strength - Strong");
			}
			else{
				Thread.sleep(3000);
				System.out.println(mydriver.findElement(By.xpath(".//*[@id='text_strength']")).getText());
			}
		//Locate the confirm new password search box and re-enter the new password.
			mydriver.findElement(By.xpath(".//*[@id='user_password_confirmation']")).sendKeys(Old_PassW);
		Thread.sleep(3000);
		//Locate the Update button and click on it.
		    mydriver.findElement(By.xpath(".//*[@id='submit']")).click();
		Thread.sleep(3000);	
		//Verify that User sees alert message 'Your account has been updated successfully'.
		    if(mydriver.getPageSource().contains("Your account has been updated successfully.")){
		    	System.out.println("User change password Successfully");
		    	mydriver.findElement(By.xpath(".//*[@id='labelid']")).click();
		    }
		    	else{
			    	System.out.println("User Edith password was not successfull Successfully");

		    	}
		    
		//Locate the logout button and click on it then log back in with the new password.
		    mydriver.findElement(By.xpath(".//*[@id='js-navigation-menu']/li[6]/a")).click();
		    Thread.sleep(3000);
		    if(mydriver.getPageSource().contains("Signed out successfully")){
				mydriver.findElement(By.xpath(".//*[@id='labelid']")).click();
			}
			else{
				System.out.println("Successful sign out alert message not present");
			}
		  //Locate and click on the log-in link.
			mydriver.findElement(By.xpath(".//*[@id='gov_login_box']/form[1]/button")).click();

		  //Locate the email search box and enter a valid email.
		  	mydriver.findElement(By.xpath(".//*[@id='user_email']")).sendKeys(Email);
		  //Locate the password search box and enter a valid password.
		  	mydriver.findElement(By.xpath(".//*[@id='user_password']")).sendKeys(Old_PassW);
		  //Locate the user Sign-in button and click on it.
		  	mydriver.findElement(By.xpath(".//*[@id='business_signin']")).click();
		  	Thread.sleep(3000);
		  	if(mydriver.getPageSource().contains("Signed in successfully")){
				mydriver.findElement(By.xpath(".//*[@id='labelid']")).click();
			}
			else{
				System.out.println("Successful sign in alert message not present");
			}
		  	Thread.sleep(4000);
		  	
		//Verify that user logged in successfully with the new updated password.
		  	if(mydriver.getPageSource().contains("644892788")){
		  		System.out.println("Password Update is Successful");
		  		//mydriver.close();
		  	}
		  	else{
		  		System.out.println("Password Update is Not Successful");
		       mydriver.quit();	
			
		  	}
		  	   //Log-out
			mydriver.findElement(By.xpath(".//*[@id='js-navigation-menu']/li[6]/a")).click();
			Thread.sleep(3000);
			
			if(mydriver.getPageSource().contains("Signed out successfully")){
				mydriver.findElement(By.xpath(".//*[@id='labelid']")).click();
			}
			else{
				System.out.println("Successful sign out alert message not present");
			}
		       mydriver.close();	

		  	return;


		  	
		  	}					
		
		else{
			System.out.println("First attempt to log-in with current password was successful, PASS");

		}
		Thread.sleep(4000);
	    //mydriver.close();
		
		
	    Thread.sleep(4000);
		
	//Locate the My Profile button on the left navigation and click on it.
		mydriver.findElement(By.xpath(".//*[@id='js-navigation-menu2']/li[2]/a")).click();
		Thread.sleep(4000);
	//Verify and click on the link Edith Password.
		if(mydriver.getPageSource().contains("Edit Passphrase")){
			mydriver.findElement(By.xpath(".//*[@id='dashboard-index']/div[2]/div/div/a")).click();
			System.out.println("Edith Password link is present and active, Pass");

		}
		else{
			System.out.println("Edith Password link is not present nor active, Failed");
		}
		
		Thread.sleep(3000);
	//Verify that user is navigated to the change password page.
		if(mydriver.getPageSource().contains("Edit Passphrase")){
			System.out.println("User is being navigated to the change password page, PASS");
			System.out.println(mydriver.findElement(By.xpath(".//*[@id='main-content']")).getText());
		}
		else{
			System.out.println("User is not being navigated to the change password page, Failed");
	        mydriver.quit();
		}
		Thread.sleep(3000);
	//Locate the current password search box and enter a valid current password.
		mydriver.findElement(By.xpath(".//*[@id='user_current_password']")).sendKeys(Old_PassW);
		Thread.sleep(3000);
	//locate that new password search box and enter the new password you wish to update to.
		mydriver.findElement(By.xpath(".//*[@id='user_password']")).sendKeys(New_PassW);
		Thread.sleep(4000);
	//Verify the strength of the new password and accept only better or strong password.
		if(mydriver.getPageSource().contains("Strong")){
			System.out.println("Password strength - Strong");
		}
		else{
			Thread.sleep(3000);
			System.out.println(mydriver.findElement(By.xpath(".//*[@id='text_strength']")).getText());
		}
	//Locate the confirm new password search box and re-enter the new password.
		mydriver.findElement(By.xpath(".//*[@id='user_password_confirmation']")).sendKeys(New_PassW2);
	Thread.sleep(3000);
	//Locate the Update button and click on it.
	    mydriver.findElement(By.xpath(".//*[@id='submit']")).click();
	Thread.sleep(3000);	
	//Verify that User sees alert message 'Your account has been updated successfully'.
	    if(mydriver.getPageSource().contains("Your account has been updated successfully.")){
	    	System.out.println("User change password Successfully");
	    	mydriver.findElement(By.xpath(".//*[@id='labelid']")).click();
	     //Click on the log-out button.
	    	mydriver.findElement(By.xpath(".//*[@id='js-navigation-menu']/li[6]/a")).click();

	  
	    Thread.sleep(3000);
	    if(mydriver.getPageSource().contains("Signed out successfully")){
			mydriver.findElement(By.xpath(".//*[@id='labelid']")).click();
		}
		else{
			System.out.println("Successful sign out alert message not present");
		}
	   //Locate and click on the log-in link.
		mydriver.findElement(By.xpath(".//*[@id='gov_login_box']/form[1]/button")).click();

	  //Locate the email search box and enter a valid email.
	  	mydriver.findElement(By.xpath(".//*[@id='user_email']")).sendKeys(Email);
	  //Locate the password search box and enter a valid password.
	  	mydriver.findElement(By.xpath(".//*[@id='user_password']")).sendKeys(New_PassW);
	  //Locate the user Sign-in button and click on it.
	  	mydriver.findElement(By.xpath(".//*[@id='business_signin']")).click();
	  	Thread.sleep(3000);
	  	if(mydriver.getPageSource().contains("Signed in successfully")){
			mydriver.findElement(By.xpath(".//*[@id='labelid']")).click();}

	else{
		System.out.println("Successful sign in alert message not present");
	}
	  	
	  	
	}
	}

	@After
	public void Edith_Password2_Regression_Test_Endtest()throws Exception{
		
		mydriver.quit();
		
		
		
		
		
	}


}
