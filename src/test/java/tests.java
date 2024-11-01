import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class tests {
WebDriver driver;

    @Test(dataProvider = "readExcelforLoginCredential")
    public void login(String arg1,String arg2) throws Exception{
        driver=new ChromeDriver();
		driver.get("https://freelance-learn-automation.vercel.app/login");
		driver.findElement(By.id("email1")).sendKeys(arg1);
		driver.findElement(By.id("password1")).sendKeys(arg2);
		Thread.sleep(2000);
		driver.quit();
    }



    @DataProvider(name="readExcelforLoginCredential")
    public Object [][] readExcelforLoginCredential() throws IOException
    {
        //File file=new File(".\\Data\\data.xlsx");
        File file=new File(System.getProperty("user.dir")+"\\Data\\data.xlsx");
        FileInputStream fis=new FileInputStream(file);
        XSSFWorkbook wb=new XSSFWorkbook(fis);

        Object arr[][]=new Object[1][2];
        arr[0][0]=wb.getSheetAt(0).getRow(0).getCell(0).toString();
        arr[0][1]=wb.getSheetAt(0).getRow(0).getCell(1).toString();
        System.out.println(arr[0][0]);
        System.out.println(arr[0][1]);

        return arr;
    }
    
}
