package ua.od.BookSeller.repository.dao;

import ua.od.BookSeller.model.BooksInShopEntity;

import java.util.List;

public interface ShopBooksDao {
    List<BooksInShopEntity> getAllBooks();
}
