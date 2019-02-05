package ua.od.BookSeller.controller;

import ua.od.BookSeller.dto.AccountDto;

public interface AccountController {
    String loginAccount(AccountDto user);
    String createNewAccount(AccountDto user);
}
