import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static org.hamcrest.MatcherAssert.assertThat;

public class NavigationPage {
    private final SelenideElement home = $(By.linkText("Home"));
    private final SelenideElement allBooks = $(By.linkText("All books"));
    private final SelenideElement allAuthors = $(By.linkText("All authors"));
    private final SelenideElement allGenres = $(By.linkText("All genres"));
    private final SelenideElement allBookInstances = $(By.linkText("All book-instances"));
    private final SelenideElement createNewAuthor = $(By.linkText("Create new author"));
    private final SelenideElement createNewGenre = $(By.linkText("Create new genre"));
    private final SelenideElement createNewBook = $(By.linkText("Create new book"));
    private final SelenideElement createNewInstance = $(By.linkText("Create new book instance (copy)"));

    public void verifyNavigationPage() {
        assertThat("Home element is not shown", home.isDisplayed());
        assertThat("All Books element is not shown", allBooks.isDisplayed());
        assertThat("All Authors element is not shown", allAuthors.isDisplayed());
        assertThat("All Genres element is not shown", allGenres.isDisplayed());
        assertThat("All book-instances element is not shown", allBookInstances.isDisplayed());
        assertThat("Create new author element is not shown", createNewAuthor.isDisplayed());
        assertThat("Create new genre element is not shown", createNewGenre.isDisplayed());
        assertThat("Create new book element is not shown", createNewBook.isDisplayed());
        assertThat("Create new book instance (copy) element is not shown", createNewInstance.isDisplayed());
    }

    public void openCreateBookPage() {
        this.createNewBook.click();
    }

    public void openAllBooksPage() {
        Selenide.sleep(2000);
        this.allBooks.click();
    }
}

