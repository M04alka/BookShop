package ua.od.BookSeller.service;

import ua.od.BookSeller.dto.BooksInShopDto;

import java.util.List;

public interface ShopBooksService {

    List<BooksInShopDto> getAllBooksList();

}
