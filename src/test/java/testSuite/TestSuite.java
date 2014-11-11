package testSuite;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import basic.Basic_Functional;
import basicTest.EditDataSets;
import basicTest.LoginTest;

public class TestSuite {

	Basic_Functional basic =new Basic_Functional();
	WebDriver driver=basic.getURL();
@Test
public void Login() throws FileNotFoundException, InvalidFormatException, IOException
{
	LoginTest log=new LoginTest();
	log.Login(driver);
}
@Test
public void EditDataset() throws FileNotFoundException, IOException, InterruptedException
{
	Thread.sleep(5000);
	EditDataSets edit=new EditDataSets();
	edit.EditDataSets_func(driver);
}

}
