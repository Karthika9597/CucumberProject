package baseclass;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class BaseClass {

	public static WebDriver driver;
	public static WebElement element;
	public static Select s;
	//public static String value;
	static Object[][] twoDimArray=null;
	static Object value="";

	public static void selectingBrowser(String browser_name){
		if(browser_name == "chrome") {
			//System.setProperty("webdriver.chrome.driver", "C:\\Users\\karth\\eclipse-workspace\\SAMPLE\\driver\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options);
			
		}
		else if(browser_name == "gecko") {
			//System.setProperty("webdriver.gecko.driver", "C:\\Users\\karth\\eclipse-workspace\\SAMPLE\\driver\\chromedriver.exe");
			driver = new FirefoxDriver();
			
			}
		else if(browser_name == "edge") {
			//System.setProperty("webdriver.gecko.driver", "C:\\Users\\karth\\eclipse-workspace\\SAMPLE\\driver\\chromedriver.exe");
			driver = new EdgeDriver();
			
		}		
		driver.manage().window().maximize();
			
		 
	}
 
	public static String launching(String url) {
		driver.get(url);
		return url;
	}

	public static void resizing() {
		driver.manage().window().maximize();
	}

	public static WebElement findElementBy(By by) {
		
			WebElement element = driver.findElement(by);
			return element;
		
		}

	public static WebElement findElementbyId(String id) {
		try {
			WebElement element = driver.findElement(By.id(id));
			return element;
		} catch (Exception e) {
			System.out.println("Error :" + e);
		}
		return element;
	}

	public static WebElement findElementbyName(String name) {
		try {
			WebElement element = driver.findElement(By.name(name));
			return element;
		} catch (Exception e) {
			System.out.println("Error :" + e);
		}
		return element;
	}
	public static String getTitle() {
		return driver.getTitle();
	}


	public static WebElement findElementbyXpath(String xpath) {
		try {
			WebElement element = driver.findElement(By.xpath(xpath));
			return element;
		} catch (Exception e) {
			System.out.println("Error :" + e);
		}
		return element;
	}

	public static void clickbutton(WebElement element) {
		element.click();

	}

	public static void clearButton(WebElement element) {
		element.clear();
	}

	public static String send_keys(WebElement element, String string) {
		element.sendKeys(string);
		return string;

	}

	public static Select dropDownoptions(WebElement element) {
		s = new Select(element);
		return s;

	}

	public static void selectByvisibletext(String text) {
		s.selectByVisibleText(text);
	}

	public static void selectByIndex(int index) {
		s.selectByIndex(index);
	}

	public static void waits(int secs) {
		driver.manage().timeouts().implicitlyWait(secs, TimeUnit.MILLISECONDS);

	}

	public static String getAttribute(WebElement orderNum_element) {

		return orderNum_element.getAttribute("value");

	}

	public static String propReader(String key) {
		String location="C:\\Users\\karth\\eclipse-workspace\\Cucumberdemo\\src\\test\\resources\\property.txt";
		String value = "";
		try {
			FileReader read = new FileReader(location);
			Properties prop = new Properties();
			prop.load(read);
			value = prop.getProperty(key);

		} catch (FileNotFoundException e) {
 
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		return value;

	}

	public static Object readAllValues(int r, int c, String sh) {
		try {
			File f = new File("C:\\Users\\karth\\eclipse-workspace\\Mavenproj\\src\\test\\resources\\Hotel12.xlsx\\");

			FileInputStream fis = new FileInputStream(f);
			Workbook wb = new XSSFWorkbook(fis);
			Sheet sheet = wb.getSheet("Sheet2");
			Row row = sheet.getRow(r);
			Cell cell = row.getCell(c);
			int cellType = cell.getCellType();
			if (cellType == 1) {
				value = cell.getStringCellValue();
				System.out.println(value);
			} else if (cellType == 0) {
				if (DateUtil.isCellDateFormatted(cell)) {
					Date datecell = cell.getDateCellValue();
					SimpleDateFormat sc = new SimpleDateFormat("dd/MM/yyyy");
					value = sc.format(datecell);
					System.out.println(value);
				} else {
					double numcell = cell.getNumericCellValue();
					long a = (long) numcell;
					value = String.valueOf(a);
				}
			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

		return value;
	}

	public static void excelWrite(int r,int c,String data, String sh) {

		try {
			File f = new File("C:\\Users\\karth\\eclipse-workspace\\Mavenproj\\src\\test\\resources\\Hotel12.xlsx");
			FileInputStream fis = new FileInputStream(f);
			Workbook wb = new XSSFWorkbook(fis);
			Sheet wsh = wb.createSheet(sh);
			Row wr = wsh.createRow(r);
			Cell wc = wr.createCell(c);
			wc.setCellValue(data);

			FileOutputStream fos = new FileOutputStream(f);
			wb.write(fos);
			wb.close();
			System.out.println("created");
			
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
	
	//Methods for 2-D array to be used for DataProvider
	public static Object[][] covertExcelToTwoDimenArray()
	{	
		
		try {
			File f=new File("C:\\Users\\karth\\eclipse-workspace\\Mavenproj\\src\\test\\resources\\Hotel12.xlsx");
			FileInputStream input=new FileInputStream(f);
			Workbook workbook = new XSSFWorkbook(input);
			Sheet sh=workbook.getSheet("HotelSearch");
			int totalNumberOfRows=sh.getPhysicalNumberOfRows();
			int totalNumberOfCells=sh.getRow(0).getPhysicalNumberOfCells();
			
			twoDimArray= new Object[totalNumberOfRows-1][totalNumberOfCells];// if not done, u will get null pointer exception
			
			for(int i =1;i<totalNumberOfRows;i++)
			{
				Row row=sh.getRow(i);
				for (int j =0;j<totalNumberOfCells;j++)
				{
					Cell cell= row.getCell(j);
					int cellType=cell.getCellType();
					if(cellType==1)
					{
						value=cell.getStringCellValue();
					}
					else if(cellType==0)
					{
						if(DateUtil.isCellDateFormatted(cell))
						{
							Date dateCellValue=cell.getDateCellValue();
							SimpleDateFormat sc=new SimpleDateFormat("dd-MM-yyyy");
							value=sc.format(dateCellValue);
						}
						else
						{
							double numericCellValue=cell.getNumericCellValue();
							long l=(long)numericCellValue;
							value=String.valueOf(l);
						}
					}
					twoDimArray[i-1][j]=value;			
					
				}
			}			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return twoDimArray;
		
	}
	
	public static void printTwoDImArray(Object[][] convertToArray)
	{
		for(int i=0;i<convertToArray.length;i++)
		{
			for (int j=0;j<convertToArray[i].length;j++)
			{
				System.out.print(convertToArray[i][j]+ " ");
			}
			System.out.println();
		}
	}
	



public static WebElement findElementById(String id) {
		try {
			return driver.findElement(By.id(id));
		} catch (Exception e) {
			System.out.println("Error:" + e);
		}
		return element;
	}
	

public static WebElement findElementById1(String id) {
	  try {
	   return driver.findElement(By.id(id));
	  } catch (Exception e) {
	   System.out.println("Error:" + e);
	  }
	  return element;
	 }
		
	 public static WebElement findElementbyId(By byObj) {
	  try {
	   return driver.findElement(byObj); 
	     
	  }catch(Exception e) {
	   System.out.println("Error :"+e);
	  }
	         return element;
	 }}