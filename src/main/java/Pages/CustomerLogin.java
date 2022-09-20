package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class CustomerLogin {

    private WebDriver _driver;
    public CustomerLogin(WebDriver driver)
    {
        this._driver = driver;
        PageFactory.initElements(_driver,this);
    }

    @FindBy(xpath = "(//button[@class])[3]")
    private WebElement customerLgnBtn;

    @FindBy(id = "userSelect")
    private WebElement userName;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginBtn;



    public void openBankApplication()
    {
        _driver.navigate().to("https://www.way2automation.com/angularjs-protractor/banking/#/login");
    }

    public void customerLogin()
    {
        _driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        customerLgnBtn.click();
    }


    public void selectUser()
    {
        userName.click();
        Select select = new Select(userName);
        select.selectByIndex(1);
    }

    public void clickLoginBtn()
    {
        loginBtn.click();
    }
}
