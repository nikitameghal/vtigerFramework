package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Demo_retry {

	@Test(retryAnalyzer = com.Vtiger.Generic_Utility.ReTryImpClass.class)
	public void modifyContact()
	{
	Assert.assertEquals(false, true);	
	System.out.println("modified contacts");
	
	}

}
