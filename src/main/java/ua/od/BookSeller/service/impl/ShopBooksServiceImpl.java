package ua.od.BookSeller.service.impl;

import ua.od.BookSeller.dto.ShopBooksDto;
import ua.od.BookSeller.repository.dao.ShopBooksDao;
import ua.od.BookSeller.repository.dao.imp.ShopBooksDaoImpl;
import ua.od.BookSeller.service.ShopBooksService;

import java.util.ArrayList;
import java.util.List;

public class ShopBooksServiceImpl implements ShopBooksService {

    public ShopBooksDao bookDao;

    @Override
    public List<ShopBooksDto> getAllBooksList() {
        bookDao = new ShopBooksDaoImpl();
        List<ShopBooksDto> bookList = new ArrayList<>();
        bookDao.getAllBooks().forEach(bookEntity -> {
            bookList.add(new ShopBooksDto(){{
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
