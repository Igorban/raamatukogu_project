import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

public class TestCases {
    private final NavigationPage navigation = new NavigationPage();
    private final CreateNewBookPage createBook = new CreateNewBookPage();
    private final ConfirmationPage confirmation = new ConfirmationPage();
    private final AllBooksPage allBooks = new AllBooksPage();
    private TestData data;

    @BeforeEach
    public void beforeScenario() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;
        Selenide.open("https://raamatukogu.herokuapp.com");
    }

    @Test
    @DisplayName("Verify that new book can be added")
    void addNewBook() throws InterruptedException {
        navigation.verifyNavigationPage();
        navigation.openCreateBookPage();
        createBook.verifyCreateNewBookPage();
        data = new TestData("Novik, Naomi", "Summary", "ISBN", "Non-fiction");
        createBook.createNewBook(data.getTitle(), data.getAuthor(), data.getSummary(), data.getIsbn());
        confirmation.verifyConfirmationPage();
        confirmation.verifyAddedBookInformation(data);
    }

    @Test
    @DisplayName("Verify newly added book is listed in catalogue")
    void verifyAddedBook() throws InterruptedException {
        navigation.openCreateBookPage();
        data = new TestData("Novik, Naomi", "Summary", "ISBN", "Non-fiction");
        createBook.createNewBook(data.getTitle(), data.getAuthor(), data.getSummary(), data.getIsbn());
        navigation.openAllBooksPage();
        allBooks.verifyAllBooksPage();
        allBooks.verifylistOfBooksContainsAddedBook(data);
    }
}
