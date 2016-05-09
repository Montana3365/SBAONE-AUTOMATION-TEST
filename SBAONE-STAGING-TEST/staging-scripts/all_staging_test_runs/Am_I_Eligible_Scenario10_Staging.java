package all_staging_test_runs;

	import java.io.File;

	import org.junit.Before;
	import org.junit.Test;
	import org.junit.After;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	//import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	//import org.openqa.selenium.ie.InternetExplorerDriver;

	public class Am_I_Eligible_Scenario10_Staging {

		public WebDriver mydriver;
		String myurl;
		
			
	@Before
	public void Am_i_Eligible_setup()throws Exception{
	myurl="https://www.staging-certify.sba.gov/";

	File file = new File("C:\\SBA-AUTOMATION-TEST\\SBAONE-REGRESSION-TEST\\libs\\IEDriverServer32b.exe");
	System.setProperty("webdriver.ie.driver", file.getAbsolutePath());	
	File file1 = new File("C:\\SBA-AUTOMATION-TEST\\SBAONE-REGRESSION-TEST\\libs\\chromedriver.exe");
	System.setProperty("webdriver.chrome.driver", file1.getAbsolutePath());
	//mydriver=new InternetExplorerDriver();
	//mydriver=new ChromeDriver();
	mydriver=new FirefoxDriver();




	}

	@Test
	public void AM_I_Eligible_maintest()throws Exception{
		
		//Test script 1, Scenario 10: Not Eligible for either WASB OR EDWAS program due to failure to answer any of the four questions
		System.out.println("-Test script 1, Scenario 10: User should NOT be eligible for either WOSB or EDWASB program (result page should not be shown after clicking on Check Eligibility");
		//WOSB Program Eligibility - Positive Scenario(csenario1). User should be eligible for the WOSB program. 
	//Step 1. Open the Firefox and navigate to Url.
		mydriver.navigate().to(myurl);
		mydriver.manage().window().maximize();
	//Step 2. Verify the home page to make sure the required page opens.
		Thread.sleep(3000);
		if(mydriver.getPageSource().contains("Am I Eligible?")){
			System.out.println("Text present, home page validated to contain the Am I Eligible link step 1 and 2 pass");
		}
		
		else{
			System.out.println("Text not present, homepage not validated");
		}
		
	//Step 3. locate the find out button and click on it to verify eligibility.
		mydriver.findElement(By.xpath(".//*[@id='hp']/div[4]/div/div[2]/div/form/input")).click();
		
	//Step 4. Verify page to check for page validation by required content.
		Thread.sleep(3000);
		if(mydriver.getPageSource().contains("SBA Women-Owned Small Business (WOSB) Federal Contract Program")){
			System.out.println("Introduction page of SBA Women-Owned Small Business Requirement page Validated ");
		}
		else{
			System.out.println("Introduction page of SBA Women-Owned Small Business Requirement not validated");
		}
	//Step 5. Click on "Am I Eligible?" Button at the bottom of the homepage instruction.
		mydriver.findElement(By.xpath(".//*[@id='main-content']/form/input")).click();
	//Step 6. Check for "Four Eligibility question" on the next page to make sure they are present.
	//Step 7. Print out "First Question" if present.
		System.out.println("-Question one");
		System.out.println(mydriver.findElement(By.xpath(".//*[@id='am_i_eligible']/ul/li[1]/div[1]/fieldset")).getText());
	//Step 8. Click on the "+Details" button for Information about who is consider to be  a Citizen.
		Thread.sleep(2000);
		//mydriver.findElement(By.xpath(".//*[@id='am_i_eligible']/ul/li[1]/div[2]/div/ul/li/button")).click();
		System.out.println(mydriver.findElement(By.xpath(".//*[@id='collapsible-1']")).getText());
	//Step 9. Print out Second Question if present.	
		System.out.println("-Question two");
		System.out.println(mydriver.findElement(By.xpath(".//*[@id='am_i_eligible']/ul/li[2]/div[1]/fieldset")).getText());
	//Step 10. Click in the "+Details" to check if you meet the Requirements of Question two.
	    Thread.sleep(2000);
		//mydriver.findElement(By.xpath(".//*[@id='am_i_eligible']/ul/li[2]/div[2]/div/ul/li/button")).click();
		Thread.sleep(4000);
		System.out.println(mydriver.findElement(By.xpath(".//*[@id='collapsible-2']/div")).getText());
	//Step 11. Print out Third Question.
		System.out.println("-Question Three");
		System.out.println(mydriver.findElement(By.xpath(".//*[@id='am_i_eligible']/ul/li[3]/div[1]/fieldset")).getText());
	//Step 12. Click on the "+Details" Button to find out if you qualify for question Three command.
		Thread.sleep(2000);
		//mydriver.findElement(By.xpath(".//*[@id='am_i_eligible']/ul/li[3]/div[2]/div/ul/li/button")).click();
		Thread.sleep(3000);
		System.out.println(mydriver.findElement(By.xpath(".//*[@id='collapsible-3']/div")).getText());
	//Step 13. Print out the Fourth Question.
		System.out.println("-Question Four");
		System.out.println(mydriver.findElement(By.xpath(".//*[@id='am_i_eligible']/ul/li[4]/div[1]/fieldset")).getText());
	//Step 14. Click on the "+Details" Button to find out if you qualify for question Four.
		Thread.sleep(2000);
		//mydriver.findElement(By.xpath(".//*[@id='am_i_eligible']/ul/li[4]/div[2]/div/ul/li/button")).click();
		Thread.sleep(3000);
		System.out.println(mydriver.findElement(By.xpath(".//*[@id='collapsible-4']/div")).getText());
		System.out.println("Test Pass at this point");
		Thread.sleep(4000);
	System.out.println("-User should NOT be eligible for either WOSB or EDWASB program (result page should not be shown after clicking on Check Eligibility");
	//Step 15.Verify that alert messages for user to answer all required questions is shown to user.
	   if(mydriver.getPageSource().contains("Please answer this question")){
		   System.out.println("-Alert message present, users are pront to answer the required qestions. PASS");
	   }
	   else{
		   System.out.println("-Alert message NOT present, users are NOT pront to answer the required qestions. FAILED ");

	   }
	}
	@After
	public void AM_I_Eligible_Endtest()throws Exception{
	 mydriver.quit();
	}


}
