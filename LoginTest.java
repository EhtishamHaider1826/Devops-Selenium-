package ui;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://mail.google.com/");
		driver.findElement(By.id("identifierId")).sendKeys("ehtishamtesting@gmail.com");
		driver.findElement(By.xpath("//div[@id='identifierNext']")).click();

		// send password
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")));
		driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys("qwerty@12345");
		driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/div/button")).click();

		wait.until(ExpectedConditions.titleContains("Inbox"));
		driver.quit();
	}

}
