package Contol;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;
import java.util.Comparator;

public class ContolDemo {
public static void main(String[] args) {
// Set the path for the WebDriver
System.setProperty("webdriver.chrome.driver", "path/to/chromedriver"); // Update with your path
WebDriver driver = new ChromeDriver();
driver.get("https://www.amazon.in");

// Step 2: Search for "LG soundbar"
WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
searchBox.sendKeys("lg soundbar");
searchBox.submit();

// Step 3: Read product names and associated main prices
List<WebElement> productNames = driver.findElements(By.cssSelector(".s-title-instructions-style"));
List<WebElement> productPrices = driver.findElements(By.cssSelector(".a-price-whole"));
Map productMap = new HashMap<>();
for (int i = 0; i < productNames.size(); i++) {
String productName = productNames.get(i).getText();
String priceText = i < productPrices.size() ? productPrices.get(i).getText() : "0";
int price = priceText.isEmpty() ? 0 : Integer.parseInt(priceText.replaceAll(",", ""));
productMap.put(productName, price);
}

// Step 5: Sort via price
List<map.entry> sortedProducts = new ArrayList<>(productMap.entrySet());
Collections.sort(sortedProducts, Comparator.comparingInt(Map.Entry::getValue));

// Step 6: Print sorted products
for (Map.Entry entry : sortedProducts) {
System.out.println(entry.getValue() + " " + entry.getKey());
}

// Close the browser
driver.quit();
}
}




