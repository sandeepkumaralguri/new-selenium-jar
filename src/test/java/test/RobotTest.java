package test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.wtt.docker.listener.PropertiesUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RobotTest {
	WebDriver driver = null;
	Actions actions = null;
	// Screen s = new Screen();
	// RemoteScreen rs = new RemoteScreen("http://127.0.0.1:49160");

	@Test
	public void launchGoogle() throws InterruptedException, AWTException, IOException {

		PropertiesUtility.loadApplicationProperties();
//		System.setProperty("webdriver.gecko.driver",ClassLoader.getSystemResourceAsStream("/src/test/resources/application.properties"));
		System.setProperty("webdriver.gecko.driver","/src/test/resources/geckodriver.exe");
		Robot robot = new Robot();
		// option.addArguments("-headless","window-size=1920x1080");
		// DesiredCapabilities cap = DesiredCapabilities.firefox();
		// cap.setPlatform(Platform.LINUX);
		// cap.merge(option.toCapabilities());
		WebDriverManager.firefoxdriver().setup();
//		driver = new ChromeDriver();
		driver = new FirefoxDriver();
		// driver = new ChromeDriver(chromeOptions);
		Thread.sleep(3000);
		driver.manage().window().maximize();

		System.out.println("driver connected.............");
		driver.navigate().to(PropertiesUtility.properties.getProperty("google.url"));
			//driver.get("https://www.google.co.in");
		System.out.println(driver.getTitle());

		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("Testng");
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		Thread.sleep(4000);

		driver.findElement(By.xpath("//h3[contains(text(),'TestNG - Welcome')]")).click();

		System.out.println(driver.getCurrentUrl());
		Thread.sleep(8000);

		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(3000);

		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(3000);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(5000);
		Assert.assertEquals("https://testng.org/doc/documentation-main.html", driver.getCurrentUrl());

		Thread.sleep(3000);

		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(3000);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(5000);

		Assert.assertEquals("https://testng.org/doc/download.html", driver.getCurrentUrl());

		driver.close();
		System.out.println("Driver Closed");

	}

}

/*
 * PropertiesUtility.loadApplicationProperties();
 * System.setProperty("webdriver.chrome.driver",
 * "/home/walkingtree/Music/chromedriver_linux64/chromedriver");
 * 
 * ChromeOptions chromeOptions = new ChromeOptions();
 * 
 * 
 * chromeOptions.addArguments("headless"); WebDriver driver = new
 * ChromeDriver(chromeOptions);
 * 
 * //driver = new ChromeDriver(chromeOptions);
 * driver.get("https://www.google.com"); driver.manage().window().maximize();
 * System.out.println(driver.getTitle());
 */

/*
 * DesiredCapabilities capabilities = DesiredCapabilities.chrome();
 * capabilities.setPlatform(Platform.LINUX);
 * PropertiesUtility.loadApplicationProperties(); driver = new
 * RemoteWebDriver(new
 * URL(PropertiesUtility.properties.getProperty("environment.url")),
 * capabilities); System.out.println("driver connected.............");
 * driver.navigate().to(PropertiesUtility.properties.getProperty("google.url"));
 * 
 * Screen s = new Screen();
 * 
 * s.type("Sikuli"); Thread.sleep(3000);
 * driver.findElement(By.xpath("(//span[contains(text(),'sikuli')])[1]")).click(
 * );
 * 
 * Thread.sleep(3000); driver.findElement(By.
 * xpath("//h3[contains(text(),'Sikuli Documentation — Sikuli X 1.0 documentation')]"
 * )).click();
 * 
 * Thread.sleep(3000);
 * driver.findElement(By.xpath("//a[contains(text(),'contact us')]")).click();
 * Thread.sleep(5000);
 * 
 * Robot robot=new Robot(); robot.keyPress(KeyEvent.VK_TAB);
 * robot.keyRelease(KeyEvent.VK_TAB);
 * 
 * robot.keyPress(KeyEvent.VK_ENTER); robot.keyRelease(KeyEvent.VK_ENTER);
 */

/*
 * DesiredCapabilities capabilities = DesiredCapabilities.chrome();
 * capabilities.setPlatform(Platform.LINUX);
 */
//System.setProperty("webdriver.chrome.driver","/home/walkingtree/Music/chromedriver_linux64/chromedriver");
/*
 * ChromeOptions chromeOptions = new ChromeOptions();
 * 
 * chromeOptions.addArguments("--headless");
 */
//capabilities.setCapability(ChromeOptions.CA;
//chromeOptions.addArguments("\"window-size=1400,800\"");
//capabilities.op

/*
 * 
 * FirefoxOptions options = new FirefoxOptions();
 * options.addArguments("--headless");
 */
/*
 * ChromeOptions chromeOptions = new ChromeOptions();
 * chromeOptions.addArguments("--headless");
 */

/*
 * Screen s = new Screen(); System.out.println("sikuli start ***********");
 * Thread.sleep(3000); //s.click(System.getProperty(
 * "/home/walkingtree/Downloads/GoogleSearchField.png"));
 * System.out.println("sikuli clicked ***********"); s.type("Sikuli");
 * System.out.println("Sikuli Failed **********************");
 * //e.printStackTrace();
 * 
 * 
 * Thread.sleep(3000);
 * 
 * driver.findElement(By.xpath("(//span[contains(text(),'sikuli')])[1]")).click(
 * );
 * 
 * Thread.sleep(3000); driver.findElement(By.
 * xpath("//h3[contains(text(),'Sikuli Documentation — Sikuli X 1.0 documentation')]"
 * )).click(); Thread.sleep(3000);
 * driver.findElement(By.xpath("//a[contains(text(),'contact us')]")).click();
 * Thread.sleep(5000); s.click(System.getProperty(
 * "/home/walkingtree/Downloads/login_SikuliScreen.png"));
 * 
 * 
 * 
 * 
 * driver.findElement(By.xpath("//a[contains(text(),'Log in / Register')]")).
 * click(); Thread.sleep(4000);
 * s.click(System.getProperty("/home/walkingtree/Downloads/AcceptAll.png"));
 * Thread.sleep(2000);
 * s.click(System.getProperty("/home/walkingtree/Downloads/EmailAddress.png"));
 * 
 * s.type("test@gmail.com");
 * 
 * s.click(System.getProperty("/home/walkingtree/Downloads/PwdField1.png"));
 * 
 * s.type("test123");
 * 
 * s.click(System.getProperty(
 * "/home/walkingtree/Downloads/LoginMemberRegistration.png"));
 * 
 * Threa d.sleep(5000);
 */