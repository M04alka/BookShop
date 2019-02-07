package ua.od.BookSeller.model;

import java.util.List;

public class AccountBooksEntity {
    String name;
    List<AuthorEntity> authors;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AuthorEntity> getAuthors() {
        return authors;
    }

    public void setAuthors(List<AuthorEntity> authors) {
        this.authors = authors;
    }
}
