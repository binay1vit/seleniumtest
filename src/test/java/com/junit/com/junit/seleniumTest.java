package com.junit.com.junit;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class seleniumTest {
	@Test
	public void tablePractise() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\workspace\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.seleniumeasy.com/test/table-sort-search-demo.html");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		WebElement oTable = driver.findElement(By.id("example"));
		System.out.println(getRowCount(oTable));
		//System.out.println(getColumnCount(oTable,1));
		//printAllDatainRow(oTable,0);
		System.out.println(getCellData(oTable,3,3));
		driver.quit();
	}
	
	public int getRowCount(WebElement table) {
		int rowCount = table.findElements(By.xpath("./tbody/tr")).size();
		return rowCount;
	}
	public int getColumnCount(WebElement table,int row) {
		List<WebElement> rowEle = table.findElements(By.xpath("./tbody/tr"));
		List<WebElement> colEle = rowEle.get(row).findElements(By.tagName("td"));
		return colEle.size();
	}
	public String getCellData(WebElement table,int row,int col) {
		List<WebElement> rowEle = table.findElements(By.xpath("./tbody/tr"));
		List<WebElement> colEle = rowEle.get(row-1).findElements(By.tagName("td"));
		return colEle.get(col-1).getText();	
	}
	public void printAllDatainRow(WebElement table,int row) {
		List<WebElement> rowEle = table.findElements(By.xpath("./tbody/tr"));
		List<WebElement> colEle = rowEle.get(row-1).findElements(By.tagName("td"));
		for(int i=0;i<colEle.size();i++) {
			System.out.println(colEle.get(i).getText());
		}
	}
}
