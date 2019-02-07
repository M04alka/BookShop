package ua.od.BookSeller.repository.dao;

import ua.od.BookSeller.model.ShopBooksEntity;

import java.util.List;

public interface ShopBooksDao {
    List<ShopBooksEntity> getAllBooks();
}
