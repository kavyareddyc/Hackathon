package com.selenium.Utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class highlighterMethod {
	
	public static void highlight(WebDriver driver, WebElement element) {

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].setAttribute('style', 'background: DeepSkyBlue; border: 2px solid Black;');", element);
			//js.executeScript("arguments[0].setAttribute('style', arguments[1]);",element, "color: Yellow; border: 2px dotted solid green;");
			//js.executeScript("arguments[0].setAttribute('style', arguments[1]);",element, "");
			//js.executeScript("arguments[0].style.border='2px groove green'", element);
			//js.executeScript("arguments[0].setAttribute('style', arguments[1]);",element, "color: Black; border: 2px groove green;");
	}
}
