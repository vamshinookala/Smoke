package basicTest;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import basic.Basic_Functional;
import basic.Dropdown;

public class CreateDataSets {

	
	Dropdown drop=new Dropdown();
	Basic_Functional basic =new Basic_Functional();
	@Test
	public void CreateDataSets_func(WebDriver driver) throws FileNotFoundException, IOException
	{
		basic.loadProperties("Datasets");
		drop.dropdown(driver, basic.getProperties("Setup"), "Datasets");
		drop.dropdown(driver, basic.getProperties("Action"), "New DataSet");
		basic.textBox(driver, basic.getProperties("DatasetName"), "Smoke_Dataset");
		//drop.dropdown(driver, basic.getProperties("DatasetCategory"), "Capital Markets");
		driver.findElement(By.xpath("//*[@id='Content_Content_checkComboBox_I']")).click();
		driver.findElement(By.xpath("//td[text()= 'Capital Markets']")).click();
	}
}
