package SystemMavenProject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

public class CRUDTestCase {
	
	public void validateEmptyFields(List<WebElement> WebElementList,WebElement triggerBtn,String type) {
		
		//Creating softAssert object
		SoftAssert softAssert = new SoftAssert();
		Iterator<WebElement> iter = WebElementList.iterator();

		while(iter.hasNext()) {
		    WebElement fieldElement = iter.next();
		    if(type == "create") {
		    	fieldElement.sendKeys();
		    }else {
		    	fieldElement.clear();
		    }
		    
		}		 
		triggerBtn.click();	
		
		while(iter.hasNext()) {
		    WebElement fieldElement = iter.next();    
		    softAssert.assertTrue(true, fieldElement.getAttribute("aria-invalid"));		    
		}
		softAssert.assertAll();
		
	}



}
