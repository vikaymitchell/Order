package com.weborder;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Order {

	
	public static void main(String[] args) throws InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\Vika\\Documents\\selenium dependencies\\driver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
	
		Thread.sleep(2000);
		
		driver.findElement(By.name("ctl00$MainContent$username")).sendKeys("Tester");
		
		driver.findElement(By.name("ctl00$MainContent$password")).sendKeys("test");
	
		driver.findElement(By.name("ctl00$MainContent$login_button")).click();
		
		driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/weborders/Process.aspx");
		
		//quantity
		Random random = new Random();
		int i = random.nextInt(100)+1;
		String f = "" + i;
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtQuantity")).sendKeys(f);
		
		//name
		int leftLimit = 97; // letter 'a'
	    int rightLimit = 122; // letter 'z'
	    int targetStringLength = 5;
	    Random random2 = new Random();
	    StringBuilder buffer = new StringBuilder(targetStringLength);
	    for (int z = 0; z < targetStringLength; z++) {
	        int randomLimitedInt = leftLimit + (int) 
	          (random2.nextFloat() * (rightLimit - leftLimit + 1));
	        buffer.append((char) randomLimitedInt);
	    }
	    String generatedString = buffer.toString();
	
	driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtName")).sendKeys("John " + generatedString + " Smith");
	
		//address
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2")).sendKeys("123 Any st");
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3")).sendKeys("Anytown");
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4")).sendKeys("Virginia");
        
        //zip
        Random random1 = new Random();
		int y = random1.nextInt(99999);
		String n = "" + y;
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox5")).sendKeys(n);
		
		
		//card name and  number
		int z = random.nextInt(3)+1;
		
		if(z==1) {
			driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_0")).click();
			Random random3 = new Random();
			Random random4 = new Random();
			int a = random3.nextInt(9999999);
	        int b = random4.nextInt(99999999);
			driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6")).sendKeys(4 + "" + a + b);
		}else if(z==2) {
			driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_1")).click();
			Random random3 = new Random();
			Random random4 = new Random();
			int a = random3.nextInt(9999999);
	        int b = random4.nextInt(99999999);
			driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6")).sendKeys(5 + "" + a + b );
		}else if (z==3){
			driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_2")).click();
			Random random3 = new Random();
			Random random4 = new Random();
			int a = random3.nextInt(9999999);
	        int b = random4.nextInt(9999999);
			driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6")).sendKeys(3 + "" + a + b);
		}
//		Enter any card number. If you selected Visa, card number should start with 4. 
//		If you selected Master, card number should start with 5. If you selected American Express, 
//		card number should start with 3. New card number should be auto generated every time you run the test.
//		Card numbers should be 16 digits for Visa and Master, 15 for American Express.
		
		//date
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox1")).sendKeys("08/21");
		
		//click Process
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton")).click();
		
		//End
		
		String expected = "New order has been successfully added.";
        String text = driver.findElement(By.tagName("body")).getText();
        if (text.contains(expected)) {
            System.out.println("pass");
        } else {
            System.out.println("fail");
            System.out.println("Expected:\t" + expected);
        }
	}
	
}
