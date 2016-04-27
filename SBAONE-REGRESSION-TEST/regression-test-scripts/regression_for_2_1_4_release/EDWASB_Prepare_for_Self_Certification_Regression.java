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

public class EDWASB_Prepare_for_Self_Certification_Regression {
		public WebDriver mydriver;
		String myurl;
		

		
	@Before
	public void WASB_Prepare_for_Self_Certification_setup()throws Exception{
	   myurl="http://certify.qa.sba-one.net/certifications/wosb/checklist";
	   
	   File file = new File("C:\\SBA-AUTOMATION-TEST\\SBAONE-REGRESSION-TEST\\libs\\IEDriverServer32b.exe");
	   System.setProperty("webdriver.ie.driver", file.getAbsolutePath());	
	   File file1 = new File("C:\\SBA-AUTOMATION-TEST\\SBAONE-REGRESSION-TEST\\libs\\chromedriver.exe");
	   System.setProperty("webdriver.chrome.driver", file1.getAbsolutePath());
	   //mydriver=new InternetExplorerDriver();
	   //mydriver=new ChromeDriver();
	   mydriver=new FirefoxDriver();
	}
	@Test
	   public void WOSB_Prepare_for_Self_Certification_Main_test()throws Exception{
	//Step 1. Open Firefox and enter the the valid Url.
	   mydriver.navigate().to(myurl);
	   mydriver.manage().window().maximize();
	//Step 2. Click on "Prepare for Certification" link. 
	   mydriver.findElement(By.xpath(".//*[@id='wosb_eligibility_wosb_checklist']")).click();
	Thread.sleep(2000);
	//Click on EDWASB.
	mydriver.findElement(By.xpath(".//*[@id='wosb_eligibility_edwosb_checklist-1']")).click();
	//Step 3. Verify that EDWASB Self-Certification page AND Four business LINK type is present.
	   if(mydriver.getPageSource().contains("Prepare for Self-Certification (WOSB)")){
		 System.out.println("EDWOSB Prepare for Self-Certification page AND FOUR business link types are Present");
	}
	  else{
		 System.out.println("EDWOSB Prepare for Self-Certification page NOT present");
	}
	   System.out.println(mydriver.findElement(By.xpath(".//*[@id='main-content']/div")).getText());
	//Step 4.Select the "LLC" link and verify.
	   System.out.println("01-LLC");
	   mydriver.findElement(By.xpath(".//*[@id='llc']")).click(); 
	   Thread.sleep(2000);
	//Step 5.Verify that a list of activities and/or supporting documentation are present.
	   System.out.println(mydriver.findElement(By.xpath(".//*[@id='js-expander-content-1']")).getText());
	//Step 6.Verify that a link reads "SAM.gov" for Active registration in the System for Award Management is present.
	   Thread.sleep(2000);
	   if(mydriver.getPageSource().contains("SAM.gov")){
		System.out.println("Registration link Present");
	}
	   else{
		System.out.println("Registration link NOT Present");

	}
	//Step 7. Select the "Partnership" link and verify 
	   System.out.println("02-Partnership");
	   mydriver.findElement(By.xpath(".//*[@id='partner_agreement']")).click();
	//Step 8.Verify that a list of activities and/or supporting documentation are present.
	   System.out.println(mydriver.findElement(By.xpath(".//*[@id='js-expander-content-1']")).getText());
	Thread.sleep(2000);
	//Step 9.Verify that a link reads "SAM.gov" for Active registration in the System for Award Management is present.
	   if(mydriver.getPageSource().contains("SAM.gov")){
		System.out.println("Registration link Present");
	}
	   else{
		System.out.println("Registration link NOT Present");

	}
	//Step 10. Select the "Sole Proprietorship" link and verify
	   System.out.println("03-Sole Proprietorship");
	   mydriver.findElement(By.xpath(".//*[@id='sole_prop']")).click();
	//Step 11.Verify that a list of activities and/or supporting documentation are present.
	   System.out.println(mydriver.findElement(By.xpath(".//*[@id='js-expander-content-3']")).getText());
	//Step 12.Verify that a link reads "SAM.gov" for Active registration in the System for Award Management is present.
	   if(mydriver.getPageSource().contains("SAM.gov")){
		System.out.println("Registration link Present");
	}
	   else{
		System.out.println("Registration link NOT Present");

	}
	//Step 13. Select the "Corporation and S-Corporation" link and verify
	   System.out.println("04-Corporation and S-Corporation");
	   mydriver.findElement(By.xpath(".//*[@id='all_others']")).click();
	//Step 14.Verify that a list of activities and/or supporting documentation are present.
	   System.out.println(mydriver.findElement(By.xpath(".//*[@id='js-expander-content-4']")).getText());
	//Step 15.Verify that a link reads "SAM.gov" for Active registration in the System for Award Management is present.
	   if(mydriver.getPageSource().contains("SAM.gov")){
		System.out.println("Registration link Present");
	}
	   else{
		System.out.println("Registration link NOT Present");

	}
	}
	@After
	  public void WASB_Prepare_for_Self_Certification_End_test()throws Exception{
	  mydriver.quit();

	}

}
