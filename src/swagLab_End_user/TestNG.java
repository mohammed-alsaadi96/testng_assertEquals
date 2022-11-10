package swagLab_End_user;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TestNG {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\chrome driver new\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");

		String userNmae = "standard_user";
		String password = "secret_sauce";
		int expectedNumber = 6;

		driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys(userNmae);
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(password);
		driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
		String actualTitle = driver.getTitle();
		String expextedTitle = "Swag Labs";

		Assert.assertEquals(actualTitle, expextedTitle);
		Thread.sleep(5000);

		List<WebElement> dd = driver.findElements(By.className("btn"));
		for (int i = 0; i < dd.size(); i++) {
			dd.get(i).click();

		}
		Thread.sleep(3000);
		String actualNumber = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).getText();
		int actualNumberPares = Integer.parseInt(actualNumber);
		System.out.println(actualNumberPares);
		Assert.assertEquals(actualNumberPares, expectedNumber);

	}

}
