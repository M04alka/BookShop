package ua.od.BookSeller.service;

import ua.od.BookSeller.dto.AccountBooksDto;
import ua.od.BookSeller.dto.BookDto;
import ua.od.BookSeller.model.BookEntity;

import java.util.List;

public interface BookService {

    List<BookDto> getAllBooksList();

}
