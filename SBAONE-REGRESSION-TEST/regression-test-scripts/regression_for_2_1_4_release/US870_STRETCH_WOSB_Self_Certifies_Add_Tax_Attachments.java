package regression_for_2_1_4_release;

import java.io.File;

import org.junit.After;
import org.junit.Before;
	import org.junit.Test;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;

public class US870_STRETCH_WOSB_Self_Certifies_Add_Tax_Attachments {
		public WebDriver mydriver;
		String myurl;
		String email;
		String PassW;
		String comment;
		
	@Before
	public void US870_STRETCH_WOSB_Self_Certifies_Add_Tax_Attachments_Setup()throws Exception{
		myurl="https://certify.qa.sba-one.net/users/sign_in";
		email="akanamontana@gmail.com";
		PassW="Map Effect Applied Furniture 3365";
		comment="Test";
		
		    File file = new File("C:\\Users\\Derec Nguni\\Documents\\QA_Automation\\QA_Acceptance\\lib\\IEDriverServer32b.exe");
			System.setProperty("webdriver.ie.driver", file.getAbsolutePath());	
			File file1 = new File("C:\\Users\\Derec Nguni\\Documents\\QA_Automation\\QA_Acceptance\\lib\\chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", file1.getAbsolutePath());
			//mydriver=new InternetExplorerDriver();
			//mydriver=new ChromeDriver();
			mydriver=new FirefoxDriver();
		
		
		
	}
	@Test             //  issue with html code but not an error.
	public void US870_STRETCH_WOSB_Self_Certifies_Add_Tax_Attachments_Maintest()throws Exception{
	//Step 1. Open Firefox browser and navigate to url.
		mydriver.navigate().to(myurl);
		mydriver.manage().window().maximize();
		   Thread.sleep(2000);
		    if(mydriver.getPageSource().contains("SIGN IN TO CERTIFY.SBA.GOV")){
		    	System.out.println("Text Present, Login page validated. Test Pass");
		    	}		
		    	else{
		    	System.out.println("Text Not Present, Login page Not validated. Test Failed");
		    	}	
		//Step 4. Enter a valid email.
		    mydriver.findElement(By.xpath(".//*[@id='user_email']")).sendKeys(email);
		//Step 5. Enter a valid password.
		    mydriver.findElement(By.xpath(".//*[@id='user_password']")).sendKeys(PassW);
		//Step 6. Click on the "Submit" Button.
		    mydriver.findElement(By.xpath(".//*[@id='business_signin']")).click();
		    Thread.sleep(3000);
			if(mydriver.getPageSource().contains("Signed in successfully")){
				mydriver.findElement(By.xpath(".//*[@id='labelid']")).click();
			}
			else{
				System.out.println("Successful sign in alert message not present");
			}
			Thread.sleep(3000);
			
			//Verify if there is an existing certification on the dashboard and delete to start a new certification.
			if(mydriver.getPageSource().contains("Draft")){
				mydriver.findElement(By.xpath(".//*[@id='dashboard-index']/div[4]/div[2]/table/tbody/tr[1]/td[4]/a")).click();
				mydriver.switchTo().alert().accept();
				Thread.sleep(4000);
				try{
			    	Thread.sleep(5000);
			    }catch(InterruptedException e){
			e.printStackTrace();}
			    mydriver.navigate().refresh();
				
			    
			}
			else{
				System.out.println("There are(is) no certification in-progress on the dashboard, a new certification is beinng created");
			}
				Thread.sleep(7000);

			// Locate the Certifications on the dashboard, click on it and select EDWOSB to continue.
				mydriver.findElement(By.xpath(".//*[@id='js-navigation-menu']/li[2]/a")).click();
				mydriver.findElement(By.xpath(".//*[@id='js-navigation-menu']/li[2]/ul/li[2]/a")).click();
				Thread.sleep(2000);
			//Locate the accept button at the bottom of the EDWOSB agreement and click on it to continue.
				mydriver.findElement(By.xpath(".//*[@id='new_sba_application']/input[3]")).click();

				//Locate the 8(a) question and select No and continue.
					mydriver.findElement(By.xpath(".//*[@id='answers[65][value]']/label[2]")).click();
					mydriver.findElement(By.xpath(".//*[@id='edwosb']/input[4]")).click();
					System.out.println("  8(a) question has been answered");
					//Locate the Third Party Certification, question1 and select No and continue.
					mydriver.findElement(By.xpath(".//*[@id='answers[66][value]']/label[2]")).click();
					mydriver.findElement(By.xpath(".//*[@id='edwosb']/input[4]")).click();
					//Locate the Non-qualification , question and select No and continue.
					mydriver.findElement(By.xpath(".//*[@id='answers[68][value]']/label[2]")).click();
					mydriver.findElement(By.xpath(".//*[@id='edwosb']/input[4]")).click();
					System.out.println("  Third Party questions have been answered");
					
					
					//Locate the Business Corporation and S-Corp(Stocks) question 1,2and2, and select N/A and continue.
					mydriver.findElement(By.xpath(".//*[@id='answers[69][value]']/label[2]")).click();
					mydriver.findElement(By.xpath(".//*[@id='answers_69_comment']")).sendKeys(comment);
					mydriver.findElement(By.xpath(".//*[@id='answers[70][value]']/label[2]")).click();
					mydriver.findElement(By.xpath(".//*[@id='answers[71][value]']/label[2]")).click();
					mydriver.findElement(By.xpath(".//*[@id='edwosb']/input[4]")).click();
					System.out.println("  Business questions have been answered");	
					//Locate the Corporation Ownership, question 1, and select No and continue.
					mydriver.findElement(By.xpath(".//*[@id='answers[73][value]']/label[2]")).click();
					mydriver.findElement(By.xpath(".//*[@id='edwosb']/input[4]")).click();
					//Locate the Ownership & Control, question and select No and continue.
					mydriver.findElement(By.xpath(".//*[@id='answers[75][value]']/label[2]")).click();
					mydriver.findElement(By.xpath(".//*[@id='answers_75_comment']")).sendKeys(comment);
					mydriver.findElement(By.xpath(".//*[@id='edwosb']/input[4]")).click();
					
					
					//Locate the Citizenship & Ownership, question 1and2, and select No and continue.
					mydriver.findElement(By.xpath(".//*[@id='answers[80][value]']/label[2]")).click();
					mydriver.findElement(By.xpath(".//*[@id='answers[81][value]']/label[2]")).click();
					mydriver.findElement(By.xpath(".//*[@id='edwosb']/input[4]")).click();	
					//Locate the Businesses & Trusts, questions and select No for both and continue.
					mydriver.findElement(By.xpath(".//*[@id='answers[82][value]']/label[2]")).click();
					mydriver.findElement(By.xpath(".//*[@id='answers[83][value]']/label[2]")).click();
					mydriver.findElement(By.xpath(".//*[@id='edwosb']/input[4]")).click();
					//Locate the Operations & Management, questions, and select No for both and continue.
					mydriver.findElement(By.xpath(".//*[@id='answers[84][value]']/label[2]")).click();
					mydriver.findElement(By.xpath(".//*[@id='answers[85][value]']/label[2]")).click();
					mydriver.findElement(By.xpath(".//*[@id='edwosb']/input[4]")).click();
					//Locate the Expertise & Employment, questions and select No for both and continue.
					mydriver.findElement(By.xpath(".//*[@id='answers[86][value]']/label[2]")).click();
					mydriver.findElement(By.xpath(".//*[@id='answers[87][value]']/label[2]")).click();
					mydriver.findElement(By.xpath(".//*[@id='edwosb']/input[4]")).click();
					System.out.println("  Operations questions have been answered");	
					//Locate the Highest Officer & Control questions, and select No for both and continue.
					mydriver.findElement(By.xpath(".//*[@id='answers[88][value]']/label[2]")).click();
					mydriver.findElement(By.xpath(".//*[@id='answers[89][value]']/label[2]")).click();
					mydriver.findElement(By.xpath(".//*[@id='edwosb']/input[4]")).click();
					//Locate the SBA Exam & Daily Operations questions, and select No for both and continue.
					mydriver.findElement(By.xpath(".//*[@id='answers[90][value]']/label[2]")).click();
					mydriver.findElement(By.xpath(".//*[@id='answers[91][value]']/label[2]")).click();
					mydriver.findElement(By.xpath(".//*[@id='answers_91_comment']")).sendKeys(comment);
					mydriver.findElement(By.xpath(".//*[@id='edwosb']/input[4]")).click();
					//Locate the Net Worth questions, and select No for both and continue.					
					mydriver.findElement(By.xpath(".//*[@id='answers[92][value]']/label[1]")).click();
					//Select yes and attempt to continue without uploading a document.
					mydriver.findElement(By.xpath(".//*[@id='answers[93][value]']/label[1]")).click();
					mydriver.findElement(By.xpath(".//*[@id='edwosb']/input[4]")).click();
					//Verify the user is promted to attached a document.
					if(mydriver.getPageSource().contains("Attachment is required")){
						System.out.println("User is prompted to upload or attech a Tax document, Pass");
						//Click on the upload button
						mydriver.findElement(By.xpath(".//*[@id='answers[66][attachment]']/div/label/div")).click();
                         Thread.sleep(4000);
							mydriver.findElement(By.xpath(".//*[@id='1']/td[1]/input")).click();
							Thread.sleep(4000);
							mydriver.findElement(By.xpath(".//*[@id='document_library_attach']")).click();


					}
					else{
						System.out.println("User is not prompted to upload or attech a Tax document,Failed");
                         mydriver.quit();
					}
					Thread.sleep(3000);
					//Verify that attachment was is successful.
					if(mydriver.getPageSource().contains("file3 copy")){
						System.out.println("Attachment was successful, Pass");

					}
					else{
						System.out.println("Attachment was Not successful,Failed");

					}
             //Locate the continue button and click on it.
					mydriver.findElement(By.xpath(".//*[@id='edwosb']/input[4]")).click();	

					//Locate the Adjusted Gross Income questions, and select No for both and continue.
					mydriver.findElement(By.xpath(".//*[@id='answers[94][value]']/label[2]")).click();
					mydriver.findElement(By.xpath(".//*[@id='answers[95][value]']/label[2]")).click();
					mydriver.findElement(By.xpath(".//*[@id='edwosb']/input[4]")).click();	
					//Locate the Fair Market Value questions, and select No and continue.
					mydriver.findElement(By.xpath(".//*[@id='answers[96][value]']/label[2]")).click();
					mydriver.findElement(By.xpath(".//*[@id='edwosb']/input[4]")).click();
					//Locate the Assets questions, and select No for both and continue.
					mydriver.findElement(By.xpath(".//*[@id='answers[97][value]']/label[2]")).click();
					mydriver.findElement(By.xpath(".//*[@id='answers[98][value]']/label[2]")).click();
					mydriver.findElement(By.xpath(".//*[@id='edwosb']/input[4]")).click();
	//Verify that user is able to navigate to the financial statement section.
					if(mydriver.getPageSource().contains("Financial Data")){
						System.out.println("User is able to answer all question and get to the financial statement section, Pass");
					}
					else{
						System.out.println("User is Unable to answer all question and get unable to the financial statement section, Failed");

					}
	}
@After
public void US870_STRETCH_WOSB_Self_Certifies_Add_Tax_Attachments_EndTest()throws Exception{
   mydriver.quit();

}

}
