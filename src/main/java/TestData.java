import org.apache.commons.lang3.RandomStringUtils;

public class TestData {
    private String title;
    private String author;
    private String summary;
    private String isbn;
    private String nonFictionGenre;

    public TestData(String author, String summary, String isbn, String nonFictionGenre) {
        this.title = titleGenerator();
        this.author = author;
        this.summary = summary;
        this.isbn = isbn;
        this.nonFictionGenre = nonFictionGenre;
    }

    public String titleGenerator() {
        int length = 10;
        boolean useLetters = true;
        boolean useNumbers = false;
        return RandomStringUtils.random(length, useLetters, useNumbers);
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getSummary() {
        return summary;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getNonFictionGenre() {
        return nonFictionGenre;
    }
}
