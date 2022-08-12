package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Hard_Assert_sample 
{
	@Test
	public void createCustomerTest()
	{
	System.out.println("step1");	
	System.out.println("step2");	
	System.out.println("step3");
	Assert.assertEquals("a", "b");
	System.out.println("step4");	
	System.out.println("step5");	
	}
	
	@Test
	public void modifyCustomerTest()
	{
		System.out.println("----------------------------");	
		System.out.println("step1");	
		System.out.println("step2");
	}
	
}
