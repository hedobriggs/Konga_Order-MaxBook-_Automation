package User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class KongaTest {
    //import selenium WebDriver
    private WebDriver driver;

    @BeforeClass
    public void setUp() throws InterruptedException {

        //fetch the chromedriver.exe file
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");

        //launch the chromedriver.exe file
        driver = new ChromeDriver();

        //input the website URL
        driver.get("https://www.konga.com/");

        //Wait for the page to load in 5 seconds
        Thread.sleep(5000);

        //Maximize the browser
        driver.manage().window().fullscreen();

        //Get Page title
        System.out.println(driver.getTitle());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void LoginTest() throws InterruptedException {
        //Click on the Login/Signup tab
        driver.findElement(By.linkText("Login / Signup")).click();

        //Click on the Email Address/ Phone number field and enter "tochokere@gmail.com"
        driver.findElement(By.id("username")).sendKeys("tochokere@gmail.com");

        //Click on the Password field and input a valid password "Excellent101"
        driver.findElement(By.id("password")).sendKeys("Excellent101");

        //Click on the Login button
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();

        Thread.sleep(10000);
        if (driver.getCurrentUrl().contains("https://www.konga.com/")) {
            System.out.println("PASSED - User has successfully logged in");
        } else {
            System.out.println("FAILED - The user was unable to login");
        }
        Thread.sleep(10000);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //On Categories click on "Computer and Accessories"
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[3]/nav/div[3]/div/a[2]")).click();
        Thread.sleep(10000);


        //Click on Laptops
       driver.findElement(By.linkText("Laptops")).click();
       Thread.sleep(10000);

        //Click on Apple MacBook
        driver.findElement(By.linkText("Apple MacBooks")).click();
        Thread.sleep(10000);

        //Add Macbook Laptop to cart
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[2]/section/section/section/section/ul/li[17]/div/div/div[2]/form/div[4]/button")).click();
        Thread.sleep(10000);

        //Click on Cart
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/nav/div[2]/div/div/a[2]")).click();
        Thread.sleep(10000);

        //Click on Checkout
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[3]/section/section/aside/div[3]/div/div[2]/button")).click();
        Thread.sleep(15000);

        //Change Address
        driver.findElement(By.linkText("Change Address")).click();
        Thread.sleep(15000);

        //Add Address
        driver.findElement(By.linkText("Add Address")).click();
        Thread.sleep(15000);

        driver.findElement(By.id("firstname")).sendKeys("Francis");
        driver.findElement(By.id("lastname")).sendKeys("Amos");
        driver.findElement(By.id("telephone")).sendKeys("08127133581");
        driver.findElement(By.id("street")).sendKeys("7,Aguleri Street, off Abanishe street.");
        driver.findElement(By.id("landmark")).sendKeys("The large house");
        driver.findElement(By.id("city")).sendKeys("Egbe");

        //Select the drop down for State
        Select dropdown = new Select(driver.findElement(By.name("regionId")));
        Thread.sleep(5000);

        //Select drop down for LGA
        dropdown.selectByVisibleText("Lagos");
        Thread.sleep(5000);

        dropdown = new Select(driver.findElement(By.name("areaId")));
        Thread.sleep(10000);

        dropdown.selectByVisibleText("Shomolu");
        Thread.sleep(10000);


        //Save the address created
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/section/aside/div[2]/div/div/form/div[9]/div[1]/button")).click();
        Thread.sleep(10000);

        //Use the address created
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/section/aside/div[3]/div/div/div/a")).click();
        Thread.sleep(10000);


        //Select the Pay Now Option
        driver.findElement(By.cssSelector("main#mainContent>form>div>section>div>div:nth-of-type(4)>form>ul>li>div>button")).click();
        Thread.sleep(10000);

        //click on continue to payment
        driver.findElement(By.cssSelector("main#mainContent>form>div>section>div>div:nth-of-type(8)>div>button")).click();
        Thread.sleep(10000);

        //Enter card details

        driver.findElement(By.id("card-number")).sendKeys("4444657071239899");

        driver.findElement(By.id("expiry")).sendKeys("01/23");

        driver.findElement(By.id("cvv")).sendKeys("656");

        driver.findElement(By.id("validateCardForm")).click();

        Thread.sleep(5000);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        System.out.println(driver.findElement(By.xpath("//label[@id='card-number_unhappy']")).getText());



    }

    @AfterTest
    public void QuitBrowser(){driver.quit();}
}

