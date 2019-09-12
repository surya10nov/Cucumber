package com.stepdefinition;

import java.util.List;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class AddCustomers {
	static WebDriver driver;
	@Given("User should be in the telecom page")
	public void user_should_be_in_the_telecom_page() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Surya\\eclipse-workspace\\CucumberList\\dri\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/telecom/");	    
	}
	@Given("click add customer button")
	public void click_add_customer_button() {
		driver.findElement(By.xpath("(//a[text()='Add Customer'])[1]")).click();
		}
	@When("user enter the datas")
	public void user_enter_the_datas() {
		driver.findElement(By.xpath("//label[@for='done']")).click();
		driver.findElement(By.id("fname")).sendKeys("surya");
		driver.findElement(By.id("lname")).sendKeys("perumal");
		driver.findElement(By.id("email")).sendKeys("suryabca@gmail.com");
		driver.findElement(By.name("addr")).sendKeys("chennai");
		driver.findElement(By.id("telephoneno")).sendKeys("1234567890");  
	}

@When("user enter the datas.")
public void user_enter_the_datas(io.cucumber.datatable.DataTable cstLis) {
	List<List<String>> Lists = cstLis.asList(String.class);	
		driver.findElement(By.xpath("//label[@for='done']")).click();
		driver.findElement(By.id("fname")).sendKeys(Lists.get(1).get(0));
		driver.findElement(By.id("lname")).sendKeys(Lists.get(1).get(1));
		driver.findElement(By.id("email")).sendKeys(Lists.get(1).get(2));
		driver.findElement(By.name("addr")).sendKeys(Lists.get(1).get(3));
		driver.findElement(By.id("telephoneno")).sendKeys(Lists.get(1).get(4)); 
}

@When("user enter the datass.")
public void user_enter_the_datass(io.cucumber.datatable.DataTable cstMap) {
	List<Map<String, String>> maps = cstMap.asMaps(String.class,String.class);
	driver.findElement(By.xpath("//label[@for='done']")).click();
	driver.findElement(By.id("fname")).sendKeys(maps.get(2).get("fname"));
	driver.findElement(By.id("lname")).sendKeys(maps.get(2).get("lname"));
	driver.findElement(By.id("email")).sendKeys(maps.get(2).get("email"));
	driver.findElement(By.name("addr")).sendKeys(maps.get(2).get("address"));
	driver.findElement(By.id("telephoneno")).sendKeys(maps.get(2).get("phno"));

}
	@When("click submit button")
	public void click_submit_button() {
		driver.findElement(By.name("submit")).click();
	    }
	@Then("output should be displayed")
	public void output_should_be_displayed() {
		WebElement cstId = driver.findElement(By.xpath("(//td[@align='center'])[2]"));
		Assert.assertTrue(cstId.isDisplayed());  
	}


}
