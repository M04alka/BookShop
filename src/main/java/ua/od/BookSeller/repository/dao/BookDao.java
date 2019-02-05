package ua.od.BookSeller.repository.dao;

import ua.od.BookSeller.model.BookEntity;

import java.util.List;

public interface BookDao {
    List<BookEntity> getAllBooks();
}
