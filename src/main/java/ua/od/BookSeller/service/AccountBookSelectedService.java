package ua.od.BookSeller.service;

import ua.od.BookSeller.dto.AccountSelectedDto;

public interface AccountBookSelectedService {
    AccountSelectedDto selectedBook(Integer a_id, Integer b_id);
}
