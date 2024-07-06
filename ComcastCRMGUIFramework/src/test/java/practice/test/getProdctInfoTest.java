 package practice.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.ExcelUtility;

public class getProdctInfoTest {
	@Test(dataProvider = "getData")
	public void getprodctInfoTest(String brandname,String productname) {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://amazon.com");
		
		//search Product
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(brandname,Keys.ENTER);
		
		
		//capture product info
		String x="//span[text()='"+productname+"']/../../../../div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/a/span/span[2]/span[2]";
		String price=driver.findElement(By.xpath(x)).getText();
		System.out.println(price);
	}
	@DataProvider
	public Object[][] getData() throws Throwable {
		ExcelUtility eu=new ExcelUtility();
		int rowcount=eu.getRowCount("product");
		Object[][] objArr=new Object[rowcount][2];
		
		for(int i=0;i<rowcount;i++) {
		objArr[i][0]=eu.getDataFromExcel("product", i+1, 0);
		objArr[i][1]=eu.getDataFromExcel("product", i+1, 1);
		}	
		
		return objArr;
	}

}
