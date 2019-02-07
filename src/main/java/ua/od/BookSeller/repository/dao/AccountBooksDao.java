package ua.od.BookSeller.repository.dao;

import ua.od.BookSeller.model.AccountBooksEntity;

import java.util.List;

public interface AccountBooksDao {
    List<AccountBooksEntity> getAllAccountBoks(Integer id);
}
