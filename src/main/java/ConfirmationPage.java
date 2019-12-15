import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class ConfirmationPage {
    private final SelenideElement title = $(".col-sm-10 h1");
    private final SelenideElement author = $("p:nth-child(2) > a");
    private final SelenideElement summary = $("p:nth-child(3)");
    private final SelenideElement isbn = $("p:nth-child(4)");
    private final SelenideElement genre =  $("p:nth-child(5)");
    private final SelenideElement deleteBook = $(By.linkText("Delete Book"));
    private final SelenideElement updateBook = $(By.linkText("Update Book"));

    public void verifyConfirmationPage(){
        assertTrue(title.isDisplayed());
        assertTrue(author.isDisplayed());
        assertTrue(summary.isDisplayed());
        assertTrue(isbn.isDisplayed());
        assertTrue(genre.isDisplayed());
        assertTrue(deleteBook.isDisplayed());
        assertTrue(updateBook.isDisplayed());
    }

    public String getTitle() {
        return title.getText();
    }

    public String getAuthor() {
        return author.getText();
    }

    public String getSummary() {
        return summary.getText();
    }

    public String getIsbn() {
        return isbn.getText();
    }

    public String getGenre() {
        return genre.getText();
    }

    public void verifyAddedBookInformation(TestData data){
        assertThat("Title is not shown ", this.getTitle(), containsString(data.getTitle()));
        assertThat("Author is not shown ", this.getAuthor(), containsString(data.getAuthor()));
        assertThat("Summary is not shown ", this.getSummary(), containsString(data.getSummary()));
        assertThat("ISBN is not shown ", this.getIsbn(), containsString(data.getIsbn()));
        assertThat("Genre is not shown ", this.getGenre(), containsString(data.getNonFictionGenre()));
    }
}
