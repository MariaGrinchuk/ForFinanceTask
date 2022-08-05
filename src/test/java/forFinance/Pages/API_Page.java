package forFinance.Pages;

import forFinance.Utilities.Driver;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class API_Page extends BasePage {

    public API_Page () {PageFactory.initElements(Driver.get(), this);
    }

        List<WebElement> tableList = Driver.get().findElements(By.xpath("//body/div[2]/div[1]/div[1]/div[2]/div[1]/poll-question-results[1]/table[1]"));
        List<String> allTableElements = new ArrayList<>();

        String mostVotedValueText = Driver.get().findElement(By.xpath("//tbody/tr[3]/th[1]/span[1]")).getText();
        String numv = "numvotes=22";
        String topNumvText = "Moderate in-game text - needs crib sheet or paste ups";


        public  void  getValues() {

        Assert.assertEquals(mostVotedValueText, topNumvText);

        }

        public void APIcheck() {

            Response response = RestAssured.get("https://boardgamegeek.com/xmlapi/boardgame/316554");

            String code = response.asString();

            String partialCode = code.substring(15967, 16535);

            String partialCodeAm = partialCode.replaceAll("/>", "");
            String partialCodeAp = partialCodeAm.replaceAll("<", "");
            String partialCodeAf = partialCodeAp.replaceAll("\"", "");
            String partialCodeAd = partialCodeAf.replaceAll("results>", "");
            String partialCodeAu = partialCodeAd.replaceAll(">", "");
            String partialCodeAc = partialCodeAu.replaceAll("/results>", "");
            String partialCodeAk = partialCodeAc.replaceAll("/", "");

            String[] parts = partialCodeAk.split(",");

            Map<String, String> map = new HashMap<>();

            for (String part : parts) {

                String[] voteData = part.split(":");

                String level = voteData[0].trim();
                String numvotes = voteData[0].trim();

                map.put(level, numvotes);
            }


            if (map.containsKey(numv)) {

                System.out.println("Value found");
            } else {
                System.out.println("Value not found");
            }

        }

    }


