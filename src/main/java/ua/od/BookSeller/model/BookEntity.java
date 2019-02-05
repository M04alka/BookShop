package ua.od.BookSeller.model;

public class BookEntity {

    String name;
    Float price;
    String authorName;
    String authotSername;
    String authorPatronymic;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthotSername() {
        return authotSername;
    }

    public void setAuthotSername(String authotSername) {
        this.authotSername = authotSername;
    }

    public String getAuthorPatronymic() {
        return authorPatronymic;
    }

    public void setAuthorPatronymic(String authorPatronymic) {
        this.authorPatronymic = authorPatronymic;
    }
}
