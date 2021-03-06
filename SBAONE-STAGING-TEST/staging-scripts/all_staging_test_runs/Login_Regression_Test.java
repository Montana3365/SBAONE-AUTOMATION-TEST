package all_staging_test_runs;

	import java.io.File;



	import org.junit.After;
	import org.junit.Before;
	import org.junit.Test;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	//import org.openqa.selenium.ie.InternetExplorerDriver;





	public class Login_Regression_Test {
		
	public WebDriver mydriver;
	String myURL;
	String Myemail;
	String pass;

		@Before
		public void Login_Regression_Test_setup_setup()throws Exception{
		
		Myemail="akanamontana@gmail.com";
		pass="Map Effect Applied Funiture 3365";
		myURL="https://www.staging-certify.sba.gov/users/sign_in";
		
		File file = new File("C:\\SBA-AUTOMATION-TEST\\SBAONE-REGRESSION-TEST\\libs\\IEDriverServer32b.exe");
		   System.setProperty("webdriver.ie.driver", file.getAbsolutePath());	
		   File file1 = new File("C:\\SBA-AUTOMATION-TEST\\SBAONE-REGRESSION-TEST\\libs\\chromedriver.exe");
		   System.setProperty("webdriver.chrome.driver", file1.getAbsolutePath());
		   //mydriver=new InternetExplorerDriver();
		   //mydriver=new ChromeDriver();
		   mydriver=new FirefoxDriver();
		
		}
		
		@Test
		public void Login_Regression_Test_mymaintest()throws Exception{
			
			
		
			//Step 1. Open Firefox Browser and navigate to valid url.
			mydriver.navigate().to(myURL);
			Thread.sleep(3000);
			mydriver.manage().window().maximize();
			Thread.sleep(6000);
		
			//Step 2. Verify that Login page has a Business Login for Business users.
			if(mydriver.getPageSource().contains("Login")){
				System.out.println("Login Page present, page validated");
			}
			else{
				System.out.println("Login Page Not present, page Not validated");
			}
			
			//Step 2. Locate test data store in the PC and use it to test for email and password then login to validate page.
			//locate the email search box and enter a valid email.
				mydriver.findElement(By.xpath(".//*[@id='user_email']")).sendKeys(Myemail);
			//Locate the password search box and enter a valid password.
				Thread.sleep(2000);
				mydriver.findElement(By.xpath(".//*[@id='user_password']")).sendKeys(pass); 
			//Locate the login button and click on it to sign in.
				Thread.sleep(2000);
				mydriver.findElement(By.xpath(".//*[@id='business_signin']")).click();
			//Print out the to validate that user login was successful for each user. 
				Thread.sleep(4000);
				
				if(mydriver.getPageSource().contains("Signed in successfully")){
					mydriver.findElement(By.xpath(".//*[@id='labelid']")).click();}

			else{
				System.out.println("Successful sign in alert message not present");
			}
			Thread.sleep(4000);
				//Locate the My Profile button on the left navigation and click on it.
				mydriver.findElement(By.linkText("My Profile")).click();
			//Verify user Profile.
				Thread.sleep(4000);
				if(mydriver.getPageSource().contains("akanamontana@gmail.com")){
					System.out.println("Sign-in was successfull");
				}
				else{
					System.out.println("Sign-in was Not successfull");
					mydriver.quit();
				}
					
			
			
			
			
			
			
		}
		
		
		
		
		

		@After
		public void Login_Regression_Test_teardown()throws Exception{
		mydriver.quit();
	}


}
