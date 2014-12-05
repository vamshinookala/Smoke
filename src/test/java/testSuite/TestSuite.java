package testSuite;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import basic.Basic_Functional;
import basicTest.CreateDataSets;
import basicTest.CreateDatasetFromFile;
import basicTest.LoginTest;
import basicTest.NewInputForm;
import basicTest.dataconnectorTest;

public class TestSuite {

	Basic_Functional basic =new Basic_Functional();
	WebDriver driver=basic.getURL();
@Test(priority=1)
public void Login() throws FileNotFoundException, InvalidFormatException, IOException
{
	LoginTest log=new LoginTest();
	log.Login(driver);
}
/*@Test(priority=2)
public void CreateDataSet() throws FileNotFoundException, IOException, InterruptedException
{
	Thread.sleep(5000);
	CreateDataSets edit=new CreateDataSets();
	edit.CreateDataSets_func(driver);
}
@Test(priority=2)
public void CreateDatasetfromfile() throws FileNotFoundException, IOException, InterruptedException
{
	Thread.sleep(500);
	CreateDatasetFromFile createfile=new CreateDatasetFromFile();
	createfile.CreateDataSetsFile(driver);
}
*/
/*@Test(priority=2)
public void NewDataset() throws FileNotFoundException, IOException, InterruptedException
{
	NewInputForm inputform=new NewInputForm();
	inputform.CreateNewInputForm(driver);
	
}*/
@Test(priority=2)
public void createdataconnector() throws FileNotFoundException, IOException, InterruptedException
{
	dataconnectorTest d=new dataconnectorTest();
	d.dataconnector_func(driver);
	
}

}