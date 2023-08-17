package Stepdef;

//import com.sun.org.apache.bcel.internal.generic.ATHROW;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
//import javax.xml.bind.Element;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;



public class PurchaseProduct {
    WebDriver driver;
    static WebDriverWait wait;
    private By webDriver;

    @Given("user Open browser")
    public void iOpenBrowser() {
        final String dir = System.getProperty("user.dir");
        System.out.println("current dir = " + dir);
        System.setProperty("webdriver.chrome.driver", dir + "/driver/chromedriver.exe");
        //System.setProperty("webdriver.gecko.driver", dir + "/driver/geckodriver");
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @And("user go Demo Midtrans website")
    public void goToMidtransWebsite() throws InterruptedException {
        driver.get("https://demo.midtrans.com/");
    }

    @And("user choose {string} product")
    public void chooseProduct(String value) throws InterruptedException {
        driver.findElement(By.xpath("//div[contains(text(),'" + value + "')]")).isDisplayed();
    }

    @And("user click {string} button")
    public void clickBuyNowButton(String value1) throws InterruptedException {
        driver.findElement(By.xpath("//a[.='" + value1 + "']")).isDisplayed();
        driver.findElement(By.xpath("//a[.='" + value1 + "']")).click();
    }

    @And("user fills the data in Shopping Cart")
    public void fillDataShoppingCart() {
        driver.findElement(By.xpath("//span[contains(text(),'Shopping Cart')]")).isDisplayed();
        //Fills price product
        driver.findElement(By.xpath("//input[@class='text-right']")).clear();
        driver.findElement(By.xpath("//input[@class='text-right']")).sendKeys("20000");

        //Fills name user
        driver.findElement(By.xpath("//td[contains(@class,'input-label') and text()='Name']/following-sibling::*/input")).clear();
        driver.findElement(By.xpath("//td[contains(@class,'input-label') and text()='Name']/following-sibling::*/input")).sendKeys("Tio");

        //Fills email user
        driver.findElement(By.xpath("//td[contains(@class, 'input-label') and text()='Email']/following-sibling::*/input")).clear();
        driver.findElement(By.xpath("//td[contains(@class, 'input-label') and text()='Email']/following-sibling::*/input")).sendKeys("tioagung92@gmail.com");

        //Fills Phone No
        driver.findElement(By.xpath("//td[contains(@class, 'input-label') and text()='Phone no']/following-sibling::*/input")).clear();
        driver.findElement(By.xpath("//td[contains(@class, 'input-label') and text()='Phone no']/following-sibling::*/input")).sendKeys("08987357158");

        //Fills City
        driver.findElement(By.xpath("//td[contains(@class, 'input-label') and text()='City']/following-sibling::*/input")).clear();
        driver.findElement(By.xpath("//td[contains(@class, 'input-label') and text()='City']/following-sibling::*/input")).sendKeys("Depok");

        //Fills Address
        driver.findElement(By.xpath("//td[contains(@class, 'input-label') and text()='Address']/following-sibling::*/textarea")).clear();
        driver.findElement(By.xpath("//td[contains(@class, 'input-label') and text()='Address']/following-sibling::*/textarea")).sendKeys("Kemang raya");

        //Fills Postal code
        driver.findElement(By.xpath("//td[contains(@class, 'input-label') and text()='Postal Code']/following-sibling::*/input")).clear();
        driver.findElement(By.xpath("//td[contains(@class, 'input-label') and text()='Postal Code']/following-sibling::*/input")).sendKeys("12720");
    }

    @And("user click button {string}")
    public void clickCheckoutButton(String values) throws InterruptedException {
        driver.findElement(By.xpath("//div[contains(text(),'" + values + "')]")).isDisplayed();
        driver.findElement(By.xpath("//div[contains(text(),'" + values + "')]")).click();
    }

    @When("user is in Checkout page")
    public void validateCheckoutPage() throws InterruptedException {
        Thread.sleep(4000);
        driver.switchTo().frame("snap-midtrans");
        driver.findElement(By.xpath("//div[contains(text(),'Rp20.000')]")).isDisplayed();
        driver.findElement(By.xpath("//div[contains(text(),'All payment methods')]")).isDisplayed();
    }

    @And("user choose {string} payment method")
    public void chooseCreditCardPaymentMethod(String value) throws InterruptedException {
        driver.findElement(By.xpath("//div[contains(text(),'" + value + "')]")).isDisplayed();
        driver.findElement(By.xpath("//img[@alt='VISA']")).isDisplayed();
        driver.findElement(By.xpath("//img[@alt='VISA']")).click();
    }

    @And("user fill card number {string}")
    public void fillCardNumber(String value) throws InterruptedException {
        driver.findElement(By.xpath("//span[contains(text(),'Credit/debit card')]")).isDisplayed();
        driver.findElement(By.xpath("//div[contains(@class, 'card-number')]/div[2]/input")).isDisplayed();
        driver.findElement(By.xpath("//div[contains(@class, 'card-number')]/div[2]/input")).sendKeys(value);
    }

    @And("user fill expiration date {string}")
    public void fillExpDate(String value) throws InterruptedException {
        driver.findElement(By.xpath("//input[@id='card-expiry']")).isDisplayed();
        driver.findElement(By.xpath("//input[@id='card-expiry']")).sendKeys(value);
    }

    @And("user fill cvv number {string}")
    public void fillCvvNumberField(String value) throws InterruptedException {
        driver.findElement(By.xpath("//input[@id='card-cvv']")).isDisplayed();
        driver.findElement(By.xpath("//input[@id='card-cvv']")).sendKeys(value);
    }

    @And("user choose {string}")
    public void choosePromoPage(String value) throws InterruptedException {
        driver.findElement(By.xpath("//label[.='" + value + "']")).isDisplayed();
        driver.findElement(By.xpath("//label[.='" + value + "']")).click();
    }

    @When("user click button pay now")
    public void clickButtonPay() throws InterruptedException {
        driver.findElement(By.xpath("//button[contains(text(),'Pay now')]")).isDisplayed();
        driver.findElement(By.xpath("//button[contains(text(),'Pay now')]")).click();
    }

    @Then("user is in confirmation information page")
    public void validateConfirmationPage() throws InterruptedException {
        Thread.sleep(6000);
        WebElement iframe_element = driver.findElement(By.xpath("//iframe[@class='iframe-3ds']"));
        driver.switchTo().frame(iframe_element);
        driver.findElement(By.xpath("//h1[contains(text(),'Issuing Bank')]")).isDisplayed();
    }

    @And("user input password transaction {string}")
    public void inputPassword(String value) throws InterruptedException {
        driver.findElement(By.xpath("//input[@id='otp']")).isDisplayed();
        driver.findElement(By.xpath("//input[@id='otp']")).sendKeys(value);
    }

    @When("user click ok button")
    public void clickOkButton() throws InterruptedException{
        driver.findElement(By.xpath("//button[@name='ok']")).isDisplayed();
        driver.findElement(By.xpath("//button[@name='ok']")).click();
    }

    @Then("user get transaction is success")
    public void verifyTransactionSucccess() throws InterruptedException{
        Thread.sleep(6000);
        //WebElement iframe_element = driver.findElement(By.xpath("//iframe[id='snap-midtrans']"));
        //driver.switchTo().frame(iframe_element);
        driver.switchTo().frame("snap-midtrans");
        driver.findElement((By.xpath("//*[text()='Payment successful']")));
    }

}
