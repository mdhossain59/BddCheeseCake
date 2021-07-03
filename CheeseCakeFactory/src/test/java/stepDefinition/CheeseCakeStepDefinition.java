package stepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utilities.dataReader;

public class CheeseCakeStepDefinition {
	
	WebDriver driver;
	WebElement menu, menuDesserts, menuSnacks;
	
	@Given("^Navigate to given URL$")
	public void Navigate_to_given_url() throws Throwable{
		
		System.setProperty("webdriver.chrome.driver", "/Users/mdhossain/Downloads/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://www.thecheesecakefactory.com/");
		
		driver.manage().window().maximize();
		
	}
	@When("^Click on the Menu$")
	public void Click_on_the_Menu() throws Throwable{
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		WebElement menu = driver.findElement(By.xpath(dataReader.getTestData("menu")));
		menu.click();
	}

	@And("^A drop down menu would display$")
	public void drop_down_menu(){
		
	}
	    

	@And("^Click on Desserts$")
	public void Click_on_Desserts() throws Throwable{
		Actions actions = new Actions(driver);		
		WebElement menuDesserts = driver.findElement(By.xpath(dataReader.getTestData("menuDesserts")));
		WebElement menuSnacks = driver.findElement(By.xpath(dataReader.getTestData("menuSnacks")));
		
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
	}

	@Then("^The page would display Submenu for Desserts$")
	public void The_page_would_display(){
		driver.findElement(By.xpath("//*[@href='/menu/desserts/']")).click();
		
	}
	
	@Then("^customer choose the desert$")
	public void customer_choose_the_desert(){
		driver.findElement(By.xpath("//*[@href='/menu/desserts/']")).click();
		
	}
	
	@Then("^customer click on More hammer Icon$")
	public void customer_click_on_More_hammer_Icon(){
		driver.findElement(By.xpath("\r\n"
				+ "//a[@id='menuToggle']/span[1]")).click();
		
	}
	
	/*@Then("^customer should see About Us menu$")
	public void customer_should_see_About_Us_menu(){
		driver.findElement(By.xpath("//*[@href='/menu/desserts/']")).click();
		
	}*/
	
	
	
	



}
