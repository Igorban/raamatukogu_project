import com.codeborne.selenide.*;

import static com.codeborne.selenide.Selenide.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class AllBooksPage {
    private final SelenideElement pageTitle = $(".col-sm-10 h1");
    private final ElementsCollection allBooksList = $$(".col-sm-10 li");

    public void verifyAllBooksPage() {
        assertThat("Book list page title did not appear ", pageTitle.getText().contains("Book List"));
    }

    public void verifylistOfBooksContainsAddedBook(TestData data) {
        assertThat("Added book with data " + data + " was not find ", allBooksList.findBy(Condition.text(data.getTitle())).exists());
    }
}
