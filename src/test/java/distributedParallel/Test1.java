package distributedParallel;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Test1 {

	@Test
	public void demo1() {
		System.out.println("Test1 - demo1");
	}
	
	@Test
	public void demo2() {
		System.out.println("Test1 - demo2");
		//Assert.fail();
	}
	
	@Test
	public void demo3() {
		System.out.println("Test1 - demo3");
	}
}
