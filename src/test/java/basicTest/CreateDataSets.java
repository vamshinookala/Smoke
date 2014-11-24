package basicTest;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
		basic.textBox(driver, basic.getProperties("DatasetName"), "Smoke_Dataset");
		//drop.dropdown(driver, basic.getProperties("DatasetCategory"), "Capital Markets");
		/*driver.findElement(By.xpath("//*[@id='Content_Content_checkComboBox_I']")).click();
		driver.findElement(By.xpath("//td[text()= 'Capital Markets']")).click();*/
		 driver.findElement(By.id("Content_Content_checkComboBox_I")).click();
		 List<WebElement> cbox=driver.findElements(By.cssSelector("span[id^='Content_Content_checkComboBox_DDD_DatasetCategoryTreeList']"));
	     cbox.get(0).click();
	     basic.Checkbox(driver, basic.getProperties("EnableInputForm"));
	     drop.dropdown(driver, basic.getProperties("EnableAEIntegration"), "Enabled - single record per entity");
	     Thread.sleep(1000);
	    basic.textBox(driver, basic.getProperties("Field"), "Integer1");
	    drop.dropdown(driver, basic.getProperties("Datatype"), "Integer (exact numbers)");
	    basic.button(driver, basic.getProperties("Save"));
	}
}
