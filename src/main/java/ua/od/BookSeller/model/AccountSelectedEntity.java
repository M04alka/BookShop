package ua.od.BookSeller.model;

import java.util.List;

public class AccountSelectedEntity {
    String bookName;
    String description;
    String content;
    String publishingHouse;
    List<GanreEntity> ganres;
    List<AuthorEntity> authors;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    public List<GanreEntity> getGanres() {
        return ganres;
    }

    public void setGanres(List<GanreEntity> ganres) {
        this.ganres = ganres;
    }

    public List<AuthorEntity> getAuthors() {
        return authors;
    }

    public void setAuthors(List<AuthorEntity> authors) {
        this.authors = authors;
    }
}
