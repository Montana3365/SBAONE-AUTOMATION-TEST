package regression_for_2_1_4_release;

import java.io.File;

import org.junit.Before;
	import org.junit.Test;
	import org.junit.After;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;

public class Am_I_Eligible_Scenario7_Regression {
			public WebDriver mydriver;
			String myurl;
			String Invalid_NAICS_Code;
			String Valid_NAICS_Code;
			String Six_invalid_code;
			String Scenario_five_code;
			String Scenario_serven_code;
				
		@Before
		public void Am_i_Eligible_setup()throws Exception{
	myurl="http://certify.qa.sba-one.net/";
	Invalid_NAICS_Code="3233";
	Valid_NAICS_Code="237210";
	Six_invalid_code="323300";
	Scenario_serven_code="237210";	
	

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
			
	//Test script 1, Scenario 7: User should not be eligible for the WOSB or EDWOSB program b/c user answer no for question two.
		System.out.println("-Test script 1, Scenario 7:User should not be eligible for the WOSB or EDWOSB program b/c user answer No for question two");
	//WOSB Program Eligibility - Positive Scenario(csenario1). User should be eligible for the WOSB program. 
	//Step 1. Open the Firefox and navigate to Url.
		mydriver.navigate().to(myurl);
		mydriver.manage().window().maximize();
	//Step 2. Verify the home page to make sure the required page opens.
	    Thread.sleep(3000);
		if(mydriver.getPageSource().contains("Am I Eligible?")){
		System.out.println("Text present, home page validated step 1 and 2 pass");
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
	//Step 5. Click on "Am I Eligible?" Button at the bottom of the home page instruction.
		mydriver.findElement(By.xpath(".//*[@id='main-content']/form/input")).click();
		Thread.sleep(4000);
	// Step 6. Check page to make sure Questionnaire page is present
		if(mydriver.getPageSource().contains("Am I Eligible?")){
			System.out.println("Questionnaire Page present");
		}
		else{
			System.out.println("Questionnaire page not present");
		}
		Thread.sleep(4000);
	//Step 7. Select Yes Question one.
		mydriver.findElement(By.xpath(".//*[@id='answers[1][value]']/label[1]")).click();
	//Step 8. Select No for question two.
		mydriver.findElement(By.xpath(".//*[@id='answers[2][value]']/label[2]")).click();
	//Step 9. Enter valid NAICS code in question three search box.
		mydriver.findElement(By.xpath(".//*[@id='answers_3_value']")).sendKeys(Scenario_serven_code);
	//Step 10. Select No for question four.
		mydriver.findElement(By.xpath(".//*[@id='answers[4][value]']/label[2]")).click();
	//Step 11. Click on "Check Eligibility" Button at the button of the four Questions.
		mydriver.findElement(By.xpath(".//*[@id='am_i_eligible']/input[4]")).click();
		Thread.sleep(4000);
	//step 12. Show result base on information enter in the QuestionnaireUser should not be eligible for the WOSB or EDWASB program b/c user answer no for question two with an INVALID CODE, see result).
		System.out.println(mydriver.findElement(By.xpath(".//*[@id='main-content']")).getText());
		}  
			
	@After
	public void AM_I_Eligible_Endtest()throws Exception{
		mydriver.quit();
	}
			


}
