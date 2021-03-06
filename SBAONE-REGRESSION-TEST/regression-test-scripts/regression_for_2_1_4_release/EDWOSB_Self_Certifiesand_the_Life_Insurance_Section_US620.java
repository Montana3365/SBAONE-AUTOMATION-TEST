package regression_for_2_1_4_release;

import static org.junit.Assert.*;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class EDWOSB_Self_Certifiesand_the_Life_Insurance_Section_US620 {
	private WebDriver driver;
	String URL;
	String Password;
	String Email;
	String comment;
	String Balance;
	String P_Resident;
	String Percentage;
//Data for personal information
	String First_Name;
	String Last_Name;
	String First_Name1;
	String Last_Name1;
	String SSN;
	String Address_P;
	String City;
	String State;
	String Zip;
	String Country;
	String Home_Phone;
	String Business_Phone;
	String Email_P;
	String Email_P1;
//Data for Cash On Hand
	String AS_of_DATE;
	String Cash_On_Hand;
	String Saving_Account;
	String Checking_Account;
//Data for Other Sources Of Income	
	String Salary;
	String Other_Income;
	String Business_Equity;
	String Equity_in_other_firm;
	

//Data for Life Insurance
	String Blance_OfAnyloans;
	String Insurance_Company;
	String Cash_Surrender_Value;
	String Face_Amount;
	String Beneficiaries;
	String Insurance_Company1;
	String Beneficiaries1;
	String Insurance_Company2;
	String Beneficiaries2;
	
private StringBuffer verificationErrors = new StringBuffer();
	
	@Before
	public void EDWOSB_Self_Certifiesand_the_Life_Insurance_SetUp(){
		driver =new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		File file1 = new File("C:\\SBA-AUTOMATION-TEST\\SBAONE-REGRESSION-TEST\\libs\\IEDriverServer32b.exe");
		System.setProperty("webdriver.ie.driver", file1.getAbsolutePath());
		//driver=new InternetExplorerDriver();
		File file2 = new File("C:\\SBA-AUTOMATION-TEST\\SBAONE-REGRESSION-TEST\\libs\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file2.getAbsolutePath());
		//driver=new ChromeDriver();
		
		URL="https://certify.qa.sba-one.net/users/sign_in";
		// URL="https://staging-certify.sba.gov/users/sign_in";



	    Email="testemail1@mailinator.com";
	    Password="Map Effect Applied Furniture Test";
	    comment="Test";
	    
	    
//Data for personal information
	    First_Name ="Sabra";
	    Last_Name ="Mabella";
 	    First_Name1 ="Jony";
	    Last_Name1 ="Mountin";
	    SSN="495-54-3209";
	    Address_P="3432 Berugard ST";
	    State="Virginia";
	    Country="USA";
	    City="Alexandria";
	    Zip="22311";
	    Home_Phone="703-622-5854";
	    Business_Phone="703-765-4969";
	    Email_P ="Sabra.Mabella@gmail.com";
	    Email_P1 ="jony.mountin@gmail.com";
	  
//Data for Cash On Hand  
	    AS_of_DATE="02/01/2016";
	    Cash_On_Hand="10000";
	    Saving_Account="50000";
	    Checking_Account="30000";
	  
//Data for Other Sources Of Income
	    Salary="60000";
	    Other_Income="3000";
	    Business_Equity="5700";
	    Equity_in_other_firm="20000";
	    
 
//Data for Life Insurance
	    Blance_OfAnyloans= "1500";		   
	    Insurance_Company = "GEICO";
	    Cash_Surrender_Value = "200";
	    Face_Amount= "500";
	    Beneficiaries ="Donald";
	    Insurance_Company1 ="Blue Cross Blue Shield";
	    Beneficiaries1 ="Micale";
	    Insurance_Company2 ="Kaiser";
	    Beneficiaries2 ="Jone";
	   	    
	
				}
	@Test
	public void EDWOSB_Self_Certifiesand_the_Life_Insurance_MainTest() throws Exception{
		driver.navigate().to(URL);
		Thread.sleep(3000);
		// Login to dashboard, Locate the email search box and enter a valid email.
		driver.findElement(By.xpath(".//*[@id='user_email']")).sendKeys(Email);
	      // Locate the password search box and enter a valid password.
		driver.findElement(By.xpath(".//*[@id='user_password']")).sendKeys(Password);
		 //Click the Sign-in button
		driver.findElement(By.xpath(".//*[@id='business_signin']")).click();
		
		//Verify that the login was successful and the Dashboard is displayed
				Thread.sleep(3000);
				try {
					assertEquals("BUSINESS PROFILE", driver.findElement(By.xpath(".//*[@id='dashboard-index']/div[1]")).getText());
				} catch (Error e) {
		      verificationErrors.append(e.toString());
				}
				System.out.println("BUSINESS PROFILE Pass");
				
	//Verify if there is an existing certification on the dashboard and delete to start a new certification.
				if(driver.getPageSource().contains("Draft")){
					driver.findElement(By.xpath(".//*[@id='dashboard-index']/div[4]/div[2]/table/tbody/tr/td[4]/a[2]")).click();
					driver.switchTo().alert().accept();
					Thread.sleep(4000);

					
			        
				}
				else{
					System.out.println("There are(is) no certification in-progress on the dashboard, a new certification is beinng created");
					Thread.sleep(7000);
				}

		// Locate the Certifications on the dashboard, click on it and select EDWOSB to continue.
				driver.findElement(By.xpath(".//*[@id='js-navigation-menu']/li[2]/a")).click();
				driver.findElement(By.xpath(".//*[@id='js-navigation-menu']/li[2]/ul/li[2]/a")).click();
				Thread.sleep(3000);
		//Locate the accept button at the bottom of the EDWOSB agreement and click on it to continue.
				driver.findElement(By.xpath(".//*[@id='new_sba_application']/input[3]")).click();
		//Locate the 8(a) question and select No and continue.
				driver.findElement(By.xpath(".//*[@id='answers[65][value]']/label[2]")).click();
				driver.findElement(By.xpath(".//*[@id='edwosb']/input[4]")).click();
				//Locate the Third Party Certification question and select No and continue.
				driver.findElement(By.xpath(".//*[@id='answers[66][value]']/label[2]")).click();
				driver.findElement(By.xpath(".//*[@id='edwosb']/input[4]")).click();
				//Locate the Non-qualification question and select No and continue.
				driver.findElement(By.xpath(".//*[@id='answers[68][value]']/label[2]")).click();
				driver.findElement(By.xpath(".//*[@id='edwosb']/input[4]")).click();
				//Locate the LLC two  question and select NO, Write comment  and continue.
				driver.findElement(By.xpath(".//*[@id='answers[78][value]']/label[2]")).click();
				driver.findElement(By.xpath(".//*[@id='answers_78_comment']")).sendKeys(comment);
				driver.findElement(By.xpath(".//*[@id='answers[79][value]']/label[2]")).click();
				driver.findElement(By.xpath(".//*[@id='answers_79_comment']")).sendKeys(comment);
				driver.findElement(By.xpath(".//*[@id='edwosb']/input[4]")).click();

				System.out.println("The LLC questions have been answered");
				Thread.sleep(3000);
				
				//Locate the Citizenship & Ownership Two question and select No and continue.
				driver.findElement(By.xpath(".//*[@id='answers[80][value]']/label[2]")).click();
				driver.findElement(By.xpath(".//*[@id='answers[81][value]']/label[2]")).click();
				driver.findElement(By.xpath(".//*[@id='edwosb']/input[4]")).click();
				System.out.println("The Citizenship & Ownership questions have been answered");
				//Locate the Businesses & Trusts Two question and select No and continue.
				driver.findElement(By.xpath(".//*[@id='answers[82][value]']/label[2]")).click();
				driver.findElement(By.xpath(".//*[@id='answers[83][value]']/label[2]")).click();
				driver.findElement(By.xpath(".//*[@id='edwosb']/input[4]")).click();
				System.out.println("The Businesses & Trusts questions have been answered");
				Thread.sleep(3000);
				//Locate the Operations & Management Two question and select No and continue.
				driver.findElement(By.xpath(".//*[@id='answers[84][value]']/label[2]")).click();
				driver.findElement(By.xpath(".//*[@id='answers[85][value]']/label[2]")).click();
				driver.findElement(By.xpath(".//*[@id='edwosb']/input[4]")).click();
				System.out.println("The Operations & Management questions have been answered");	
				//Locate the Expertise & Employment Two question and select No and continue.
				driver.findElement(By.xpath(".//*[@id='answers[86][value]']/label[2]")).click();
				driver.findElement(By.xpath(".//*[@id='answers[87][value]']/label[2]")).click();
				driver.findElement(By.xpath(".//*[@id='edwosb']/input[4]")).click();
				System.out.println("The Expertise & Employment questions have been answered");
				//Locate the Highest Officer & Control Two question and select No and continue.
				driver.findElement(By.xpath(".//*[@id='answers[88][value]']/label[2]")).click();
				driver.findElement(By.xpath(".//*[@id='answers[89][value]']/label[2]")).click();
				driver.findElement(By.xpath(".//*[@id='edwosb']/input[4]")).click();
				System.out.println("The Highest Officer & Control  questions have been answered");
				//Locate the SBA Exam & Daily Operations Two question and select No and continue.
				driver.findElement(By.xpath(".//*[@id='answers[90][value]']/label[2]")).click();
				driver.findElement(By.xpath(".//*[@id='answers[91][value]']/label[2]")).click();
				driver.findElement(By.xpath(".//*[@id='answers_91_comment']")).sendKeys(comment);
				driver.findElement(By.xpath(".//*[@id='edwosb']/input[4]")).click();
				System.out.println("The SBA Exam & Daily Operations questions have been answered");
				//Locate the Net Worth Two question and select No and continue.
				driver.findElement(By.xpath(".//*[@id='answers[92][value]']/label[2]")).click();
				driver.findElement(By.xpath(".//*[@id='answers[93][value]']/label[2]")).click();
				driver.findElement(By.xpath(".//*[@id='edwosb']/input[4]")).click();
				System.out.println("The Net Worth questions have been answered");
				
				//Locate the Adjusted Gross Income Two question and select No and continue.
				driver.findElement(By.xpath(".//*[@id='answers[94][value]']/label[2]")).click();
				driver.findElement(By.xpath(".//*[@id='answers[95][value]']/label[2]")).click();
				driver.findElement(By.xpath(".//*[@id='edwosb']/input[4]")).click();
				System.out.println("The Adjusted Gross Income questions have been answered");
				
				//Locate the Fair Market Value  question and select No and continue.
				driver.findElement(By.xpath(".//*[@id='answers[96][value]']/label[2]")).click();
				driver.findElement(By.xpath(".//*[@id='edwosb']/input[4]")).click();
				System.out.println("The Fair Market Value questions have been answered");
				//Locate the Assets Two question and select No and continue.
				driver.findElement(By.xpath(".//*[@id='answers[97][value]']/label[2]")).click();
				driver.findElement(By.xpath(".//*[@id='answers[98][value]']/label[2]")).click();
				driver.findElement(By.xpath(".//*[@id='edwosb']/input[4]")).click();
				System.out.println("The Assets questions have been answered");
				//Verify section for 'Financial Data' enter all valid data as required.	
				if(driver.getPageSource().contains("Financial Data")){
					System.out.println("User is navigated to the Correct section, (Financial Data) - Pass");
					}
				else{
					System.out.println("User is NOT being navigated to the Correct section, (Financial Data) - Failed");
				}
				Thread.sleep(3000);
		//Click on 'Add New Person' button at the bottom of the personal information.
				driver.findElement(By.xpath(".//*[@id='answers_99_value_new_button']")).click();
				System.out.println("The personal information for 1st Person");
				System.out.println("The personal information Before Save:");
				//Verify that the section to Create new record is been seen by user and enter new record to ADD.
				if(driver.getPageSource().contains("Create new record")){
					System.out.println("The page to Create and Add new Record is Present, PASS");
					driver.findElement(By.xpath(".//*[@id='DTE_Field_first_name']")).sendKeys(First_Name);
					System.out.println(" First_Name = Sabra");
					driver.findElement(By.xpath(".//*[@id='DTE_Field_last_name']")).sendKeys(Last_Name);
					System.out.println(" Last_Name = Mabella ");
					driver.findElement(By.xpath(".//*[@id='DTE_Field_ssn']")).sendKeys(SSN);
					System.out.println("SSN= 495-54-3209");
					driver.findElement(By.xpath(".//*[@id='DTE_Field_address']")).sendKeys(Address_P);
					System.out.println("Address_P= 3432 Berugard ST");
					driver.findElement(By.xpath(".//*[@id='DTE_Field_city']")).sendKeys(City);
					System.out.println("State= Virginia");
					driver.findElement(By.xpath(".//*[@id='DTE_Field_state']")).sendKeys(State);
					System.out.println("Country= USA");
					driver.findElement(By.xpath(".//*[@id='DTE_Field_postal_code']")).sendKeys(Zip);
					System.out.println("City= Alexandria");
					driver.findElement(By.xpath(".//*[@id='DTE_Field_country']")).sendKeys(Country);
					System.out.println(" Zip= 22311");
					driver.findElement(By.xpath(".//*[@id='DTE_Field_home_phone']")).sendKeys(Home_Phone);
					System.out.println(" Home_Phone= 703-622-5854");
					driver.findElement(By.xpath(".//*[@id='DTE_Field_business_phone']")).sendKeys(Business_Phone);
					System.out.println("Business_Phone= 703-765-4969");
					driver.findElement(By.xpath(".//*[@id='DTE_Field_email']")).sendKeys(Email_P);
					System.out.println(" Email_P = Sabra.Mabella@gmail.com");
					driver.findElement(By.xpath("html/body/div[3]/div/div/div/div[1]/div[4]/div[3]/button")).click();
					Thread.sleep(3000);
									
					//Is anyone listed above divorced? If yes, please provide separation documents select "No"
					driver.findElement(By.xpath(".//*[@id='answers[100][value]']/label[2]")).click();
					Thread.sleep(3000);
					driver.findElement(By.xpath(".//*[@id='edwosb']/input[4]")).click();

					
					
				}
					else{
						System.out.println("the page to Create and Add new Record is NoT Present, Failed");

						
					}   
				//Locate section for 'Cash On Hand' enter all valid data as required.		
				try { 
					assertEquals("Cash On Hand", driver.findElement(By.xpath(".//*[@id='main-content']/div/h2")).getText()); 
					System.out.println("User is navigated to the Correct section, (Cash On Hand) - Pass"); 
				 	} catch (Error e) { 
					verificationErrors.append(e.toString()); 
					System.out.println("User is NOT being navigated to the Correct section, (Cash On Hand) - Failed"); 
					Thread.sleep(3000);
			         driver.quit();
					}
				System.out.println("Cash On Hand Data Before Save:");
						//Locate the As of Date: Search box for user and enter the information as required.
						driver.findElement(By.xpath(".//*[@id='answers_32_value']")).sendKeys(AS_of_DATE);
						 System.out.println("AS_of_DATE= 02/01/2016");
						//Locate the Cash on Hand Search box for Sarbra  Mabella and enter the information as required.
						driver.findElement(By.xpath(".//*[@id='answers_33_value']")).sendKeys(Cash_On_Hand);
						System.out.println("Cash_On_Hand= 10000");
						//Locate the Savings Account(s) Balance Search box for Sarbra  Mabella  and enter the information as required.
						driver.findElement(By.xpath(".//*[@id='answers_34_value']")).sendKeys(Saving_Account);
						System.out.println("Saving_Account= 50000");
						//Locate the Checking Account(s) Balance Search box for Sarbra  Mabella  and enter the information as required.
						driver.findElement(By.xpath(".//*[@id='answers_35_value']")).sendKeys(Checking_Account);
						System.out.println("Checking_Account= 30000");
						//Locate the Continue button and click on it to continue.
						driver.findElement(By.xpath(".//*[@id='edwosb']/input[4]")).click();
					
						Thread.sleep(2000);
						//Locate section for Other Sources Of Income
						
						if(driver.getPageSource().contains("Other Sources Of Income")){
							System.out.println("User is navigated to the Correct section, (Other Sources Of Income) - Pass");
							}
						else{
							System.out.println("User is NOT being navigated to the Correct section, (Other Sources Of Income) - Failed");
						}
						Thread.sleep(3000);
						System.out.println("Other Sources Of Income for Data:");			
					//Locate the Salary search box and enter salary.
					driver.findElement(By.xpath(".//*[@id='answers_36_value']")).sendKeys(Salary);
					System.out.println(" Salary= 60000");
					//Locate the Other Income search box and enter Other Income.
					driver.findElement(By.xpath(".//*[@id='answers_37_value']")).sendKeys(Other_Income);
					 System.out.println(" Other_Income= 3000");
					//Locate the applicant Business Type and enter amount of applicant equity.
					driver.findElement(By.xpath(".//*[@id='answers_38_value']")).sendKeys(Business_Equity);
					 System.out.println("Business_Equity= 5700");
					//Locate the applicant equity in other firm and enter applicant business equity.
					driver.findElement(By.xpath(".//*[@id='answers_39_value']")).sendKeys(Equity_in_other_firm);
					 System.out.println("Equity_in_other_firm= 20000");
					//Locate the continue button and click on it to continue.
					driver.findElement(By.xpath(".//*[@id='edwosb']/input[4]")).click();
					Thread.sleep(2000);

	//Verify Notes Receivable page.
					System.out.println("Test Start here Notes Receivable Section");
			if(driver.getPageSource().contains("Notes Receivable")){
				System.out.println("The Notes Receivable page coming, pass");
				}
			else{
				System.out.println("Notes Receivable , not found faild");
			}
			Thread.sleep(3000);
	//Do you have any notes receivable from others?	
			driver.findElement(By.xpath(".//*[@id='answers[40][value]']/label[2]")).click();
			//Locate the continue button and click on it to continue.
			driver.findElement(By.xpath(".//*[@id='edwosb']/input[4]")).click();
			Thread.sleep(2000);
	//Verify Retirement Accounts page.			
			System.out.println("\nVerify Retirement Accounts page");
			try { 
				assertEquals("Retirement Accounts", driver.findElement(By.xpath(".//*[@id='main-content']/div/h2")).getText()); 
				System.out.println("User is navigated to the Correct section, (Retirement Accounts) - Pass"); 
			 	} catch (Error e) { 
				verificationErrors.append(e.toString()); 
				System.out.println("User is NOT being navigated to the Correct section, (Retirement Accounts) - FAILED"); 
				} 
			
			//Do you have a Roth IRA? Select 'No'
			System.out.println("Do you have a Roth IRA? Select 'No'");
			driver.findElement(By.xpath(".//*[@id='answers[41][value]']/label[2]")).click();
			//Do you have any other retirement accounts? Select 'No'
			System.out.println("Do you have any other retirement accounts? Select 'No'");
			driver.findElement(By.xpath(".//*[@id='answers[42][value]']/label[2]")).click();
			//Locate the continue button and click on it to continue.
			driver.findElement(By.xpath(".//*[@id='edwosb']/input[4]")).click();
			Thread.sleep(2000);

	//Verify The page Life Insurance
	System.out.println("\n\t\tLaunch Here US620 Life Insurance page");
				try { 
					assertEquals("Life Insurance", driver.findElement(By.xpath(".//*[@id='main-content']/div/h2")).getText()); 
					System.out.println("User is navigated to the Correct section, (Life Insurance) - Pass"); 
				 	} catch (Error e) { 
					verificationErrors.append(e.toString()); 
					System.out.println("User is NOT being navigated to the Correct section, (Life Insurance) - FAILED"); 
					} 

				
				//Do you have a life insurance policy that has a Cash Surrender Value? Click "Yes"
				driver.findElement(By.xpath(".//*[@id='answers[43][value]']/label[1]")).click();
				//Click the ""New"
				driver.findElement(By.xpath(".//*[@id='answers_43_details_table_wrapper']/div/a[1]")).click();
				
				//Verify if there is Create new entry page.
					if(driver.getPageSource().contains("Create new entry")){
						System.out.println("The Create new entry coming, pass");
						}
					else{
						System.out.println("Create new entry , not found faild");
					}
					Thread.sleep(3000);
					
					System.out.println("The life insurance policy Data Save:");
					// Enter the Name of Life Insurance Company
					System.out.println("\t\nAdd 1st  Insurance Company Information");
					driver.findElement(By.xpath(".//*[@id='DTE_Field_company_name']")).sendKeys(Insurance_Company);
					//Enter Cash Surrender Value (if applicable)
					System.out.println("Cash_Surrender_Value = 200");
					driver.findElement(By.xpath(".//*[@id='DTE_Field_cash_surrender_value']")).sendKeys(Cash_Surrender_Value);
					//Enter the Face Amount
					driver.findElement(By.xpath(".//*[@id='DTE_Field_face_amount']")).sendKeys(Face_Amount);
					//Enter the Beneficiaries
					driver.findElement(By.xpath(".//*[@id='DTE_Field_beneficiaries']")).sendKeys(Beneficiaries);
					//Click the Create
					driver.findElement(By.xpath("html/body/div[3]/div/div/div/div[1]/div[4]/div[3]/button")).click();
					Thread.sleep(3000);
					
					//Add 2nd  Life Insurance Company Information 
					//Click the ""New"
					System.out.println("\t\nAdd 2nd  Insurance Company Information");
					driver.findElement(By.xpath(".//*[@id='answers_43_details_table_wrapper']/div/a[1]")).click();
					// Enter the Name of Insurance Company
					driver.findElement(By.xpath(".//*[@id='DTE_Field_company_name']")).sendKeys(Insurance_Company1);
					//Enter Cash Surrender Value (if applicable)
					System.out.println("Cash_Surrender_Value = 200");
					driver.findElement(By.xpath(".//*[@id='DTE_Field_cash_surrender_value']")).sendKeys(Cash_Surrender_Value);
					//Enter the Face Amount
					driver.findElement(By.xpath(".//*[@id='DTE_Field_face_amount']")).sendKeys(Face_Amount);
					//Enter the Beneficiaries
					driver.findElement(By.xpath(".//*[@id='DTE_Field_beneficiaries']")).sendKeys(Beneficiaries1);
					//Click the Create
					driver.findElement(By.xpath("html/body/div[3]/div/div/div/div[1]/div[4]/div[3]/button")).click();
					Thread.sleep(3000);
					
					//Add 3rd  Insurance Company Information 
					//Click the ""New"
					System.out.println("\t\nAdd 3rd  Insurance Company Information");
					driver.findElement(By.xpath(".//*[@id='answers_43_details_table_wrapper']/div/a[1]")).click();
					// Enter the Name of Insurance Company
					driver.findElement(By.xpath(".//*[@id='DTE_Field_company_name']")).sendKeys(Insurance_Company2);
					//Enter Cash Surrender Value (if applicable)
					System.out.println("Cash_Surrender_Value = 200");
					driver.findElement(By.xpath(".//*[@id='DTE_Field_cash_surrender_value']")).sendKeys(Cash_Surrender_Value);
					//Enter the Face Amount
					driver.findElement(By.xpath(".//*[@id='DTE_Field_face_amount']")).sendKeys(Face_Amount);
					//Enter the Beneficiaries
					driver.findElement(By.xpath(".//*[@id='DTE_Field_beneficiaries']")).sendKeys(Beneficiaries2);
					//Click the Create
					driver.findElement(By.xpath("html/body/div[3]/div/div/div/div[1]/div[4]/div[3]/button")).click();
					Thread.sleep(3000);
					
					
				//Do you have any loans against a life insurance policy?
				System.out.println("Do you have any loans against a life insurance policy? Yes");	
				driver.findElement(By.xpath(".//*[@id='answers[44][value]']/label[1]")).click();
				//What is the current balance of any loans against life insurance?
				driver.findElement(By.xpath(".//*[@id='answers_45_value']")).clear();
				driver.findElement(By.xpath(".//*[@id='answers_45_value']")).sendKeys( Blance_OfAnyloans);
				System.out.println("Loans_Against_Life_Insurance= 1500");
				//Locate the continue button and click on it to continue.
				driver.findElement(By.xpath(".//*[@id='edwosb']/input[4]")).click();
				Thread.sleep(2000);
				
		//Step 3. Verify that users is navigated to the right page for EDWOSB 2413 and 414 Application >> Form413 >> Test1 , Verify question and select YES OR NO to the question as apply to user and continue.	
		 if(driver.getPageSource().contains("Prior Certification")){
			System.out.println("User is being navigatd to the financial information(413), Stocks & Bonds page, PASS");
			//locate and click on the dashboard button.
			driver.findElement(By.xpath(".//*[@id='js-navigation-menu']/li[1]/a")).click();
			Thread.sleep(3000);
			//Verify and validate the in-progress certification and the dashboard 
			if(driver.getPageSource().contains("Continue")){
			//Click on continue.						
			 driver.findElement(By.xpath(".//*[@id='dashboard-index']/div[4]/div[2]/table/tbody/tr/td[4]/a[1]")).click();
			 Thread.sleep(2000);
			//Click on 'Life Insurance '.
			 driver.findElement(By.xpath(".//*[@id='life_insurance_sabra_mabella']")).click();

			 
			
		//Verify The Name of Insurance Company is being saved
			 System.out.println("\nVerify The 1st  Insurance Company Information is being saved");
		 if(driver.getPageSource().contains("Blue Cross Blue Shield")){
			System.out.println("The Name of Insurance Companyis being saved, Pass"); 
		 }
		 else{
				System.out.println("The Name of Insurance Company is not being saved, Faild"); 
		 }			 
		 Thread.sleep(3000);
		//Verify Cash Surrender Value is being saved
		 if(driver.getPageSource().contains("200")){
			System.out.println("The Cash Surrender Value is being saved, Pass"); 
		 }
		 else{
				System.out.println("The Cash Surrender Value is not being saved, Faild"); 
		 }			 
		 Thread.sleep(3000);
		//Verify The Face Amount is being saved
		 if(driver.getPageSource().contains("500")){
			System.out.println("The Face Amount is being saved, Pass"); 
		 }
		 else{
				System.out.println("The Face Amount is not being saved, Faild"); 
		 }			 
		 Thread.sleep(3000);
		//Verify the Beneficiaries is being saved
		 
		 if(driver.getPageSource().contains("Micale")){
			System.out.println("The Beneficiaries is being saved, Pass"); 
		 }
		 else{
				System.out.println("The Beneficiaries is not being saved, Faild"); 
		 }			 
		 Thread.sleep(3000);
		 System.out.println("\nVerify The 2nd  Insurance Company Information is being saved");
		 if(driver.getPageSource().contains("GEICO")){
				System.out.println("The Name of Insurance Companyis being saved, Pass"); 
			 }
			 else{
					System.out.println("The Name of Insurance Company is not being saved, Faild"); 
			 }			 
			 Thread.sleep(3000);
			//Verify Cash Surrender Value is being saved
			 if(driver.getPageSource().contains("200")){
				System.out.println("The Cash Surrender Value is being saved, Pass"); 
			 }
			 else{
					System.out.println("The Cash Surrender Value is not being saved, Faild"); 
			 }			 
			 Thread.sleep(3000);
			//Verify The Face Amount is being saved
			 if(driver.getPageSource().contains("500")){
				System.out.println("The Face Amount is being saved, Pass"); 
			 }
			 else{
					System.out.println("The Face Amount is not being saved, Faild"); 
			 }			 
			 Thread.sleep(3000);
			//Verify the Beneficiaries is being saved
			 if(driver.getPageSource().contains("Donald")){
				System.out.println("The Beneficiaries is being saved, Pass"); 
			 }
			 else{
					System.out.println("The Beneficiaries is not being saved, Faild"); 
			 }			 
			 Thread.sleep(3000);
			 System.out.println("\nVerify The 3rd  Insurance Company Information is being saved");
			 if(driver.getPageSource().contains("Kaiser")){
					System.out.println("The Name of Insurance Companyis being saved, Pass"); 
				 }
				 else{
						System.out.println("The Name of Insurance Company is not being saved, Faild"); 
				 }			 
				 Thread.sleep(3000);
				//Verify Cash Surrender Value is being saved
				 if(driver.getPageSource().contains("200")){
					System.out.println("The Cash Surrender Value is being saved, Pass"); 
				 }
				 else{
						System.out.println("The Cash Surrender Value is not being saved, Faild"); 
				 }			 
				 Thread.sleep(3000);
				//Verify The Face Amount is being saved
				 if(driver.getPageSource().contains("500")){
					System.out.println("The Face Amount is being saved, Pass"); 
				 }
				 else{
						System.out.println("The Face Amount is not being saved, Faild"); 
				 }			 
				 Thread.sleep(3000);
				//Verify the Beneficiaries is being saved
				 if(driver.getPageSource().contains("Jone")){
					System.out.println("The Beneficiaries is being saved, Pass"); 
				 }
				 else{
						System.out.println("The Beneficiaries is not being saved, Faild"); 
				 }			 
				 Thread.sleep(3000);
		 
		 
		
		//Verify What is the current balance of any loans against life insurance? is being saved
		 if(driver.getPageSource().contains("1500")){
			System.out.println("What is the current balance of any loans against life insurance? 1500 is being saved, Pass"); 
			System.out.println(driver.findElement(By.xpath(".//*[@id='edwosb']")).getText());
		 }
		 else{
				System.out.println("The current balance of any loans against life insurance is Notbeing save, Failed"); 
		 }

			}
			
		 }
		 else{
				System.out.println("Certification is not being save, Failed");
				driver.quit();
			}
	}
	@After
	public void EDWOSB_Self_Certifiesand_the_Life_Insurance_EndTest(){
		driver.quit();
		String verificationErrorString = verificationErrors.toString(); 
	    if (verificationErrorString != null){ 
	    	 System.out.println("Error: " + verificationErrorString); 
	    }

	}


}
