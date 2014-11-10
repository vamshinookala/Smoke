package basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Basic_Functional {

		WebDriver driver;
		String URL;
		Properties prop;
		Workbook workbook;
		Sheet sheet;
		
		
		
		public WebDriver getURL()
		{
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get("http://172.18.52.96/SYM");
			return driver;
		}
		
		
		
		public void loadProperties(String propertiesfilename) throws FileNotFoundException, IOException
		{
			prop=new Properties();
			prop.load(new FileInputStream("src\\main\\resources\\" + propertiesfilename+".properties"));
		}
		
		public String getProperties(String locator)
		{
			return(prop.getProperty(locator));
			
		}
		
		public void textBox(String locator, String Testdata){
			boolean find=true;
			if(locator.startsWith("//")){
				driver.findElement(By.xpath(locator)).sendKeys(Testdata);
			}
			else if(find){
				try{
					driver.findElement(By.id(locator)).sendKeys(Testdata);
				}
				catch(Exception e){
					//driver.findElement(By.id(locator)).sendKeys(Testdata);
					e.printStackTrace();
				}
			}
		}
		
		
		public void button(String locator){
			boolean find=true;
			if(locator.startsWith("//")){
				driver.findElement(By.xpath(locator)).click();
				find=false;
			}
			else if (find){
				try{
					WebElement webbutton=driver.findElement(By.id(locator));
					webbutton.click();
				}
				catch(Exception e){
					//driver.findElement(By.id(locator)).click();
					e.printStackTrace();
				}
			}
		}
		public void LoadExcel(String ExcelName) throws InvalidFormatException, FileNotFoundException, IOException
		{
			workbook= WorkbookFactory.create(new FileInputStream("src/test/resources/" + ExcelName +".xls") );
			sheet = workbook.getSheetAt(0);
		}
		
		public String getExceldata(int rowno, int colno)
		{
			Row r1=sheet.getRow(rowno);
			Cell c1=r1.getCell(colno);
			String value= c1.getStringCellValue();
			return value;
		}
		
		public void screenShot(String nameofscreenshot) throws IOException
		{
			//System.out.println("vamshi");
			 File scrnsht =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrnsht, new File("C:\\New folder\\vamshi workspace\\Smoketest\\Screenshots\\" + nameofscreenshot + ".png"));
		}
		

}
