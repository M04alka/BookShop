package ua.od.BookSeller.controller;

import ua.od.BookSeller.dto.AccountBooksDto;

import java.util.List;

public interface AccountBooksController {

    List<AccountBooksDto> getAllAccountBooksList();

}
