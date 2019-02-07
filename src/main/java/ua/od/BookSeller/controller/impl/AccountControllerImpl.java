package ua.od.BookSeller.controller.impl;

import ua.od.BookSeller.controller.AccountController;
import ua.od.BookSeller.dto.AccountDto;
import ua.od.BookSeller.service.AccountService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/user")
public class AccountControllerImpl implements AccountController {

    @Inject
    public AccountService accountService;


    @POST
    @Path("login")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public String loginAccount(AccountDto user) {
        String verify = accountService.loginAccount(user);
        return verify;
    }

    @POST
    @Path("new")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response createNewAccount(AccountDto user) {
        accountService.createNewUser(user);
        return Response.status(201).build();
    }
}
