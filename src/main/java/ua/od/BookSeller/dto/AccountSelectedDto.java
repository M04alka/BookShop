package ua.od.BookSeller.dto;

import ua.od.BookSeller.model.AuthorEntity;
import ua.od.BookSeller.model.GanreEntity;

import java.util.List;

public class AccountSelectedDto {
    String bookName;
    String description;
    String content;
    String publishingHouse;
    List<GanreDto> ganres;
    List<AuthorDto> authors;

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

    public List<GanreDto> getGanres() {
        return ganres;
    }

    public void setGanres(List<GanreDto> ganres) {
        this.ganres = ganres;
    }

    public List<AuthorDto> getAuthors() {
        return authors;
    }

    public void setAuthors(List<AuthorDto> authors) {
        this.authors = authors;
    }
}
