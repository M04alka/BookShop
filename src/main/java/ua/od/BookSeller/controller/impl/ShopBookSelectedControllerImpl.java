package ua.od.BookSeller.controller.impl;

import ua.od.BookSeller.controller.ShopBookSelectedController;
import ua.od.BookSeller.dto.AccountSelectedDto;
import ua.od.BookSeller.dto.ShopSelectedDto;
import ua.od.BookSeller.service.ShopBookSelectedService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
@Path("/shop")
public class ShopBookSelectedControllerImpl implements ShopBookSelectedController {

    @Inject
    private ShopBookSelectedService shopBookSelectedService;

    @GET
    @Path("{bookId}")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public ShopSelectedDto getSelectedBook(@PathParam("bookId") Integer b_id) {
      ShopSelectedDto sellectedBook = shopBookSelectedService.BookInshop(b_id);
        return sellectedBook;
    }
}
