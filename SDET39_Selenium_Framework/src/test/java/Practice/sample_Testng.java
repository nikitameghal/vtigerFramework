package Practice;

import org.testng.annotations.Test;

public class sample_Testng {
	
	@Test(priority=2)
	 public void createContact() 
	{
		System.out.println("contact created");
	}
	
	@Test(priority=1)
	public void modifyContact() 
	{
		System.out.println("contact modified");
	}
	@Test(priority=3)
	public void deleteContact()
	{
		System.out.println("contact deleted");
	}

}
