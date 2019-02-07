package ua.od.BookSeller.service.impl;

import ua.od.BookSeller.dto.BooksInShopDto;
import ua.od.BookSeller.repository.dao.ShopBooksDao;
import ua.od.BookSeller.repository.dao.imp.ShopBooksDaoImpl;
import ua.od.BookSeller.service.ShopBooksService;

import java.util.ArrayList;
import java.util.List;

public class ShopBooksServiceImpl implements ShopBooksService {

    public ShopBooksDao bookDao;

    @Override
    public List<BooksInShopDto> getAllBooksList() {
        bookDao = new ShopBooksDaoImpl();
        List<BooksInShopDto> bookList = new ArrayList<>();
        bookDao.getAllBooks().forEach(bookEntity -> {
            bookList.add(new BooksInShopDto(){{
                setName(bookEntity.getName());
                setAuthorName(bookEntity.getAuthorName());
                setAuthotSername(bookEntity.getAuthotSername());
                setAuthorPatronymic(bookEntity.getAuthorPatronymic());
                setPrice(bookEntity.getPrice());
            }});
        });
        return bookList;
    }
}
