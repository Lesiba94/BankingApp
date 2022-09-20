package testRunner;

import Pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestRunner {
    public WebDriver driver;
    public HomePage application;
    @BeforeTest
    public void setChrome()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        application = new HomePage(driver);
    }

    @Test(priority = 1)
    public void Login()
    {
        application.customerLogin.openBankApplication();
        application.customerLogin.customerLogin();
        application.customerLogin.selectUser();
        application.customerLogin.clickLoginBtn();
    }

    @Test(priority = 2)
    public void Deposit()
    {
        application.depositPage.deposit();
        application.depositPage.setAmount();
        application.depositPage.setDepositBtn();
        application.depositPage.depositStatus();
    }

    public void close()
    {
        driver.close();
        driver.quit();
    }
}
