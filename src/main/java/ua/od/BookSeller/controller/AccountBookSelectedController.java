package ua.od.BookSeller.controller;

import ua.od.BookSeller.dto.SelectedInAccountDto;

public interface AccountBookSelectedController {
    SelectedInAccountDto getSelectedBook(Integer a_id,Integer b_id);
}
