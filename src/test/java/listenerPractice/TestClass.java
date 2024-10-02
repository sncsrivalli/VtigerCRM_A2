package listenerPractice;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(listenerPractice.ListenerImplementation.class)
public class TestClass extends BaseClass {

	@Test
	public void testMethod() {
		System.out.println("@Test");
	}
}
