package test;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;

public class DarazSearchTest {
	
	public static void main(String[] args) throws InterruptedException {
		maincode();
		
	}

	public static void maincode()
	{
		TestListenerAdapter tla = new TestListenerAdapter();
		TestNG testng = new TestNG();
		testng.setTestClasses(new Class[] { RobotTest.class });
		testng.addListener(tla);
		testng.run();
	}
	
}

