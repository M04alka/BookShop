package ua.od.BookSeller.dto;

public class SelectedInAccountDto {
    String bookName;
    String authorName;
    String authorSername;
    String authorPatronymic;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorSername() {
        return authorSername;
    }

    public void setAuthorSername(String authorSername) {
        this.authorSername = authorSername;
    }

    public String getAuthorPatronymic() {
        return authorPatronymic;
    }

    public void setAuthorPatronymic(String authorPatronymic) {
        this.authorPatronymic = authorPatronymic;
    }
}
