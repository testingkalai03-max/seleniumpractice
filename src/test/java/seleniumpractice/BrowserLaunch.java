package seleniumpractice;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class BrowserLaunch {
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		@Nullable
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
	WebElement country = driver.findElement(By.id("country"));
	Select s = new Select(country);
	s.selectByVisibleText("India");
	WebElement source = driver.findElement(By.xpath("//p[text()='Drag me to my target']"));
	WebElement target = driver.findElement(By.xpath("//p[text()='Drop here']"));
	Actions a= new Actions(driver);
	a.dragAndDrop(source, target).perform();
	String text = target.getText();
	if (text.contains("Dropped")) {
		System.out.println("pass");
		
	}else
	System.out.println("fail");
	
	}

}
