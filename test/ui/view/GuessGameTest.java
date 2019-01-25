package ui.view;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GuessGameTest {

	private WebDriver driver;
	private String url = "http://localhost:8080/";
	
	@Before
	public void setUp () {
//		System.setProperty("webdriver.chrome.driver", "/Applications/chromedriver");
//		driver = new ChromeDriver();
		System.setProperty("webdriver.gecko.driver", "/Applications/geckodriver");
		driver = new FirefoxDriver();
	}
	
	@Test
	public void test_Guess_a_number () {
		driver.get(url+"Guess?guess=1");
		
		assertEquals("Guess", driver.getTitle());
		String message = driver.findElement(By.tagName("h2")).getText();
		
		int number = 2;
		while(! message.equals("Well done! That was correct!")) {
			driver.get(url+"Guess?guess="+number);
			
			message = driver.findElement(By.tagName("h2")).getText();
			number++;
		}
		
		assertEquals("Well done! That was correct!", message);
	}
	
	@After
	public void tearDown () {
		driver.quit();
	}
	
}
