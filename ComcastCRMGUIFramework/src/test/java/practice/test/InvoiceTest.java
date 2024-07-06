package practice.test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
//@Listeners(com.comcast.crm.listenerutility.ListenerImplementationClass.class)
public class InvoiceTest extends BaseClass{
	@Test(retryAnalyzer = com.comcast.crm.listenerutility.RetryListenerImpClass.class)
	public void ActivateSim() {
		System.out.println("Execute CreateInvoiceTest");
		String var=driver.getTitle();
		Assert.assertEquals(var,"Login");
		System.out.println("step-1");
		System.out.println("step-2");
		System.out.println("step-3");
		System.out.println("step-4");
	}
	

}
