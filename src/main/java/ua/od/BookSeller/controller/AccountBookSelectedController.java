package ua.od.BookSeller.controller;

import ua.od.BookSeller.dto.AccountSelectedDto;

public interface AccountBookSelectedController {
    AccountSelectedDto getSelectedBook(Integer a_id, Integer b_id);
}
