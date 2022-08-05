package forFinance.Pages;

import forFinance.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(linkText = "Sign In")
    public WebElement signInButton;

        public void openLoginMenu() throws InterruptedException {
        signInButton.click();
        Thread.sleep(2000);
    }

}
