package ua.od.BookSeller.repository.dao;

import ua.od.BookSeller.model.AccountEntity;
import ua.od.BookSeller.model.NewAccountEntity;

import java.util.List;

public interface AccountDao {
    List<AccountEntity> loginUser();
    String createNewUser(NewAccountEntity user);
}
