package Stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;


public class PurchaseProduct {
    WebDriver driver;
    static WebDriverWait wait;
    private By webDriver;

    @Given("user Open browser")
    public void iOpenBrowser() {
        final String dir = System.getProperty("user.dir");
        System.out.println("current dir = " + dir);
        //System.setProperty("webdriver.chrome.driver", dir + "/driver/chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", dir + "/driver/geckodriver.exe");
       // driver = new ChromeDriver();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @And("user go Voila ID website")
    public void goToVoilaWebsite() throws InterruptedException {
        driver.get("https://voila.id/");
        driver.findElement(By.xpath("//a[contains(.,'Free Shipping to All Over Indonesia')]")).isDisplayed();
        driver.findElement(By.xpath("//span[.='New Arrival']")).isDisplayed();
    }

    @And("user go to login account page")
    public void loginAccount() throws InterruptedException {
        driver.findElement(By.xpath("//div[@class='tt-account tt-dropdown-obj']/button[@class='tt-dropdown-toggle']")).isDisplayed();
        driver.findElement(By.xpath("//div[@class='tt-account tt-dropdown-obj']/button[@class='tt-dropdown-toggle']")).click();
        driver.findElement(By.xpath("//h2[contains(text(),'login')]")).isDisplayed();
    }

    @And("user input email & password")
    public void inputEmailPassword() throws InterruptedException {
        driver.findElement(By.xpath("//input[@id='loginInputName']")).isDisplayed();
        driver.findElement(By.xpath("//input[@id='loginInputName']")).sendKeys("tioagung92@gmail.com");
        driver.findElement(By.xpath("//input[@id='loginInputPassword']")).isDisplayed();
        driver.findElement(By.xpath("//input[@id='loginInputPassword']")).sendKeys("Tolakangin1234!");
        driver.findElement(By.xpath("//button[.='Login']")).click();
    }

    @And("user search product {string}")
    public void searchProduct(String product) throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@class='tt-search tt-dropdown-obj']/button[@class='tt-dropdown-toggle']")).click();
        driver.findElement(By.xpath("//input[@class='tt-search-input boost-pfs-search-box']")).isDisplayed();
        driver.findElement(By.xpath("//input[@class='tt-search-input boost-pfs-search-box']")).sendKeys(product);
        Thread.sleep(3000);
        driver.findElement(By.xpath("//img[@alt='LA Dodgers Fielder Ball Cap Denim']")).click();
    }

    @And("user go to product detail page")
    public void goToProductDetailPage() throws InterruptedException {
        driver.findElement(By.xpath("//h1[contains(text(),'LA Dodgers Fielder Ball Cap Denim')]")).isDisplayed();
        driver.findElement(By.xpath("//span[.='IDR 875.000']")).isDisplayed();
        driver.findElement(By.xpath("//a[.='59']")).click();
    }

    @And("user add to cart product")
    public void addToCart() throws InterruptedException {
        driver.findElement(By.xpath("//button[@class='btn btn-lg btn-addtocart addtocart-js']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@class='tt-modal-addtocart mobile']/a[.='Lihat Keranjang']")).click();
    }

    @And("user is in Cart page")
    public void verifyProductInCart() throws InterruptedException {
        driver.findElement(By.xpath("//h1[contains(text(),'Keranjang Belanja')]")).isDisplayed();
        driver.findElement(By.xpath("//a[.='LA Dodgers Fielder Ball Cap Denim']")).isDisplayed();
        driver.findElement(By.xpath("//tr[@id='grandtotal']//span[contains(text(),'IDR 875.000')]"));
    }

    @And("user click button checkout")
    public void clickButtonCheckout() throws InterruptedException {
        driver.findElement(By.xpath("//button[@name='checkout']")).click();
    }

    @And("user is in checkout confirmation page")
    public void verifyCheckoutInformation() throws InterruptedException {
        driver.findElement(By.xpath("//h2[.='Alamat pengiriman']")).isDisplayed();
    }

    @And("user fill data shipping address")
    public void fillDataShipping() throws InterruptedException {
    //Fill data Firstname
        driver.findElement(By.id("TextField8")).isDisplayed();
        driver.findElement(By.id("TextField8")).sendKeys("Tio pratama agung");

    //Fill data Lastname
        driver.findElement(By.id("TextField9")).isDisplayed();
        driver.findElement(By.id("TextField9")).sendKeys("Candidate QA");

    //Fill alamat
        driver.findElement(By.id("TextField10")).isDisplayed();
        driver.findElement(By.id("TextField10")).sendKeys("Ihsan residence");

    //Fill kota dan kecamatan
        driver.findElement(By.id("TextField12")).isDisplayed();
        driver.findElement(By.id("TextField12")).sendKeys("Depok , Cipayung");

    //Fill provinsi
        driver.findElement(By.id("Select3")).click();
        driver.findElement(By.xpath("//option[.='Jawa Barat']")).click();

    //Fill kode pos
        driver.findElement(By.id("TextField13")).isDisplayed();
        driver.findElement(By.id("TextField13")).sendKeys("16442");

    //Fill no handphone
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,2000)");
        driver.findElement(By.id("TextField14")).isDisplayed();
        driver.findElement(By.id("TextField14")).sendKeys("08987357158");

    //Click button lanjut ke pengiriman
        driver.findElement(By.xpath("//button[@class='QT4by rqC98 hodFu _7QHNJ VDIfJ j6D1f janiy']")).click();

    }
    @Then("user is in pengiriman page for choose courier")
    public void verifyDeliveryPage() throws InterruptedException {
        driver.findElement(By.xpath("//h2[@id='step-section-primary-header']")).isDisplayed();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@type='submit' and @class='QT4by rqC98 hodFu _7QHNJ VDIfJ j6D1f janiy']")).click();
    }

    @When("user go to payment page for choose method payment")
    public void chooseMethodPayment() throws InterruptedException{
        Thread.sleep(3000);
        JavascriptExecutor scroll = (JavascriptExecutor) driver;
        scroll.executeScript("window.scrollBy(0,2000)");
        driver.findElement(By.xpath("//span[.='Bank Transfer']")).click();
        driver.findElement(By.xpath("//p[contains(text(),'Transfer Bank (Verifikasi Manual)')]")).isDisplayed();
        driver.findElement(By.xpath("//button[@class='QT4by rqC98 hodFu _7QHNJ VDIfJ j6D1f janiy']")).isDisplayed();
        driver.findElement(By.xpath("//button[@class='QT4by rqC98 hodFu _7QHNJ VDIfJ j6D1f janiy']")).click();
    }

    @Then("user success create transaction")
    public void verifyTransactionSucccess() throws InterruptedException{
        Thread.sleep(4000);
        driver.findElement(By.xpath("//h2[contains(text(),'Pesanan Anda sudah dikonfirmasi')]"));
        driver.findElement(By.xpath("//span[contains(text(),'Total')]")).isDisplayed();
        driver.findElement(By.xpath("//span[text()='Rp875.000,00']")).isDisplayed();
    }
}
