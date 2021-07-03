package cheeseCakeFactorySmoke;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CheeseCakeFactorySmokeTest {

	WebDriver driver;
	WebElement checkBox;

	@Before
	public void initializeBrowser() {
		System.setProperty("webdriver.chrome.driver", "/Users/mdhossain/Downloads/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://www.thecheesecakefactory.com/");
		
		driver.manage().window().maximize();
	}

	@Test
	public void verifyPageTitle() {

		String actualResult = driver.getTitle();
		String expectedResult = "Welcome to The Cheesecake Factory";
		if (actualResult.equals(expectedResult)) {
			System.out.print("The page is opened and Title is verified");
		} else {
			System.out.print("The page title is not verified");

		}
		
		//assertEquals(actualResult, expectedResult);

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		WebElement menu = driver.findElement(By.xpath("//a[@href='/menu/']"));
		highLighterMethod(driver, menu);
		menu.click();
		
		
		Actions actions = new Actions(driver);		
		WebElement menuDesserts = driver.findElement(By.xpath("//*[@href='/menu/desserts/']"));
		WebElement menuSnacks = driver.findElement(By.xpath("//*[@href='/menu/small-plates-snacks-appetizers/']"));
		actions.moveToElement(menuDesserts).moveToElement(driver.findElement(By.xpath("//*[@href='/menu/small-plates-snacks-appetizers/']"))).build().perform();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		actions.moveToElement(menuSnacks).moveToElement(driver.findElement(By.xpath("//*[@href='/menu/salads/']"))).build().perform();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//driver.findElement(By.xpath("//*[@href='/menu/desserts/']")).click();
		
	}
	
	public void highLighterMethod(WebDriver driver, WebElement element){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red;');", element);
	}

	@Test
	public void SignupNewUser() {

		driver.findElement(By.xpath("//*[@id='footer']/div/ul/li[5]/a")).click();
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//input[@name='email_43']")).sendKeys("fahimsrkhan@yahoo.com");
		
		driver.findElement(By.xpath("//input[@name='first_name_44']")).sendKeys("fahim");
		
		driver.findElement(By.xpath("//*[@id='amf-input-last_name_45']")).sendKeys("khan");
		
		Select countryDropDown = new Select(driver.findElement(By.xpath("//*[@name='country_77']")));
		countryDropDown.selectByValue("United States");
		
		driver.findElement(By.xpath("//*[@name='zippostal_code_46']")).sendKeys("11435");
		
		Select dayDropDown = new Select(driver.findElement(By.xpath("//*[@name='day-birthday_47']")));
		dayDropDown.selectByValue("17");
		
		Select monthDropDown = new Select(driver.findElement(By.xpath("//*[@name='month-birthday_47']")));
		monthDropDown.selectByValue("03");
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Select locationDropDown = new Select(driver.findElement(By.xpath("//*[@name='preferred_location_78']")));
		locationDropDown.selectByValue("North York, ON Canada");
		
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		
		Actions actions = new Actions(driver);		
		WebElement checkBox = driver.findElement(By.xpath("//*[@class='checkbox']"));
		actions.moveToElement(checkBox).moveToElement(driver.findElement(By.xpath("//*[@class='checkbox']"))).click().build().perform();		

		//driver.findElement(By.xpath("//*[@class='recaptcha-checkbox-checkmark']")).click();
	
		
		
		
	}

	@After
	public void closeBrowser() {
		//driver.close();

	}

}
