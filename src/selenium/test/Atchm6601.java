package selenium.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Atchm6601 {
	
	WebDriver driver = null;
	
	public void launchChromeBrowser() {
		System.setProperty("webdriver.chrome.driver", "/Users/manny/Documents/personal/Selenium/chromedriver");
		
		System.out.println("Open Chrome Browser!");
		
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
	}
	
	public void searchInfiniteCampusCareerPage() throws InterruptedException {
		driver.findElement(By.name("q")).sendKeys("infinite campus careers");
		Thread.sleep(10000);
		driver.findElement(By.name("btnK")).sendKeys(Keys.ENTER);
		Thread.sleep(10000);
		driver.findElement(By.xpath("//a[@href='https://www.infinitecampus.com/company/careers']")).click();
	}
	
	public void findOpenPositionButton() throws InterruptedException {
		Thread.sleep(10000);
		
		List<WebElement> buttons = driver.findElements(By.linkText("View Open Positions"));
		
		if(buttons.size() > 0) {
			System.out.println("Open the first button.");
			buttons.get(0).click();
		} else {
			System.out.println("There is no buttons on this page. Finish this test.");
			closeBrowser();
		}
	}
	
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(10000);
		
		System.out.println("Close the browser the browser.");
		
		driver.quit();
	}

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Start the test!!");

		Atchm6601 obj = new Atchm6601();
		obj.launchChromeBrowser();
		obj.searchInfiniteCampusCareerPage();
		obj.findOpenPositionButton();
		obj.closeBrowser();
	}

}
