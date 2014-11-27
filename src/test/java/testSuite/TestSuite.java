package testSuite;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import basic.Basic_Functional;
import basicTest.CreateDataSets;

import basicTest.LoginTest;

public class TestSuite {

	Basic_Functional basic =new Basic_Functional();
	WebDriver driver=basic.getURL();
@Test(priority=1)
public void Login() throws FileNotFoundException, InvalidFormatException, IOException
{
	LoginTest log=new LoginTest();
	log.Login(driver);
}
@Test(priority=2)
public void CreateDataSet() throws FileNotFoundException, IOException, InterruptedException
{
	Thread.sleep(5000);
	CreateDataSets edit=new CreateDataSets();
	edit.CreateDataSets_func(driver);
}

}
