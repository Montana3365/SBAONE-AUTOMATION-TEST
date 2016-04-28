package all_staging_test_runs;

	import java.io.File;

	import org.junit.After;
		import org.junit.Before;
		import org.junit.Test;
		import org.openqa.selenium.By;
		import org.openqa.selenium.WebDriver;
	//import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	//import org.openqa.selenium.ie.InternetExplorerDriver;

	public class Edith_Password_Staging {
			public WebDriver  mydriver;
			String myurl;
			String Email;
			String Current_PassW;
			String Current_PassW2;
			String Weak_PassW;
	        String Better_PW;
			String New_PassW;
			String Confirm_New_PassW;
			
			
		@Before
		public void Edith_Password_Regression_Test_Setup()throws Exception{
			myurl="https://staging-certify.sba.gov/users/sign_in";
			Email="staging@mailinator.com";
			Current_PassW="Map Effect Applied Furniture 3365";
			Current_PassW2="Map Effect Applied Furniture 3365";
			Weak_PassW="1234";
			New_PassW="Map Effect Applied Furniture 9883";
			Confirm_New_PassW="Map Effect Applied Furniture 9883";
			Better_PW="Derico#3365";
			File file = new File("C:\\SBA-AUTOMATION-TEST\\SBAONE-REGRESSION-TEST\\libs\\IEDriverServer32b.exe");
			System.setProperty("webdriver.ie.driver", file.getAbsolutePath());	
			File file1 = new File("C:\\SBA-AUTOMATION-TEST\\SBAONE-REGRESSION-TEST\\libs\\chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", file1.getAbsolutePath());
			//mydriver=new InternetExplorerDriver();
			//mydriver=new ChromeDriver();
			mydriver=new FirefoxDriver();
			
			
			
		}
		@Test
		public void Edith_Password_Regression_Test_Maintest()throws Exception{
		//Open Firefox,Chrome,and IE and navigate to the valid url.
			mydriver.navigate().to(myurl);
			mydriver.manage().window().maximize();
		//Locate the email search box and enter a valid email.
			mydriver.findElement(By.xpath(".//*[@id='user_email']")).sendKeys(Email);
		//Locate the password search box and enter a valid password.
			mydriver.findElement(By.xpath(".//*[@id='user_password']")).sendKeys(Current_PassW);
		//Locate the user Sign-in button and click on it.
			mydriver.findElement(By.xpath(".//*[@id='business_signin']")).click();
			
			Thread.sleep(4000);
			if(mydriver.getPageSource().contains("Invalid email or password")){

				mydriver.findElement(By.xpath(".//*[@id='alert-close-button']")).click();
				//Locate the email search box and enter a valid email.
				mydriver.findElement(By.xpath(".//*[@id='user_email']")).sendKeys(Email);
			//Locate the password search box and enter a valid password.
				mydriver.findElement(By.xpath(".//*[@id='user_password']")).sendKeys(Current_PassW2);
			//Locate the user Sign-in button and click on it.
				mydriver.findElement(By.xpath(".//*[@id='business_signin']")).click();
							
			}
			else{
				System.out.println("First attempt to log-in with current password was successful, PASS");

			}
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
			
		//Verify if user is directed to the change password page 'Edit User'.
			if(mydriver.getPageSource().contains("Edit Passphrase")){
				System.out.println("User is being navigated to the change password page, PASS");
		        
			}
			else{
				System.out.println("User is not being navigated to the change password page, Failed");

			}
		//Enter current and new password and Attempt to Update without entering the confirm new password data.
		    mydriver.findElement(By.xpath(".//*[@id='user_current_password']")).sendKeys(Current_PassW); 
		    Thread.sleep(3000);
		    mydriver.findElement(By.xpath(".//*[@id='user_password']")).sendKeys(New_PassW);
		    Thread.sleep(4000);
		    System.out.println(mydriver.findElement(By.xpath(".//*[@id='text_strength']")).getText());
			mydriver.findElement(By.xpath(".//*[@id='submit']")).click();
			Thread.sleep(3000);
			System.out.println(mydriver.findElement(By.xpath("html/body/div[1]/label/div/div")).getText());

		//Verify that user sees alert message requesting user to enter all or confirm password.
			if(mydriver.getPageSource().contains("Password confirmation doesn't match Password")){
			System.out.println("Usee sees alert messages requesting user to confirm password or password doesen't match, PASS");
			mydriver.findElement(By.xpath(".//*[@id='labelid']")).click();

			}
			else{
				System.out.println("Usee did not see alert messages requesting user to enter current,new and confirm password, Failed");
				System.out.println(mydriver.findElement(By.xpath("html/body/div[1]/label/div/div")).getText());

			}
			
	//Enter current and weak new password and Attempt to Update without entering the confirm new password data.
		    mydriver.findElement(By.xpath(".//*[@id='user_current_password']")).clear(); 
		    mydriver.findElement(By.xpath(".//*[@id='user_current_password']")).sendKeys(Current_PassW); 
		    Thread.sleep(3000);
		    mydriver.findElement(By.xpath(".//*[@id='user_password']")).clear();
		    mydriver.findElement(By.xpath(".//*[@id='user_password']")).sendKeys(Weak_PassW);
		    Thread.sleep(4000);
		    System.out.println(mydriver.findElement(By.xpath(".//*[@id='text_strength']")).getText());
			Thread.sleep(3000);
	//Verify that the weak password alert is activated when user enter a weak password.
			if(mydriver.getPageSource().contains("Weak")){
				System.out.println("User sees alert message saying the password user entered is weak, PASS");
			}
			else{
				System.out.println("User did Not see alert message saying the password user entered is weak, Failed");

			}
			Thread.sleep(3000);
		    mydriver.findElement(By.xpath(".//*[@id='user_password']")).clear();
		    mydriver.findElement(By.xpath(".//*[@id='user_password']")).sendKeys(Better_PW);
		    Thread.sleep(4000);
		  //Verify that the Better password alert is activated when user enter a weak password.
		  		if(mydriver.getPageSource().contains("Better")){
		  			System.out.println("User sees alert message saying the password user entered is Better, PASS");
		  		    System.out.println(mydriver.findElement(By.xpath(".//*[@id='text_strength']")).getText());

		  		}
		  		else{
		  			System.out.println("User did Not see alert message saying the password user entered is Better, Failed");

		  		}
		
		}
		@After
		public void Edith_Password_Regression_Test_Endtest()throws Exception{
			
			mydriver.quit();
			
			
			
			
			
		}


}
