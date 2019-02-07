package ua.od.BookSeller.controller.impl;

import ua.od.BookSeller.controller.AccountBooksController;
import ua.od.BookSeller.dto.AccountBooksDto;
import ua.od.BookSeller.service.AccountBooksService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("books")
public class AccountBooksControllerImpl implements AccountBooksController {
    @Inject
    private AccountBooksService accountBooksService;

    @GET
    @Path("/{id}/list")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<AccountBooksDto> getAllAccountBooksList(@PathParam("id") Integer id) {
        List<AccountBooksDto> booksOnAccountList = accountBooksService.getAllAccountBooks(id);
        return booksOnAccountList;
    }
}
