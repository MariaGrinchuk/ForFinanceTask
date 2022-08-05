package forFinance.Pages;

import forFinance.Utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CollectionsPage extends BasePage {

    public CollectionsPage () {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy (className = "mygeek-dropdown-username tw-truncate")
    WebElement accButton;

    @FindBy(xpath = "//span[contains(text(),'MariJeparska')]")
    WebElement accNameButton;

    @FindBy(xpath = "//a[contains(text(),'Profile')]")
    WebElement collectButton;

    public void collPage(){
        accNameButton.click();
        collectButton.click();
    }

    @FindBy(xpath= "//tbody/tr[1]/td[1]/div[2]/div[1]/div[1]")
    WebElement accInfo;

    public void checkAcc(){
        Assert.assertTrue(accInfo.getText().contains("MariJeparska"));
    }

    @FindBy (xpath = "//a[contains(text(),'Collection')]")
    WebElement goToCall;

    public void goToCollections(){
        accNameButton.click();
        goToCall.click();
    }

    @FindBy (xpath = "/html[1]/body[1]/div[2]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[4]/div[4]/table[1]/tbody[1]/tr[3]/td[1]/div[2]/a[1]")
    WebElement gamePage;

    public void gamePage(){

        gamePage.click();
    }

    @FindBy (xpath = "//body/div[2]/main[1]/div[2]/div[1]/div[1]/div[2]/ng-include[1]/div[1]/div[1]/ui-view[1]/ui-view[1]/div[1]/overview-module[1]/description-module[1]/div[1]/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/ul[1]/li[1]/div[2]/span[1]/button[1]/span[1]")
    WebElement voteStatsIcon;

    public void openSTatsWindow() throws InterruptedException {
        voteStatsIcon.click();
        Thread.sleep(2000);
    }
}
