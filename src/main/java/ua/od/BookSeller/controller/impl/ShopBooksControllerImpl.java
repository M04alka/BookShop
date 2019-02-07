package ua.od.BookSeller.controller.impl;

import ua.od.BookSeller.controller.ShopBooksController;
import ua.od.BookSeller.dto.ShopBooksDto;
import ua.od.BookSeller.service.ShopBooksService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
@Path("shop")
public class ShopBooksControllerImpl implements ShopBooksController {

    @Inject
    public ShopBooksService bookService;

    @GET
    @Path("/list")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<ShopBooksDto> getAllBooksList() {
        List<ShopBooksDto> bookList = bookService.getAllBooksList();
        return bookList;
    }
}
