package regression_for_2_1_4_release;

import java.io.File;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;
//import org.openqa.selenium.support.ui.Select;

	public class US859_Vendor_Admin_User_Profile {
		  private WebDriver driver;
			String baseUrl;
			String Login;
			String Password;
			String duns_1;
			
			
		  private StringBuffer verificationErrors = new StringBuffer();
		  
			@Before
			public void setUp() throws Exception {		
		    Login="analyst3@mailinator.com";
		    Password="password";
		    duns_1="275276652";
		    
		    //QA URL
			baseUrl = "http://certify.qa.sba-one.net/";
			//DEMO URL
			//baseUrl = "http://demo.qa.sba-one.net/";
				   
//			setting up IE, Chrome, and FireFox Web Drivers
			File file = new File("C:\\SBA-AUTOMATION-TEST\\SBAONE-REGRESSION-TEST\\libs\\IEDriverServer32b.exe");
			System.setProperty("webdriver.ie.driver", file.getAbsolutePath());	
			File file1 = new File("C:\\SBA-AUTOMATION-TEST\\SBAONE-REGRESSION-TEST\\libs\\chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", file1.getAbsolutePath());
			//driver=new InternetExplorerDriver();
			//driver=new ChromeDriver();
			driver=new FirefoxDriver();
			
			driver.manage().window().maximize();
			}
			
			@Test
			public void testSmokeLogin() throws Exception {
		//Step 1 - Open QA site   
				driver.get(baseUrl);
				System.out.println("Step 1 - URL: " + baseUrl);
			

			//Click on the Login link and log in
				Thread.sleep(2000);
				driver.findElement(By.xpath(".//*[@id='gov_login_box']/form[1]/button")).click();
				Thread.sleep(2000);
			
		//Step 2 - Log in as an Analyst
				System.out.println("Step 2 - Log in as an Analyst");
				driver.findElement(By.xpath(".//*[@id='user_email']")).clear();
				driver.findElement(By.xpath(".//*[@id='user_email']")).sendKeys(Login);
				System.out.println("  Login ID: " + Login);
		    
		    //Enter a valid Password
				driver.findElement(By.xpath(".//*[@id='user_password']")).clear();
				driver.findElement(By.xpath(".//*[@id='user_password']")).sendKeys(Password);
				System.out.println("  Password: " + Password);
		    
		    //Click the Sign-in button
				driver.findElement(By.xpath(".//*[@id='business_signin']")).click();
				System.out.println("  Click on Login Link and log in");
				
			//Close pop up window	
				Thread.sleep(2000);
				if(driver.getPageSource().contains("Signed in successfully")){
					driver.findElement(By.xpath(".//*[@id='labelid']")).click();
				}
				else{
					System.out.println("  Successful sign in alert message not present");
				}
				
			
		 //Step 3 - Verify if the Analyst Dashboard is displayed
				System.out.println("Step 3 - Verify if the Analyst Dashboard is displayed");
				try {
					assertEquals("VENDOR SEARCH", driver.findElement(By.xpath(".//*[@id='business_search']/div[1]")).getText());
					System.out.println("  Analyst Dashboard is displayed - Pass");
				} catch (Error e) {
					verificationErrors.append(e.toString());
					System.out.println("  Analyst Dashboard is displayed - <<FAILED>>");
					driver.findElement(By.xpath(".//*[@id='js-navigation-menu']/li[1]/a")).click();
				}
				Thread.sleep(2000);
				
				
				//Enter DUNS number to search on
				System.out.println("  Enter DUNS number to search on");
				driver.findElement(By.xpath(".//*[@id='query']")).click();
				driver.findElement(By.xpath(".//*[@id='query']")).sendKeys(duns_1);
				Thread.sleep(2000);
				
				//Click the Search button
				System.out.println("  Click the Search button");
				driver.findElement(By.xpath(".//*[@id='analyst-search']/div/div[2]/button")).click();
				Thread.sleep(2000);
				
				//Search results are returned  
				System.out.println(  "Search results are returned");
				try {
					assertEquals("Search Results", driver.findElement(By.xpath(".//*[@id='business_search']/div[4]/h3")).getText());
					System.out.println("  Search Results are displayed - Pass");
				} catch (Error e) {
					verificationErrors.append(e.toString());
					System.out.println("  Search Results are displayed - <<FAILED>>");
					driver.quit();
				}
				Thread.sleep(2000);
				
		//Step 4 - View Profile
				System.out.println("Step 4 - View Profile");
				driver.findElement(By.xpath(".//*[@id='view_business_profile']")).click();
				
		//Step 5 - Verify the Associated Vendor Administrator header
				System.out.println("Step 5 - Verify the Associated Vendor Administrator header");
				try {
					assertEquals("ASSOCIATED VENDOR ADMINISTRATOR:  ", driver.findElement(By.xpath(".//*[@id='business_search']/div[2]/div[1]/p[2]/b")).getText());
					System.out.println("  Associated Vendor Administrator label is displayed - Pass");
				} catch (Error e) {
					verificationErrors.append(e.toString());
					System.out.println("  Associated Vendor Administrator label is displayed - <<FAILED>>");
					driver.quit();
				}
				Thread.sleep(2000);	
				
		//Step 6 - Click on the Associated Vendor Administrator name if linked
				System.out.println("Step 6 - Click on the Associated Vendor Administrator name if linked");
				try {
					assertEquals("QA User", driver.findElement(By.xpath(".//*[@id='ava-pop']")).getText());
					driver.findElement(By.xpath(".//*[@id='ava-pop']")).click();
					System.out.println("  Associated Vendor Administrator name is displayed - Pass");
				} catch (Error e) {
					verificationErrors.append(e.toString());
					System.out.println("  Associated Vendor Administrator name is displayed - <<FAILED>>");
					driver.quit();
				}
				Thread.sleep(2000);		
				
		//Step 7 - Verify Vendor Admin Profile pop up window
				System.out.println("Step 7 - Verify Vendor Administrator Profile pop up window");
				try {
					assertEquals("Vendor Administrator Profile", driver.findElement(By.xpath(".//*[@id='alert-header']/div")).getText());
					System.out.println("  Vendor Administrator Profile title is displayed - Pass");
				} catch (Error e) {
					verificationErrors.append(e.toString());
					System.out.println("  Vendor Administrator Profile title is displayed - <<FAILED>>");
					//driver.quit();
				}
				
		//Step 8 - Verify Last Name label   
				System.out.println("Step 8 - Verify Last Name lable");
				try {
					assertEquals("Last Name:", driver.findElement(By.xpath(".//*[@id='msg_container']/b[1]")).getText());
					System.out.println("  Last Name label is displayed - Pass");
				} catch (Error e) {
					verificationErrors.append(e.toString());
					System.out.println("  Last Name label is displayed - <<FAILED>>");
					driver.quit();
				}
				Thread.sleep(2000);		

		//Step 9 - Verify First Name label   
				System.out.println("Step 9 - Verify First Name lable");
				try {
					assertEquals("First Name:", driver.findElement(By.xpath(".//*[@id='msg_container']/b[2]")).getText());
					System.out.println("  First Name label is displayed - Pass");
				} catch (Error e) {
					verificationErrors.append(e.toString());
					System.out.println("  First Name label is displayed - <<FAILED>>");
					driver.quit();
				}
				
		//Step 10 - Verify Email Address label   
				System.out.println("Step 10 - Verify Email Address lable");
				try {
					assertEquals("Email:", driver.findElement(By.xpath(".//*[@id='msg_container']/b[3]")).getText());
					System.out.println("  Email Address label is displayed - Pass");
				} catch (Error e) {
					verificationErrors.append(e.toString());
					System.out.println("  Email Address label is displayed - <<FAILED>>");
					driver.quit();
				}
				Thread.sleep(2000);		
				
				
		//Step 11 - Verify Role label   
				System.out.println("Step 11 - Verify Role lable");
				try {
					assertEquals("Role:", driver.findElement(By.xpath(".//*[@id='msg_container']/b[4]")).getText());
					System.out.println("  Role label is displayed - Pass");
				} catch (Error e) {
					verificationErrors.append(e.toString());
					System.out.println("  Role label is displayed - <<FAILED>>");
					driver.quit();
				}
				
		//Step 12 - Verify Telephone Number label   
				System.out.println("Step 12 - Verify Telephone Number lable");
				try {
					assertEquals("Phone No:", driver.findElement(By.xpath(".//*[@id='msg_container']/b[5]")).getText());
					System.out.println("  Telephone Number label is displayed - Pass");
				} catch (Error e) {
					verificationErrors.append(e.toString());
					System.out.println("  Telephone Number label is displayed - <<FAILED>>");
					driver.quit();
				}
				Thread.sleep(2000);	
				
		//Step 13 - Print out the Vendor Admin data   
				System.out.println("Step 13 - Print out the Vendor Admin data");
				System.out.println(driver.findElement(By.id("msg_container")).getText());
		
		//Step 14 - Click on the Close button
				System.out.println("Step 14 - Click on the Close button");
				driver.findElement(By.xpath(".//*[@id='labelid']")).click();
			
		//Step 15 - Click the Logout link
				System.out.println("Step 15 - Logout link clicked");
				driver.findElement(By.xpath(".//*[@id='js-navigation-menu']/li[3]/a")).click();
				
				Thread.sleep(3000);
				System.out.println("END OF TEST");
			}
		    
			@After
			  public void tearDown() throws Exception {
			    driver.quit();
			    String verificationErrorString = verificationErrors.toString();
			    if (verificationErrorString != null){
			    	 System.out.println("Error: " + verificationErrorString);
			    }
			    
			  }

}
