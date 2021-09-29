package com.selenium.Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium.Utilities.Exceldata;
import com.selenium.Utilities.highlighterMethod;
import com.selenium.Utilities.readProperty;
import com.selenium.Utilities.screenCapture;

public class urbanLadder {
	
	public static WebDriver driver;
	
	public urbanLadder() {
		
	}
	
	public urbanLadder(WebDriver driver) {

		urbanLadder.driver = driver;
	}

	public static void closePopup() throws Exception {
		
		WebDriverWait waitForPopup = new WebDriverWait(driver,20);
		WebElement popup = waitForPopup.until(ExpectedConditions.elementToBeClickable(By.xpath(readProperty.getKey("close_popup_Xpath"))));
		highlighterMethod.highlight(driver, popup);
		screenCapture.takeScreenShot(driver,"Closing Popup");
		popup.click();
	}
	public static void clickBookshelves() throws Exception {
		
		WebElement open = driver.findElement(By.xpath(readProperty.getKey("bookshelves_Xpath")));
		highlighterMethod.highlight(driver, open);
		screenCapture.takeScreenShot(driver,"Opening Bookshelves");
		open.click();
		//urbanLadder.closePopup();
	}
	public static void storageType( ) throws Exception {
		
		WebElement type = driver.findElement(By.xpath(readProperty.getKey("storageType_Xpath")));
		highlighterMethod.highlight(driver, type);
		//screenCapture.takeScreenShot(driver,"Selecting StorageType");
		Actions action = new Actions(driver);
		action.moveToElement(type);
		action.build().perform();
		WebElement open = driver.findElement(By.id(readProperty.getKey("open_Id")));
		highlighterMethod.highlight(driver, open);
		open.click();
		//Thread.sleep(3000);
		screenCapture.takeScreenShot(driver,"Selecting StorageType open");
	}
	public static void priceSlider() throws Exception {
		
		WebElement price = driver.findElement(By.xpath(readProperty.getKey("price_Xpath")));
		highlighterMethod.highlight(driver, price);

		Actions action = new Actions(driver);
		action.clickAndHold(price);
		Thread.sleep(2000);
		action.build().perform();
		Thread.sleep(2000);
		
		WebElement sliderA = driver.findElement(By.xpath(readProperty.getKey("slider_start_Xpath")));
		highlighterMethod.highlight(driver, sliderA);
		Actions move = new Actions(driver);
		move.dragAndDropBy(sliderA, 0, 0).click();
		move.build().perform();

		WebElement sliderB = driver.findElement(By.xpath(readProperty.getKey("slider_end_Xpath")));
		highlighterMethod.highlight(driver, sliderB);
		move.dragAndDropBy(sliderB, -214, 0).click();
		
		move.build().perform();
		screenCapture.takeScreenShot(driver,"Price range");
		Thread.sleep(2000);
	}
	public static void excludeCheckbox() throws Exception {
		
		WebElement checkBox = driver.findElement(By.id(readProperty.getKey("exclude_checkbox_Id")));
		highlighterMethod.highlight(driver, checkBox);
		checkBox.click();
		Thread.sleep(2000);
		screenCapture.takeScreenShot(driver,"Checkbox");
	}
	public static void printFirstThree() throws Exception {

		List<WebElement> names = driver.findElements(By.xpath(readProperty.getKey("names_Xpath")));
		List<WebElement> prices = driver.findElements(By.xpath(readProperty.getKey("prices_Xpath")));

		String[] name = new String[3];
		String[] price = new String[3];

		for (int i = 0; i < 3; i++) {
			name[i] = names.get(i).getText();
			price[i] = prices.get(i).getText();
			System.out.print(names.get(i).getText() + "  ");
			System.out.println(prices.get(i).getText());
			Exceldata.output1(name, price);
		}
	}
	public static void collections() throws Exception {

		WebElement collections = driver.findElement(By.xpath(readProperty.getKey("collections_Xpath")));
		//highlighterMethod.highlight(driver, collections);
		collections.click();
		try {
			Thread.sleep(500);
		} catch (Exception e) {
			e.printStackTrace();
		}

		WebElement newArrivals = driver.findElement(By.xpath(readProperty.getKey("newArrivals_Xpath")));
		//highlighterMethod.highlight(driver, newArrivals);
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(newArrivals));
		Actions action = new Actions(driver);
		action.moveToElement(newArrivals).build().perform();
		screenCapture.takeScreenShot(driver,"Collections");
	}
	public static void printOptions() throws Exception {

		List<WebElement> subMenuItems = driver.findElements(By.xpath(readProperty.getKey("newArrivalsOptions_Xpath")));
		String prodname[] = new String[20];
		for (int i = 0; i < subMenuItems.size() ; i++) {
			prodname[i] = subMenuItems.get(i).getText();
			System.out.println(subMenuItems.get(i).getText());
			Exceldata.output(prodname);
		}
	}
	public static void giftcards() throws Exception {
		
		WebElement giftCard = driver.findElement(By.linkText("Gift Cards"));
		//highlighterMethod.highlight(driver, giftCard);
		giftCard.click();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,800)", "");
		Thread.sleep(2000);
		driver.findElement(By.xpath(readProperty.getKey("birthday_Xpath"))).click();
		screenCapture.takeScreenShot(driver,"birthday");
		Thread.sleep(2000);
		
		// Customize Form
		
		driver.findElement(By.xpath(readProperty.getKey("1000Btn_Xpath"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(readProperty.getKey("5000Btn_Xpath"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(readProperty.getKey("10000Btn_Xpath"))).click();
		Thread.sleep(2000);

		WebElement amount = driver.findElement(By.id(readProperty.getKey("enter_amount_Id")));
		amount.sendKeys(readProperty.getKey("amount_inlimit"));
		Thread.sleep(2000);
		amount.clear();
		amount.sendKeys(readProperty.getKey("amount_low"));
		Thread.sleep(2000);
		amount.clear();
		amount.sendKeys(readProperty.getKey("amount_high"));
		Thread.sleep(2000);

		Select month = new Select(driver.findElement(By.xpath(readProperty.getKey("month_Xpath"))));
		Thread.sleep(2000);
		month.selectByVisibleText("Sept (2021)");
		Thread.sleep(2000);

		Select date = new Select(driver.findElement(By.xpath(readProperty.getKey("date_Xpath"))));
		Thread.sleep(2000);
		date.selectByVisibleText("29");
		Thread.sleep(5000);

		driver.findElement(By.xpath(readProperty.getKey("1000Btn_Xpath"))).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath(readProperty.getKey("nextBtn_Xpath")))
				.click();
		Thread.sleep(2000);
		
		// Recipients form
		
		driver.findElement(By.id(readProperty.getKey("recipient_name_Id"))).sendKeys(Exceldata.readData(1, 0));
		WebElement email = driver.findElement(By.id(readProperty.getKey("recipient_email_Id")));
		email.sendKeys(Exceldata.readData(1, 1));
		driver.findElement(By.id(readProperty.getKey("name_Id"))).sendKeys(Exceldata.readData(1, 2));
		driver.findElement(By.id(readProperty.getKey("email_Id"))).sendKeys(Exceldata.readData(1, 3));
		//String number= (String)Exceldata.readData(1, 4);
		driver.findElement(By.id(readProperty.getKey("mobile_Id"))).sendKeys(readProperty.getKey("number"));
		driver.findElement(By.xpath(readProperty.getKey("confirm_Xpath"))).click();
		screenCapture.takeScreenShot(driver,"Error in email");
		Thread.sleep(2000);
	}
}
