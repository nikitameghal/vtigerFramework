package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Soft_Assert_sample {

@Test
public void createCustomerTest()
{
	System.out.println("step1");	
	System.out.println("step2");	
	System.out.println("step3");
	SoftAssert s= new SoftAssert();
	s.assertEquals("a", "b");
	System.out.println("step4");
	s.assertEquals("x", "y");
	System.out.println("step5");
	s.assertAll();
}

@Test
public void modifyCustomerTest()
{
	System.out.println("----------------------------");	
	System.out.println("step1");	
	System.out.println("step2");
}


}

