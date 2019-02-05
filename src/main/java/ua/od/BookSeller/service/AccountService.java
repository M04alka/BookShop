package ua.od.BookSeller.service;

import ua.od.BookSeller.dto.AccountDto;

public interface AccountService {

    String loginAccount(AccountDto user);
    String createNewUser(AccountDto user);

}
