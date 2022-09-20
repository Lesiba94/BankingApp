package Pages;

import org.openqa.selenium.WebDriver;

public class HomePage {
    public CustomerLogin customerLogin;
    public DepositPage depositPage;
    public HomePage(WebDriver driver)
    {
        customerLogin = new CustomerLogin(driver);
        depositPage = new DepositPage(driver);
    }
}
