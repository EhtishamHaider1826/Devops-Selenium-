package ui;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SendingMail {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://mail.google.com/");
		driver.findElement(By.id("identifierId")).sendKeys("ehtishamtesting@gmail.com");
		driver.findElement(By.xpath("//div[@id='identifierNext']")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")));
		driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys("qwerty@12345");
		driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/div/button")).click();

		WebDriverWait waiting = new WebDriverWait(driver, Duration.ofSeconds(10));
		waiting.until(ExpectedConditions.titleContains("Inbox"));
		WebElement composeButton = driver
				.findElement(By.xpath("/html/body/div[7]/div[3]/div/div[2]/div[1]/div[1]/div/div"));
		composeButton.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id=':cd']")));

		// Find the recipient field and enter the email address of the recipient
		WebElement recipientField = driver.findElement(By.xpath("//input[@id=':cd']"));
		recipientField.sendKeys("ehtishamhaider.987@gmail.com");
		
		WebElement subjectField = driver.findElement(By.name("subjectbox"));
		  subjectField.sendKeys("Test Email");

		  
		  driver.findElement(By.cssSelector(".Am.Al.editable.LW-avf")).sendKeys("This is a test email.");

		  // Click the "Send" button to send the email
		  driver.findElement(By.cssSelector(".T-I.J-J5-Ji.aoO.T-I-atl.L3")).click();

		  // Wait for the page to load and verify that the email was sent successfully
		  (new WebDriverWait(driver,Duration.ofSeconds(20))).until(ExpectedConditions.titleContains("Sent Mail"));
		  
		}
	}


