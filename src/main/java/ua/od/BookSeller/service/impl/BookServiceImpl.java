package ua.od.BookSeller.service.impl;

import ua.od.BookSeller.dto.BookDto;
import ua.od.BookSeller.repository.dao.BookDao;
import ua.od.BookSeller.repository.dao.imp.BookDaoImpl;
import ua.od.BookSeller.service.BookService;

import java.util.ArrayList;
import java.util.List;

public class BookServiceImpl implements BookService {

    public BookDao bookDao;

    @Override
    public List<BookDto> getAllBooksList() {
        bookDao = new BookDaoImpl();
        List<BookDto> bookList = new ArrayList<>();
        bookDao.getAllBooks().forEach(bookEntity -> {
            bookList.add(new BookDto(){{
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
