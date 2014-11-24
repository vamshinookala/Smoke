package basicTest;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import basic.Basic_Functional;
import basic.Dropdown;

public class EditDataSets {

	
	Dropdown drop=new Dropdown();
	Basic_Functional basic =new Basic_Functional();
	@Test
	public void EditDataSets_func(WebDriver driver) throws FileNotFoundException, IOException
	{
		basic.loadProperties("Dropdown");
		drop.dropdown(driver, basic.getProperties("Setup"), "Datasets");
	}
}
