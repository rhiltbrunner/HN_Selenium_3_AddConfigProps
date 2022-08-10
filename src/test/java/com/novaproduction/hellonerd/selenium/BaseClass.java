package com.novaproduction.hellonerd.selenium;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.WebDriver;

/**
 * there are 3 browsertypes:
 * <li>BROWSER_CHROME</li>
 * <li>BROWSER_FIREFOX</li>
 * <li>BROWSER_EDGE</li>
 * 
 * The default browsertype is BROWSER_CHROME.
 * 
 * @author renat
 *
 */
public abstract class BaseClass {
	public WebDriver wDriver;
	
    public WebDriver startup() {
    	try {
    		wDriver = DetectingDriver.getDriver();
    		if(wDriver != null) {
    			MyLogger.info("driver successfully found.");
    			return wDriver;    			
    		}
    	}catch(Exception ex) {
    		MyLogger.error(ex.getMessage());
    	}
    	return null;
    }
    
	@AfterEach
    public void teardown() {
        if (wDriver != null) {
        	wDriver.quit();
        }
    }
    
    @AfterAll
    public static void afterall() {
       // save log file
    }
}