package jdbc;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BaiduTest {
	private  WebDriver driver =null;
	//private  DesiredCapabilities cap = null;
	//private String projectpath = System.getProperty("user.dir");
	@BeforeClass
	public void startIE() {
		System.setProperty("webdriver.ie.driver", "E:\\工作\\eclipse\\eclipse-workspace\\jdbc\\tools\\IEDriverServer.exe");
		//cap=DesiredCapabilities.internetExplorer();
		//cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		//cap.setCapability(InternetExplorerDriver.IE_SWITCHES, ".private");
		//cap.setCapability("ignoreZoomSetting", true);
		driver = new InternetExplorerDriver();
	}
	@Test
	public void baidu() {
		driver.get("http://www.baidu.com");
		driver.findElement(By.id("kw")).sendKeys("selenium");
		driver.findElement(By.id("su")).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
	}
	@AfterClass
	public void end() {
		driver.close();
	}
}
