package ua.od.BookSeller.dto;

import ua.od.BookSeller.model.AuthorEntity;
import ua.od.BookSeller.model.GanreEntity;

import java.util.List;

public class ShopSelectedDto {
    String bookName;
    Float price;
    String description;
    String publishingHouse;
    List<GanreDto> ganres;
    List<AuthorDto> authors;

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
