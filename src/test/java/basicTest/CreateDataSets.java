package basicTest;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import basic.Basic_Functional;
import basic.Dropdown;

public class CreateDataSets {

	
	Dropdown drop=new Dropdown();
	Basic_Functional basic =new Basic_Functional();
	
	@Test
	public void CreateDataSets_func(WebDriver driver) throws FileNotFoundException, IOException, InterruptedException
	{
		basic.loadProperties("Datasets");
		drop.dropdown(driver, basic.getProperties("Setup"), "Datasets");
		drop.dropdown(driver, basic.getProperties("Action"), "New DataSet");
		basic.textBox(driver, basic.getProperties("DatasetName"), "s9");
		 driver.findElement(By.id("Content_Content_checkComboBox_I")).click();
		 List<WebElement> cbox=driver.findElements(By.cssSelector("span[id^='Content_Content_checkComboBox_DDD_DatasetCategoryTreeList']"));
	     cbox.get(0).click();
	     basic.Checkbox(driver, basic.getProperties("EnableInputForm"));
	     drop.dropdown(driver, basic.getProperties("EnableAEIntegration"), "Enabled - single record per entity");
	     Thread.sleep(1000);
	    basic.textBox(driver, basic.getProperties("Field"), "Integer1");
	    drop.dropdown(driver, basic.getProperties("Datatype"), "Integer (exact numbers)");
	    basic.button(driver, basic.getProperties("SaveData"));
	    Thread.sleep(1000);
	    basic.button(driver, basic.getProperties("Save"));
	    Alert al=driver.switchTo().alert();
	    al.accept();
	  WebElement w= driver.findElement(By.id("Content_Content_SuccessMessageLabel"));
	  String cs= w.getAttribute("Class");
	  String color=w.getAttribute("style");
	  System.out.println("cs     "+ cs + "          color                 "+ color);
	  //w.click();
	  String s= w.getAttribute("innerHTML");
	  String s1=w.getText();
	  String s2= w.getAttribute("value");
	  
	  JavascriptExecutor executor = (JavascriptExecutor)driver;
		String s7= (String)executor.executeScript("document.getElementById('Content_Content_SuccessMessageLabel').textContent");
	  //String s3= w.t
	  System.out.println("InnerHTML     " +s +           "GetText    "+s1+       " Value    "+s2);
	  System.out.println("sdkfjcskldjflksjdfkljsad;flj      "+ s7);
	  
	  String s8= (String)executor.executeScript("document.getElementById('Content_Content_SuccessMessageLabel').innerText");
	  System.out.println("TExtText    "+ s8);
	  
	  if(driver.findElement(By.id("Content_Content_SuccessMessageLabel")).getText().contains("Dataset has been saved successfully"))
	  {
		  System.out.println("Success");
	  }
	 /* WebElement w1= driver.findElement(By.id("pane4"));
	  String s5=w1.getAttribute("innerHTML");
	  System.out.println("blahahahahahah      "+ s5);*/
	    //Assert.assertEquals(s, "Dataset has been saved successfully");
	    //basic.screenShot(driver, "Create_dataset");
	}
}
