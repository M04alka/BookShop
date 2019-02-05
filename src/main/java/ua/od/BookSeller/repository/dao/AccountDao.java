package ua.od.BookSeller.repository.dao;

import ua.od.BookSeller.model.AccountEntity;

public interface AccountDao {
    String loginUser(AccountEntity user);
    String createNewUser(AccountEntity user);
}
