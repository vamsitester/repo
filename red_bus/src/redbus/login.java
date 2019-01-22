package redbus;

import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class login {

	public static void main(String[] args) throws InterruptedException 
	{
	 System.setProperty("webdriver.chrome.driver", "D:\\Selenium_Demp\\chromedriver.exe");
	 WebDriver driver=new ChromeDriver();
	 WebDriverWait wait=new WebDriverWait(driver, 20);
	 Actions act=new Actions(driver);
	
	 driver.manage().window().maximize();
	 driver.get("https://www.redbus.in/");
	 wait.until(ExpectedConditions.titleIs("Online Bus Tickets Booking, Book Volvo AC Bus Tickets, Confirmed Bus Reservation -redBus"));
	 if(driver.getTitle().equals("Online Bus Tickets Booking, Book Volvo AC Bus Tickets, Confirmed Bus Reservation -redBus"))
	 {
		 System.out.println("home page opened successfully");
	 }
	 else
	 {
		 System.out.println("home page unsuccessful");
	 }
	     
	 for(int i=1;i<4;i++)
	 {
	 WebElement off_list=driver.findElement(By.xpath("//*[@id='offer_container']/li["+i+"]"));
	 String off_st=off_list.getText();
	 System.out.println(off_st);
	 }
	 for(int i=1;i<6;i++)
	 {
	 WebElement top_list=driver.findElement(By.xpath("//*[@id='page_main_header']/nav/ul/li["+i+"]/a"));
	 String top_st=top_list.getText();
	 System.out.println(top_st);
	 }
	 //source , destination ands dates
	 WebElement sur=driver.findElement(By.id("src"));    
	 WebElement dst=driver.findElement(By.id("dest"));
	 WebElement ocal=driver.findElement(By.id("onward_cal"));
	 WebElement rcal=driver.findElement(By.id("return_cal"));
	 WebElement ser=driver.findElement(By.id("search_btn"));
	 if(sur.isDisplayed())
	 {
		 System.out.println("source column is displayed");
	 }
	 
	 if(dst.isDisplayed())
	 {
		 System.out.println("destination column is displayed");
	 }
	 
	 if(ocal.isDisplayed() && rcal.isDisplayed())
	 {
		 System.out.println("onward calander and source calander are displayed");
	 }
	 
	 if(ser.isDisplayed())
	 {
		 System.out.println("search button is displayed");
	 }
	 Calendar cal=Calendar.getInstance();
	 int dow= cal.get(Calendar.DAY_OF_WEEK_IN_MONTH);
	 int dom=cal.get(Calendar.DAY_OF_MONTH);
	 int day=cal.get(Calendar.DATE);
	 int month=cal.get(Calendar.MONTH);
	 
	 System.out.println("day of week: "+dow);
	 System.out.println("day of month: "+dom);
	 System.out.println("day: "+day);
	 System.out.println("month: "+month);
	String ssur="nellore";
	String sdst="Hyderabad";
	sur.sendKeys(ssur);
	sur.sendKeys(Keys.ENTER);
	dst.sendKeys(sdst);
	dst.sendKeys(Keys.ENTER);
	Alert a=driver.switchTo().alert();
	String aa=a.getText();
	System.out.println(aa);
	
	//WebElement n=driver.switchTo().parentFrame();
	if(a.getText().equals(""))
	a.accept();
	//act.moveToElement(ocal).perform();
	wait.until(ExpectedConditions.elementToBeClickable(By.linkText("25")));
	 WebElement fDate= driver.findElement(By.id("calendar"));
     List <WebElement> lftDate= fDate.findElements(By.tagName("table"));
     for(WebElement fdTable:lftDate)
     {
     fdTable.findElement(By.linkText("25")).click();
     break;
     }

	//driver.findElement(By.xpath("//*[@id='rb-calendar_onward_cal']/table/tbody/tr[5]/td[5]")).click();
	Thread.sleep(5000); 
	 driver.close();

	}

}
