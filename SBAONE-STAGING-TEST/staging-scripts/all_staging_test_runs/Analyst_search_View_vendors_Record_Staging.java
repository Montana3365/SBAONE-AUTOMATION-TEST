package all_staging_test_runs;

	import java.io.File;
	import org.junit.After;
	import org.junit.Before;
	import org.junit.Test;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	//import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;

   public class Analyst_search_View_vendors_Record_Staging {
 
		public WebDriver mydriver;
		String myurl;
		String Email;
		String PassW;
		String DUNs1;
		String DUNs2;
		String DUNs3;
		String DUNs4;
		String DUNs5;
		String DUNs6;
		String DUNs7;
		String DUNs8;
		String DUNs9;
		String DUNs10;
		String BusN1;
		String BusN2;
		String BusN3;
		String BusN4;
			
		

	 @Before
	 public void Analyst_search_View_vendors_Record_Regression_Setup()throws Exception{
		 mydriver=new FirefoxDriver();
		 Email="StaginAnalyst@mailinator.com";
		 PassW="Map Effect Applied Funiture 3365";
		 myurl="https://www.staging-certify.sba.gov/users/sign_in";
		 DUNs1="119698675";
		 DUNs2="111419538";
		 DUNs3="111435873";
		 DUNs4="112286644";
		 DUNs5="116461328";
		 DUNs6="118177954";
		 DUNs7="118435913";
		 DUNs8="119698675";
		 DUNs9="123481741";
		 DUNs10="124317426";
		 BusN1="Entity 75 Legal";
		 
		 
		 
		 File file = new File("C:\\Users\\Derec Nguni\\Desktop\\Jar-files\\IEDriverServer.exe");
		 System.setProperty("webdriver.ie.driver", file.getAbsolutePath());	
		 File file1 = new File("C:\\Users\\Derec Nguni\\Desktop\\Jar-files\\chromedriver.exe");
		 System.setProperty("webdriver.chrome.driver", file1.getAbsolutePath());
		 //mydriver=new InternetExplorerDriver();
		 //mydriver=new ChromeDriver();
		 
		 
	 }
	 @Test
	 public void Analyst_search_View_vendors_Record_Regression_Maintest()throws Exception{
	//open Firefox,Chrome or IE and Navigate to valid URL.
		 mydriver.navigate().to(myurl);
		 mydriver.manage().window().maximize();
		 
		

		 
	//Step 01. Login to dashboard, Locate the email search box and enter a valid email.
		mydriver.findElement(By.xpath(".//*[@id='user_email']")).sendKeys(Email);
	//Step 2. Locate the password search box and enter a valid password.
		mydriver.findElement(By.xpath(".//*[@id='user_password']")).sendKeys(PassW);
	//Step 3. Locate the Sign-in button and click on it to login.
		mydriver.findElement(By.xpath(".//*[@id='business_signin']")).click();
		Thread.sleep(3000);
		if(mydriver.getPageSource().contains("Signed in successfully")){
			mydriver.findElement(By.xpath(".//*[@id='labelid']")).click();
		}
		else{
			System.out.println("Successful sign in alert message not present");
		}
		Thread.sleep(3000); 
	//Locate the search for a vendor search box and emter a valid duns number.
		mydriver.findElement(By.xpath(".//*[@id='query']")).sendKeys(DUNs1);
	//Locate the search button and click on it.
		mydriver.findElement(By.xpath(".//*[@id='analyst-search']/div/div[2]/button")).click();
	//Print out the business information for each search.
		System.out.println(mydriver.findElement(By.xpath(".//*[@id='business_search']/div[4]/div")).getText());
		Thread.sleep(4000);
	//Locate the view profile button and click on it.
		mydriver.findElement(By.xpath(".//*[@id='view_business_profile']")).click();
		Thread.sleep(3000);
		if(mydriver.getPageSource().contains("Active")){
			mydriver.findElement(By.xpath(".//*[@id='business_search']/div[4]/table/tbody/tr/td[4]/a[1]")).click();
		}
		else{
			System.out.println("No completed certification on the business profile");
		}
		Thread.sleep(3000);
	//Verify that the view button works.
		if(mydriver.getPageSource().contains("Summary")){
			System.out.println("The view certification button by analyst is active and working correctly, Pass");
		}
		else{
			System.out.println("The view certification button by analyst is Not active nor working correctly, Failed");
		}
		mydriver.navigate().back();
		Thread.sleep(2000);
		mydriver.navigate().back();
		Thread.sleep(2000);

		
	//Clear the search for a vendor search box and enter a new valid duns number	 
		mydriver.findElement(By.xpath(".//*[@id='query']")).clear();
		mydriver.findElement(By.xpath(".//*[@id='query']")).sendKeys(BusN1);
		mydriver.findElement(By.xpath(".//*[@id='analyst-search']/div/div[2]/button")).click();
		Thread.sleep(4000);	
		
		//Locate the view profile button and click on it.
				mydriver.findElement(By.xpath(".//*[@id='view_business_profile']")).click();
				Thread.sleep(3000);
				if(mydriver.getPageSource().contains("Active")){
					mydriver.findElement(By.xpath(".//*[@id='business_search']/div[4]/table/tbody/tr/td[4]/a[1]")).click();
				}
				else{
					System.out.println("No completed certification on the business profile");
				}
				Thread.sleep(3000);
			//Verify that the view button works.
				if(mydriver.getPageSource().contains("Summary")){
					System.out.println("The view certification button by analyst is active and working correctly, Pass");
				}
				else{
					System.out.println("The view certification button by analyst is Not active nor working correctly, Failed");
				}
				mydriver.navigate().back();
				mydriver.navigate().back();
				
		
		
	 }	 	 
	 
	@After
	public void US693_Analyst_search_View_vendors_Record_Regression_Endtest()throws Exception{
	mydriver.quit();
	}



}
