package com.codebind;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
public class apptest 
{
	public static String error ="(/div[@class='error-msg'])[1]";
	
public static void main(String args[]) throws InterruptedException
{

	//setting driver properties
	System.setProperty("webdriver.chrome.driver","C:\\Users\\fidel\\Downloads/chromedriver.exe");
	WebDriver driver= new ChromeDriver();
	
	// Instantiate the chrome driver
	driver.manage().window().maximize();
	
	//Navigate to bestbuy.ca
	driver.navigate().to("https://www.bestbuy.ca/en-ca");
	Thread.sleep(10000);
	//search element
	driver.findElement(By.xpath("//*[@class='textField_e79SD']")).sendKeys("ipad",Keys.ENTER);
	
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("scroll(0,550);");
	Thread.sleep(10000);
	//Filter value
	boolean chk_onlinefilter=driver.findElement(By.id("facetFilter-Online Only")).isSelected() ;
	//if check box is not selected
	if(chk_onlinefilter==false)
	{
	 driver.findElement(By.id("facetFilter-Online Only")).click();
	}
	JavascriptExecutor jse1 = (JavascriptExecutor)driver;
	jse1.executeScript("scroll(0,550);");
	Thread.sleep(10000);
	//select product
	driver.findElement(By.xpath("(//div[contains(@class,'HocvR')])[1]")).click();
	Thread.sleep(10000); 
	//Add to cart
	driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
	Thread.sleep(10000);
	//View cart
	driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
	Thread.sleep(10000);
	//scroll the screen
	JavascriptExecutor jse2 = (JavascriptExecutor)driver;
	jse2.executeScript("scroll(0,550);");
	Thread.sleep(10000);
	//check out
	driver.findElement(By.xpath("(//span[@class='content_2t17U'])[5]")).click();
	Thread.sleep(10000);
	//Continue as guest
	driver.findElement(By.xpath("//a[@class='guest-continue-link']")).click();
	//Thread.sleep(10000);
	driver.navigate().refresh();
	driver.findElement(By.xpath("//input[@id='email']")).sendKeys("sharayu.bhosale.think@gmail.com");
	driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Sharayu");
	driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("Bhosale");
	driver.findElement(By.xpath("//input[@id='addressLine']")).sendKeys("D-21 Golden Ave");
	driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Canada");
	JavascriptExecutor jse3 = (JavascriptExecutor)driver;
	jse3.executeScript("scroll(0,550);");
	driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("9130490297");
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	Thread.sleep(10000);
	driver.findElement(By.xpath("//input[@id='shownCardNumber']")).sendKeys("4018061474033671");
    //Select exp month and yrs
	Select expirymonth = new Select(driver.findElement(By.name("expirationMonth")));
	expirymonth.selectByVisibleText("03");
	
	JavascriptExecutor jse4 = (JavascriptExecutor)driver;
	jse4.executeScript("scroll(0,250);");
	
	Select expiryrs = new Select(driver.findElement(By.name("expirationYear")));
	expiryrs.selectByVisibleText("2021");
	//Cvv
	driver.findElement(By.xpath("//input[@id='cvv']")).sendKeys("359");
	JavascriptExecutor jse5 = (JavascriptExecutor)driver;
	jse5.executeScript("scroll(0,-250);");
	driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
	
	//error message
	
	String errormsg=driver.findElement(By.xpath(error)).getText();
	System.out.println(errormsg);
	driver.quit();	
	
}
}


