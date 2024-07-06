package practice.test;
/**
 * test class for contact module
 * @author hi
 *
 */

import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectreposotoryutility.LoginPage;

public class SearchContactTest extends BaseClass{
	
	@Test
	public void SearchContactTest() {
		
		LoginPage lp=new LoginPage(driver);
		lp.LoginToapp("url","username","password");
	}
}
