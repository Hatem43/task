package org.example;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public WebDriver driver;

    @BeforeTest
    public void launchbrowser() {
        System.out.println("launching browser");
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    @Parameters({"sourcedepartment","destinationdepartment","passengername","age","icard"})
    public void bookbusticket(String sourcedepartment,String destinationdepartment ,String passengername,String age,String icard) throws InterruptedException {

        driver.get("https://ksrtc.in/");
        WebElement sourcedepart=driver.findElement(By.xpath("//*[@id=\"frmSearch\"]/div/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]"));
        sourcedepart.click();
        WebElement sourcedeptvalue= driver.findElement(By.xpath("//*[@id=\"fromCity_chosen\"]/div/div[1]/input"));
        sourcedeptvalue.sendKeys(sourcedepartment);
        List<WebElement> sourcedepartresults=driver.findElements(By.xpath("//*[@id=\"fromCity_chosen\"]/div/ul"));
        WebElement sourcedept=sourcedepartresults.getFirst();
        sourcedept.click();
        driver.findElement(By.xpath("//*[@id=\"toCity_chosen\"]/a")).click();
        WebElement destdept= driver.findElement(By.xpath("//*[@id=\"toCity_chosen\"]/div/div[1]/input"));
        destdept.sendKeys(destinationdepartment);
        List<WebElement> destdepartresults=driver.findElements(By.xpath("//*[@id=\"toCity_chosen\"]/div/ul"));
        WebElement destdepart=destdepartresults.getFirst();
        destdepart.click();
        WebElement dateselector=driver.findElement(By.xpath("//*[@id=\"imgDepartDate\"]"));
        dateselector.click();
        WebElement datepicker=driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]"));
        WebElement arrivaldatepicker= driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/table/tbody/tr[4]/td[7]/a"));
        arrivaldatepicker.click();
        WebElement searchbutton= driver.findElement(By.xpath("//*[@id=\"submitSearch\"]"));
        searchbutton.click();
        WebElement selectseat = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/div[2]/div[1]/div/div/div[5]/div[7]/div"));
        selectseat.click();
        driver.manage ().timeouts ().implicitlyWait (5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//div[@class='seatlook'][11]")).click();
        WebElement boardingpointbutton= driver.findElement(By.xpath("//div[@class='point-inp flex-vc'][1]"));
        boardingpointbutton.click();
        WebElement boardingpointvalue= driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/div[2]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[3]/div/div[1]"));
        boardingpointvalue.click();
        WebElement droppingpointbutton= driver.findElement(By.xpath("//div[@class='picklabel']"));
        droppingpointbutton.click();
        WebElement droppingpointvalue=driver.findElement(By.xpath("//div[@class='col-time']"));
        droppingpointvalue.click();
        WebElement customerdetails=driver.findElement(By.xpath("//div[@class='btnPassDetails']"));
        customerdetails.click();
        WebElement countrycode=driver.findElement(By.xpath("//input[@name='password']"));
        countrycode.click();
        WebElement countrycodevalue=driver.findElement(By.xpath("//input[@name='countrycode'][1]"));
        countrycodevalue.click();
        WebElement mobilephone=driver.findElement(By.xpath("//input[@name='mobileNo']"));
        mobilephone.sendKeys("6789125987");
        WebElement EmailID=driver.findElement(By.xpath("//input[@name='email']"));
        EmailID.sendKeys("hatemmadouh22@gmail.com");
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(20));
        WebElement passengerdetailspage=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='navswitchbtn flex-all-c']")));
        String passenger=passengerdetailspage.getText();
        System.out.println(passenger);
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", passengerdetailspage);
        WebElement name=driver.findElement(By.xpath("//input[@name='paxName[0]']"));
        name.sendKeys(passengername);
        WebElement gendervalueselect=driver.findElement(By.xpath("//input[@name='paxGender[0]']"));
        gendervalueselect.click();
        WebElement gendervalue=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/div[2]/div[1]/div[2]/div[4]/section/div/div[2]/div[2]/div[1]/div[2]/div[3]/div/div[1]/div"));
        gendervalue.click();
        WebElement Agevalue=driver.findElement(By.xpath("//input[@name='paxAge[0]']"));
        Agevalue.sendKeys(age);
        WebElement concessionvalueselect=driver.findElement(By.xpath("//input[@name='paxConcessionType[0]']"));
        concessionvalueselect.click();
        WebElement concessionvalue=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/div[2]/div[1]/div[2]/div[4]/section/div/div[2]/div[2]/div[1]/div[2]/div[5]/div/div/div"));
        concessionvalue.click();
        WebElement idcardtypeselect =driver.findElement(By.xpath("//input[@name='paxIDCardType[0]']"));
        idcardtypeselect.click();
        WebElement idcardtypevalue=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/div[2]/div[1]/div[2]/div[4]/section/div/div[2]/div[2]/div[1]/div[2]/div[6]/div/div[2]/div"));
        idcardtypevalue.click();
        WebElement idcardvalue= driver.findElement(By.xpath("//input[@name='paxIDCardNo[0]']"));
        idcardvalue.sendKeys(icard);
        WebElement countryvalueselect=driver.findElement(By.xpath("//input[@name='paxNationality[0]']"));
        countryvalueselect.click();
        WebElement countryvalue=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/div[2]/div[1]/div[2]/div[4]/section/div/div[2]/div[2]/div[1]/div[2]/div[8]/div/div[76]/div"));
        countryvalue.click();
        WebElement checkout=driver.findElement(By.xpath("//div[@class='navswitchbtn flex-all-c']"));
        JavascriptExecutor jes=(JavascriptExecutor) driver;
        jes.executeScript("arguments[0].click();",checkout);
        Thread.sleep(3000);
    }
}