package com.bank.testcases;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.bank.properties.*;

import com.bank.base.*;


public class Bankmanger extends Baseclass{
	@Test
	public void LoginAsBankManager() throws InterruptedException {
		 driver.manage().timeouts().implicitlyWait(Constant_info.waittime, TimeUnit.SECONDS);
		 
		driver.findElement(By.xpath(Constant_info.bmlg)).click();
		log.debug("clicked on login button");
		//System.out.println("button clicked successfully");
		log.debug("button clicked successfull");
		
	}
	

}
