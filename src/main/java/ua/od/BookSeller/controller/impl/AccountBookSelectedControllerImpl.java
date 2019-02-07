package ua.od.BookSeller.controller.impl;

import ua.od.BookSeller.controller.AccountBookSelectedController;
import ua.od.BookSeller.dto.SelectedInAccountDto;
import ua.od.BookSeller.service.AccountBookSelectedService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("account")
public class AccountBookSelectedControllerImpl implements AccountBookSelectedController {

    private AccountBookSelectedService accountBookSelectedService;

    @GET
    @Path("/{accountId}/{bookId}")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public SelectedInAccountDto getSelectedBook(@PathParam("accountId") Integer a_id, @PathParam("bookId")Integer b_id) {
        SelectedInAccountDto sellectedBook = accountBookSelectedService.selectedBook(a_id,b_id);
        return sellectedBook;
    }
}
