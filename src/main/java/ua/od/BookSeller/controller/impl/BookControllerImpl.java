package ua.od.BookSeller.controller.impl;

import ua.od.BookSeller.controller.BookController;
import ua.od.BookSeller.dto.BookDto;
import ua.od.BookSeller.service.BookService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

public class BookControllerImpl implements BookController {

    @Inject
    public BookService bookService;

    @GET
    @Path("list")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<BookDto> getAllBooksList() {
        List<BookDto> bookList = bookService.getAllBooksList();
        return bookList;
    }
}
