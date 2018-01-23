package steps;

import cucumber.api.DataTable;
import models.SearchProductAutoSuggestLine;
import org.junit.Assert;
import pages.Header;

import java.util.ArrayList;
import java.util.List;

public class HeaderSteps {
    Header header;

    public HeaderSteps(Header header) {
        this.header = header;
    }

    public void isCityDisplayedInHeaderMenu(String itemName) {
        if(header.waitForTextToBePresentIn(header.SELECTED_CITY, itemName,5)!=null) {
            Assert.assertEquals(itemName, header.getTextOf(header.SELECTED_CITY));
        }else{
            Assert.assertTrue("Element hasn't been found:TIMEOUT EXCEPTION", false);
        }
    }

    public void isNotificationDisplayed(String message) {
        header.waitForVisibilityOfElementLocatedByXpath(header.NOTIFICATION_SELECTED_CITY, 3);
        Assert.assertEquals(message, header.getTextOf(header.NOTIFICATION_SELECTED_CITY));
    }

    public void isFirstItemOfAutosuggestListEqualTo(DataTable autosuggestLine) {
        SearchProductAutoSuggestLine searchProductAutoSuggestLine=new SearchProductAutoSuggestLine("http://","Телевизор TOSHIBA 49U7750EV","","16999 .-");
        List<SearchProductAutoSuggestLine> autosuggestLines=new ArrayList<>();
        autosuggestLines.add(searchProductAutoSuggestLine);
        autosuggestLines.add(new SearchProductAutoSuggestLine("https://i.eldorado.ua//55x55//goods/5477/5477164.jpg","Микроволновка", "5000","2000"));
        try {
            autosuggestLine.diff(DataTable.create(autosuggestLines));
            Assert.assertTrue(true);
        }catch(cucumber.runtime.table.TableDiffException e){
            Assert.assertTrue(e.getMessage(),false);
        }
    }
}
