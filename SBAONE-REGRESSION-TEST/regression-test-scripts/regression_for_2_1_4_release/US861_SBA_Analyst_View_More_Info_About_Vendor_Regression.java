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

public class US861_SBA_Analyst_View_More_Info_About_Vendor_Regression {
	
	public WebDriver mydriver;
	String myurl;
	String AAEmail;
	String AAPassW;
	String Duns;
	String B_N;
	
@Before
public void US861_SBA_Analyst_View_More_Info_About_Vendor_Setup()throws Exception{
	myurl="https://certify.qa.sba-one.net/users/sign_in";
	AAEmail="analyst1@mailinator.com";
	AAPassW="password";
	Duns="275276652";		
	B_N="Entity 37 Legal";
	
	File file = new File("C:\\SBA-AUTOMATION-TEST\\SBAONE-REGRESSION-TEST\\libs\\IEDriverServer32b.exe");
	System.setProperty("webdriver.ie.driver", file.getAbsolutePath());	
	File file1 = new File("C:\\SBA-AUTOMATION-TEST\\SBAONE-REGRESSION-TEST\\libs\\chromedriver.exe");
	System.setProperty("webdriver.chrome.driver", file1.getAbsolutePath());
	//mydriver=new InternetExplorerDriver();
	//mydriver=new ChromeDriver();
	mydriver=new FirefoxDriver();
	
}
@Test
public void US861_SBA_Analyst_View_More_Info_About_Vendor_MainTest()throws Exception{
//Notes; Role Most be assigned at the database and validated at the front end.
 
//Open Firefox,Chrome or IE and navigate the certify.SBA.gov login page.
	mydriver.navigate().to(myurl);
	mydriver.manage().window().maximize();
// Locate the email search box and enter a valid email for the User who have been assign the analyst role.
	mydriver.findElement(By.xpath(".//*[@id='user_email']")).sendKeys(AAEmail);
//Locate the password search box and enter a valid password.
	mydriver.findElement(By.xpath(".//*[@id='user_password']")).sendKeys(AAPassW);
//Locate the Sign-in button and click on it to login.
	mydriver.findElement(By.xpath(".//*[@id='business_signin']")).click();
	Thread.sleep(3000);
	if(mydriver.getPageSource().contains("Signed in successfully")){
	mydriver.findElement(By.xpath(".//*[@id='labelid']")).click();
		}
	else{
		System.out.println("Successful sign in alert message not present");
		}
	Thread.sleep(3000); 
//Locate the search for vendor search box and enter a valid Duns number.
	mydriver.findElement(By.xpath(".//*[@id='query']")).sendKeys(Duns);
//Locate the search button and click it.
	mydriver.findElement(By.xpath(".//*[@id='analyst-search']/div/div[2]/button")).click();
//Clear the search duns number in the search box and very that that the duns number is thesame on the search result.
	mydriver.findElement(By.xpath(".//*[@id='query']")).clear();
	Thread.sleep(4000);
    if(mydriver.getPageSource().contains("275276652")){
		System.out.println("The saerch results maches the business for the searched Duns number, Pass.");

    }
    else{
		System.out.println("The saerch results does not mache the business for the searched Duns number, Failed");
mydriver.quit();
    }
Thread.sleep(4000);
//Locate the search for vendor search box and enter a valid business name.
     mydriver.findElement(By.xpath(".//*[@id='query']")).sendKeys(B_N);
//Click on the search button.
	mydriver.findElement(By.xpath(".//*[@id='analyst-search']/div/div[2]/button")).click();
//Clear the search duns number in the search box and very that that the duns number is thesame on the search result.
	mydriver.findElement(By.xpath(".//*[@id='query']")).clear();
	Thread.sleep(4000);
	if(mydriver.getPageSource().contains("Entity 37")){
		System.out.println("The saerch results maches the business for the searched Business name, Pass.");

		 }
	else{
	System.out.println("The saerch results does not mache the business for the searched Business name, Failed");
	mydriver.quit();

		}
//Loacte the view profile button and click on it.
	mydriver.findElement(By.xpath(".//*[@id='view_business_profile']")).click();
	Thread.sleep(3000);
//Locate the view more button and click on it to view all the company information.
	if(mydriver.getPageSource().contains("Entity 37 Legal Business Name")){
		System.out.println("The link to view more information about the company is present, Pass.");
		mydriver.findElement(By.xpath(".//*[@id='business_search']/div[3]/div/a")).click();

	}
	else{
		System.out.println("The link to view more information about the company is Not present, Failed");

	}
//Capture and print out result for the search company/ business type.
	System.out.println(mydriver.findElement(By.xpath(".//*[@id='business_search']/div[3]")).getText());
	
}
@After
public void US861_SBA_Analyst_View_More_Info_About_Vendor_EndTest()throws Exception{
	mydriver.quit();
}

}
