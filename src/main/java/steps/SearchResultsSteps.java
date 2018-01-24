package steps;

import org.junit.Assert;
import pages.SearchResultsPage;

public class SearchResultsSteps {
    SearchResultsPage searchResultsPage;

    public SearchResultsSteps(SearchResultsPage searchResultsPage){
        this.searchResultsPage=searchResultsPage;
    }

    public void isEachProductDescriptionContain(String text) throws InterruptedException {
        Thread.sleep(2000);
        searchResultsPage.getTextValuesOf(searchResultsPage.GOOD_CONTAINER_GOOD_DESCRIPTION)
                .forEach(description-> Assert.assertTrue(description.toLowerCase().contains(text)));
    }
}
