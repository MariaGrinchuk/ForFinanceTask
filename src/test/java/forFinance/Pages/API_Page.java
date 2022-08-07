package forFinance.Pages;

import forFinance.Utilities.Driver;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class API_Page extends BasePage {

    public API_Page() {
        PageFactory.initElements(Driver.get(), this);
    }

    List<WebElement> tableList = Driver.get().findElements(By.xpath("//body/div[2]/div[1]/div[1]/div[2]/div[1]/poll-question-results[1]/table[1]"));
    List<String> allTableElements = new ArrayList<>();

    protected  String mostVotedValueText = Driver.get().findElement(By.xpath("//tbody/tr[3]/th[1]/span[1]")).getText();
    String numv = "numvotes=22";
    String topNumvText = "Moderate in-game text - needs crib sheet or paste ups";


    Response response = RestAssured.get("https://boardgamegeek.com/xmlapi/boardgame/316554");

    String code = response.asString();

    String partialCode = code.substring(15967, 16535);

    Map<String, String> map = new HashMap<>();
    Elements allResultElements = Jsoup.parse(partialCode, String.valueOf(Parser.xmlParser())).select("result");

    String mapData = allResultElements.toString();


    public void APIcheck() {

        for (Element result : allResultElements) {
            map.put(result.attr("value"), result.attr("numvotes"));
        }

    }

    public void check() {

        String mostVotedParam = null;

        if (mapData.contains("\"22\"")) {

            mostVotedParam = "Moderate in-game text - needs crib sheet or paste ups";

            Assert.assertEquals(mostVotedParam, mostVotedValueText);
        }

    }

}


