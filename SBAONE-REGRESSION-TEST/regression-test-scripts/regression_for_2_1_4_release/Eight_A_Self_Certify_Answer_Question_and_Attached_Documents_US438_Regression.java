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

public class Eight_A_Self_Certify_Answer_Question_and_Attached_Documents_US438_Regression {
		public WebDriver mydriver;
		String myurl;
		String email;
		String password;
	@Before
	public void EDWOSB_Self_Certify_Answer_Question_and_Attached_Documents_Setup()throws Exception{
		myurl="https://certify.qa.sba-one.net/users/sign_in";
		email="akanamontana@gmail.com";
		password="password";
		
		File file = new File("C:\\SBA-AUTOMATION-TEST\\SBAONE-REGRESSION-TEST\\libs\\IEDriverServer32b.exe");
		   System.setProperty("webdriver.ie.driver", file.getAbsolutePath());	
		   File file1 = new File("C:\\SBA-AUTOMATION-TEST\\SBAONE-REGRESSION-TEST\\libs\\chromedriver.exe");
		   System.setProperty("webdriver.chrome.driver", file1.getAbsolutePath());
		   //mydriver=new InternetExplorerDriver();
		   //mydriver=new ChromeDriver();
		   mydriver=new FirefoxDriver();
	}
	@Test
	//US
	public void EDWOSB_Self_Certify_Answer_Question_and_Attached_Documents_Maintest()throws Exception{
		//Step 1. Open Firefox browser and navigate to url.
				mydriver.navigate().to(myurl);
				mydriver.manage().window().maximize();
				   Thread.sleep(2000);
				    if(mydriver.getPageSource().contains("SIGN IN TO CERTIFY.SBA.GOV")){
				    	System.out.println("Successful login alert message pop up activated.");
				    	}		
				    	else{
				    	System.out.println("Successful login alert message pop up not activated");
				    	}	
				//Step 4. Enter a valid email.
				    mydriver.findElement(By.xpath(".//*[@id='user_email']")).sendKeys(email);
				//Step 5. Enter a valid password.
				    mydriver.findElement(By.xpath(".//*[@id='user_password']")).sendKeys(password);
				// Click on the "Submit" Button.
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
							mydriver.findElement(By.xpath(".//*[@id='dashboard-index']/div[4]/div[2]/table/tbody/tr/td[4]/a[2]")).click();
							mydriver.switchTo().alert().accept();
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
	//Step 5. Locate and click the Certifications button, from the drop-down, select EDWOSB.
		mydriver.findElement(By.xpath(".//*[@id='js-navigation-menu']/li[2]/a")).click();
		mydriver.findElement(By.xpath(".//*[@id='js-navigation-menu']/li[2]/ul/li[2]/a")).click();
		Thread.sleep(3000);
	//Step 6. Locate the accept button for the terms of certification and click on it.
		mydriver.findElement(By.xpath(".//*[@id='new_sba_application']/input[3]")).click();
		Thread.sleep(3000);
	//Step 7. Select YES for the 8(a) Question and attached document if applicable .
		mydriver.findElement(By.xpath(".//*[@id='answers[65][value]']/label[1]")).click();
		Thread.sleep(2000);
		mydriver.findElement(By.xpath(".//*[@id='answers[5][attachment]']/div/label/div")).click();
		Thread.sleep(2000);
		//mydriver.findElement(By.xpath(".//*[@id='answers[5][attachment]']/div/div[1]/div/ul/li[2]/a")).click();
		Thread.sleep(2000);
		mydriver.findElement(By.xpath(".//*[@id='5']/td[1]/input")).click();
		Thread.sleep(5000);
		mydriver.findElement(By.xpath(".//*[@id='document_library_attach']")).click();

			
		
	//Step 10. Verify that document is attached.
	    System.out.println(mydriver.findElement(By.xpath(".//*[@id='tentatively_attached']/tbody/tr/td")).getText());
	    Thread.sleep(5000);
	//Step 11. Locate the save and continue button and click on it.
	    mydriver.findElement(By.name("commit")).click();
	    Thread.sleep(2000);
	//Verify that user navigated to the review page upon successful document upload.
	    if(mydriver.getPageSource().contains("Review")){
	    	System.out.println("Document successfully uploaded, Pass");
	    }
	    else{
	    	System.out.println("Document was not successfully uploaded, Failed");

	    }
	//Step 16. Locate the sign-out button and click on it.
	    mydriver.findElement(By.xpath(".//*[@id='js-navigation-menu']/li[6]/a")).click();
	    Thread.sleep(3000);
		if(mydriver.getPageSource().contains("Signed out successfully")){
			mydriver.findElement(By.xpath(".//*[@id='labelid']")).click();
		}
		else{
			System.out.println("Successful sign in alert message not present");
		}
		
	}
	@After
	public void EDWOSB_Self_Certify_Answer_Question_and_Attached_Documents_Endtest()throws Exception{
		mydriver.close();
		
	}


}
