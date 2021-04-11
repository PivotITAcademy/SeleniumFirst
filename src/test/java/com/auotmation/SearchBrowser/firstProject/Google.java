package com.auotmation.SearchBrowser.firstProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Google {

	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.get("https://demoqa.com/buttons");

		driver.manage().window().maximize();

	}

	@Test(priority = 1)
	@Ignore
	public void demoQaTitle() {

		String titleOfPage = driver.getTitle();
		System.out.println("Title of the Page: " + titleOfPage);
		Assert.assertEquals(titleOfPage, "ToolsQA");
	}
	
	public int sum(int a, int b) {
		return 10;
		
	}

	@Test(priority = 2, invocationCount = 3)
	@Ignore
	public void clickElementsOnHomePage() {		
		WebElement element = driver.findElement(By.cssSelector("div[class='avatar mx-auto white']"));
		element.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String titleOfPage = driver.getTitle();
		System.out.println("Title of the Page: " + titleOfPage);
		Assert.assertEquals(titleOfPage, "ToolsQA");

	}

	// Clicking on Text Box
	@Test
	@Ignore
	public void clickText() {

		// navigating to Elements Page
		WebElement element = driver.findElement(By.cssSelector("div[class='avatar mx-auto white']"));
		element.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Clicking on text box
		WebElement textBox = driver.findElement(By.cssSelector("span[class='text']"));
		textBox.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	@Ignore
	public void fillForm() {

		// navigating to Elements Page
		WebElement element = driver.findElement(By.cssSelector("div[class='avatar mx-auto white']"));
		element.click();

		// Clicking on text box
		WebElement textBox = driver.findElement(By.cssSelector("span[class='text']"));
		textBox.click();

		WebElement fullName = driver.findElement(By.id("userName"));
		WebElement email = driver.findElement(By.id("userEmail"));
		WebElement address = driver.findElement(By.id("currentAddress"));
		WebElement perAddress = driver.findElement(By.id("permanentAddress"));
		WebElement submitButton = driver.findElement(By.id("submit"));

		fullName.sendKeys("Joyce");
		email.sendKeys("dhinchakPooja@gmail.com");
		address.sendKeys("Brampton");
		perAddress.sendKeys("India");

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		submitButton.click();

		WebElement Name = driver.findElement(By.id("name"));
		WebElement emailAddress = driver.findElement(By.id("email"));

		String nameDisplayed = Name.getText().substring(5, 10).trim();
		String emailDispalyed = emailAddress.getText().replace("Email:", "").trim();

		Assert.assertEquals(nameDisplayed, "Joyce");
		Assert.assertEquals(emailDispalyed, "harpreet@gmail.com");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	@Ignore
	public void clickCheckBox() {

		// navigating to Elements Page
		driver.findElement(By.cssSelector("div[class='avatar mx-auto white']")).click();

		// clciking on checkbox
		WebElement checkBoxPage = driver.findElement(By.id("item-1"));

		checkBoxPage.click();

		WebElement checkBox = driver.findElement(By.cssSelector("svg[class='rct-icon rct-icon-uncheck']"));

		System.out.println("Is checkbox selecetd: " + checkBox.isSelected());

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// clicking on check box
		checkBox.click();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WebElement selectedCheckBox = driver.findElement(By.cssSelector("svg[class='rct-icon rct-icon-check']"));
		// asserting if checkbox is selecetd
		Assert.assertTrue(selectedCheckBox.isDisplayed());
	}

	@Test
	@Ignore
	public void radioButton() {

		// navigating to Elements Page
		driver.findElement(By.cssSelector("div[class='avatar mx-auto white']")).click();

		// clicking on radio menu
		WebElement radioButton = driver.findElement(By.id("item-2"));

		radioButton.click();

		WebElement impressRadioButton = driver.findElement(By.cssSelector("label[for='impressiveRadio']"));

		impressRadioButton.click();

		WebElement getTextForSelectedRadioButton = driver.findElement(By.cssSelector("span[class='text-success']"));

		getTextForSelectedRadioButton.getText();
		Assert.assertEquals(getTextForSelectedRadioButton.getText(), "Impressive");

	}
	@Test
	@Ignore
	public void getTableText() {
		
		//selenium easy website
		
		
		WebElement table6thElement=driver.findElement(By.cssSelector("table[class='table table-hover'] tr:nth-child(6) td:last-of-type"));
		
		System.out.println("Text at 6th is : " + table6thElement.getText());
		
	}
	
	@Test
	@Ignore
	public void doubleClick() {
		WebElement doubleClickButton=driver.findElement(By.id("doubleClickBtn"));
		
		Actions action=new Actions(driver);
		
		action.doubleClick(doubleClickButton).perform();
		
		WebElement doubleClickSucessMessage=driver.findElement(By.id("doubleClickMessage"));
		
		Assert.assertEquals(doubleClickSucessMessage.getText(), "You have done a double click");
		
	}
	
	@Test
	public void rightClick() {
		WebElement rightClickButton=driver.findElement(By.id("rightClickBtn"));
		
		Actions action=new Actions(driver);
		
		action.contextClick(rightClickButton).perform();
		
		WebElement rightClickSucessMessage=driver.findElement(By.id("rightClickMessage"));
		
		Assert.assertEquals(rightClickSucessMessage.getText(), "You have done a right click");
		
	}


	@AfterMethod
	public void afterMethod() {
		driver.close();

	}

}