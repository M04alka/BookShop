package ua.od.BookSeller.dto;

import java.util.List;

public class AccountBooksDto {
    String name;
    List<AuthorDto> authors;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AuthorDto> getAuthors() {
        return authors;
    }

    public void setAuthors(List<AuthorDto> authors) {
        this.authors = authors;
    }

}
