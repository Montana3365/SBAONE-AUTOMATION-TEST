package regression_for_2_1_4_release;

import org.junit.Before;
import org.junit.Test;

import java.io.File;

import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;

public class Am_I_Eligible_Scenario6_Regression {

			public WebDriver mydriver;
			String myurl;
			String Invalid_NAICS_Code;
			String Valid_NAICS_Code;
			String Six_invalid_code;
			String Scenario_five_code;
			String Valid_NAICS_code_2;
				
		@Before
		public void Am_i_Eligible_setup()throws Exception{
myurl="http://certify.qa.sba-one.net/";
Invalid_NAICS_Code="3233";
Valid_NAICS_Code="237210";
Six_invalid_code="323300";
Scenario_five_code="12s$&A";
Valid_NAICS_code_2="315210";


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
//Scenario 6, User answer "Yes" to question one and two and entered a valid NAICS code but failed to answer question the last question.
	System.out.println("-Test script 1, Scenario 6: WOSB Program Eligibility - Low Fidelity Failure Due to failure to answer the last question");
	System.out.println("Users should not be able to navigate to the next page to check eligibility baut should see an alert to answer the omited question as a required fild ");
//Step 1. Open Firefox browser and the valid url.
	mydriver.navigate().to(myurl);
	mydriver.manage().window().maximize();
//Step 2. Verify page to check for page validation by required content.
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
//Step 3. Click on "Am I Eligible?" Button at the bottom of the homepage instruction.
	mydriver.findElement(By.xpath(".//*[@id='main-content']/form/input")).click();
//Step 4. Check for "Four Eligibility question" on the next page to make sure they are present.
//Step 5. Print out "First Question" if present.
	System.out.println("-Question one");
	System.out.println(mydriver.findElement(By.xpath(".//*[@id='am_i_eligible']/ul/li[1]/div[1]/fieldset")).getText());
//Step 6. Click on the "+Details" button for Information about who is consider to be  a Citizen.
	Thread.sleep(2000);
    //mydriver.findElement(By.xpath(".//*[@id='am_i_eligible']/ul/li[1]/div[2]/div/ul/li/button")).click();
	System.out.println(mydriver.findElement(By.xpath(".//*[@id='collapsible-1']")).getText());  
//Step 7. Print out Second Question if present.	
	System.out.println("-Question two");
	System.out.println(mydriver.findElement(By.xpath(".//*[@id='am_i_eligible']/ul/li[2]/div[1]/fieldset")).getText());
//Step 8. Click in the "+Details" to check if you meet the Requirements of Question two.
	Thread.sleep(2000);
	//mydriver.findElement(By.xpath(".//*[@id='am_i_eligible']/ul/li[2]/div[2]/div/ul/li/button")).click();
	Thread.sleep(4000);
	System.out.println(mydriver.findElement(By.xpath(".//*[@id='collapsible-2']/div")).getText());
//Step 9. Print out Third Question.
	System.out.println("-Question Three");
	System.out.println(mydriver.findElement(By.xpath(".//*[@id='am_i_eligible']/ul/li[3]/div[1]/fieldset")).getText());
//Step 10. Click on the "+Details" Button to find out if you qualify for question Three command.
	Thread.sleep(2000);
	//mydriver.findElement(By.xpath(".//*[@id='am_i_eligible']/ul/li[3]/div[2]/div/ul/li/button")).click();
	Thread.sleep(3000);
	System.out.println(mydriver.findElement(By.xpath(".//*[@id='collapsible-3']/div")).getText());
//Step 11. Print out the Fourth Question.
	System.out.println("-Question Four");
	System.out.println(mydriver.findElement(By.xpath(".//*[@id='am_i_eligible']/ul/li[4]/div[1]/fieldset")).getText());
//Step 12. Click on the "+Details" Button to find out if you qualify for question Four.
	Thread.sleep(2000);
	//mydriver.findElement(By.xpath(".//*[@id='am_i_eligible']/ul/li[4]/div[2]/div/ul/li/button")).click();
	Thread.sleep(3000);
	System.out.println(mydriver.findElement(By.xpath(".//*[@id='collapsible-4']/div")).getText());
	System.out.println("Test Pass at this point");
//Step 13. Select "Yes" for question one.
	mydriver.findElement(By.xpath(".//*[@id='answers[1][value]']/label[1]")).click();
//Step 14. Select "Yes" for question two.
	mydriver.findElement(By.xpath(".//*[@id='answers[2][value]']/label[1]")).click();
//Step 15. Enter a valid NAICS code for question three.
	mydriver.findElement(By.xpath(".//*[@id='answers_3_value']")).sendKeys("Valid_NAICS_code_2");
//Step 16. Skip question four and click on check eligibility.
	System.out.println("Question four was skip to validat scenario 6");
//Step 17. Click on "Check Eligibility".
	mydriver.findElement(By.xpath(".//*[@id='am_i_eligible']/input[4]")).click();
	Thread.sleep(4000);
//Step 18. Users should be able to see an alert beside the omitted question asking them to answer as a required field.
	if(mydriver.getPageSource().contains("Please answer this question")){
	 System.out.println("Alert for omitted question present 'Please Answer this question', users are unable to navigate to the next page Scenario 6 Pass");
	}
	else{
	 System.out.println("Alert for omitted question not present, users are able to navigate to the next page Scenario 6 Failed");
	}		
    }
@After
public void AM_I_Eligible_Endtest()throws Exception{
	mydriver.quit();
}


}
