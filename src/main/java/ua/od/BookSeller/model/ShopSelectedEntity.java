package ua.od.BookSeller.model;

public class ShopSelectedEntity {

    String bookName;
    Float price;
    String description;
    String authorName;
    String authorSername;
    String authorPatronymic;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorNmae) {
        this.authorName = authorNmae;
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
