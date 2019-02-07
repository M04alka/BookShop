package ua.od.BookSeller.service;

import ua.od.BookSeller.dto.SelectedInAccountDto;

public interface AccountBookSelectedService {
    SelectedInAccountDto selectedBook(Integer a_id, Integer b_id);
}
