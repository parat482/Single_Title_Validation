package core;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;


public class Single{
	
	public static void main(String[] args) {
		
		if (args.length == 0) {
			System.err.println("No arguments");
			System.exit(1);
		}
		
		WebDriver driver = new FirefoxDriver();  // Version 1.1 :: Firefox
//		WebDriver driver = new HtmlUnitDriver();       // Version 1.2 :: HtmlUnit
//		String url = "http://www.learn2test.net";
//		String title_expected = "learn2test.net";
		
		String param[] = args[0].split("\\|");
		String url = param[0];
		String title_expected = param[1];
		
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		String title_actual = driver.getTitle();
		
		if (title_expected.equals(title_actual)) {
			System.out.println("PASSED");
		} else {
			System.out.println("FAILED");
		}
		driver.quit();
	}

}
