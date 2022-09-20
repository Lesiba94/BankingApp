package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class DepositPage {
    private WebDriver _driver;
    public DepositPage(WebDriver driver)
    {
        this._driver = driver;
        PageFactory.initElements(_driver,this);
    }

    @FindBy(xpath = "(//button[@class='btn btn-lg tab'])[2]")
    private WebElement depositBtn;
    @FindBy(xpath = "//input[@type='number']")
    private WebElement amount;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement depositButton;
    public void deposit()
    {
        _driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        depositBtn.click();
    }

    public void setAmount()
    {
        amount.sendKeys("1000");
    }

    public void setDepositBtn()
    {
        depositButton.click();
    }

    public void depositStatus()
    {
        String actualTitle = _driver.findElement(By.xpath("//span[@class='error ng-binding']")).getText();
        String expectedTitle = "Deposit Successful";

        if(expectedTitle.equalsIgnoreCase(actualTitle))
        {
            System.out.println("You have successfully deposit ");
        }
        else
        {
            System.out.println("Failed to deposit");
        }
    }

}
