package practice.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;

public class AmazonTest {

	public static void main(String[] args) throws Throwable {
		ExcelUtility eu=new ExcelUtility();
		int count=0;
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/s?k=iphone&ref=nb_sb_noss");
		List<WebElement>Pprice=driver.findElements(By.xpath("//span[@class='a-price-whole']"));
		
		List<WebElement>Pname=driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		for(int i=0;i<=Pname.size()-1;i++)
		{
			String price=Pprice.toString().replace("₹","");
			System.out.println(price);
			 int j=Integer.parseInt(price);
			 if(j>60000) {
					System.out.println(Pname.get(i).getText()+"--------"+price);
			 }
			//System.out.println(Pname.get(i).getText()+"--------"+Pprice.get(i).getText());
			if(i<=count)
			{
				count++;
			}
		}	
		driver.close();
		}
}
