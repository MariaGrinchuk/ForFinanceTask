package forFinance.Utilities;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class browserUtils {

    public static void waitFor(double seconds) {
        try {
            Thread.sleep((int) (seconds * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static List<String> getElementsText(List<WebElement> list) {
        List<String> elemTexts = new ArrayList<>();
        list.forEach(wel -> elemTexts.add(wel.getText()));
        return elemTexts;
    }

    public static boolean isInsideOf(WebElement little, WebElement bigger) {
        Rectangle littleRect = little.getRect();
        Rectangle biggerRect = bigger.getRect();
        return biggerRect.getX() <= littleRect.getX()
                && biggerRect.getY() <= littleRect.getY()
                && biggerRect.getX() + biggerRect.getWidth() >= littleRect.getX() + littleRect.getWidth()
                && biggerRect.getY() + biggerRect.getHeight() >= littleRect.getY() + littleRect.getHeight();

    }

    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor) Driver.get()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static String getTitle() {
        return Driver.get().getTitle();
    }

    public static boolean isTitleContain(String string) {
        return getTitle().contains(string);
    }

}
