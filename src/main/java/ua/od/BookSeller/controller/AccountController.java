package ua.od.BookSeller.controller;

import ua.od.BookSeller.dto.AccountDto;

import javax.ws.rs.core.Response;

public interface AccountController {
    String loginAccount(AccountDto user);
    Response createNewAccount(AccountDto user);
}
