import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static org.hamcrest.MatcherAssert.assertThat;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.attribute;

public class CreateNewBookPage {
    private final SelenideElement createBookHeader = $(".col-sm-10 h1");
    private final SelenideElement titleField = $("#title");
    private final SelenideElement authorField = $("#author");
    private final SelenideElement summaryField = $("#summary");
    private final SelenideElement isbnField = $("#isbn");
    private final SelenideElement nonFictionCheckbox = $$(".checkbox-input").find(attribute("value", "5b6714c73809970014e31c99"));
    ;
    private final SelenideElement fictionCheckbox = $$(".checkbox-input").find(attribute("value", "5b6714c93809970014e31c9a"));
    ;
    private final SelenideElement submitButton = $(".btn");

    public void verifyCreateNewBookPage() {
        assertThat("Create Book page title did not appear ", createBookHeader.getText().contains("Create Book"));
    }

    public void fillInTitle(String title) {
        this.titleField.setValue(title);
    }

    public void selectAuthor(String author) {
        this.authorField.selectOptionContainingText(author);
    }

    public void fillInSummary(String summary) {
        this.summaryField.setValue(summary);
    }

    public void fillInISBN(String isbn) {
        this.isbnField.setValue(isbn);
    }

    public void selectNonFiction() {
        this.nonFictionCheckbox.click();
    }

    public void selectFiction() {
        this.fictionCheckbox.click();
    }

    public void submit() {
        this.submitButton.click();
    }

    public void createNewBook(String title, String author, String summary, String isbn) throws InterruptedException {
        Selenide.sleep(1000);
        fillInTitle(title);
        selectAuthor(author);
        fillInSummary(summary);
        fillInISBN(isbn);
        selectNonFiction();
        submit();
    }
}
