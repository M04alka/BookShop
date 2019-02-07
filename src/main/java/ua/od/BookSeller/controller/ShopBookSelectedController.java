package ua.od.BookSeller.controller;

import ua.od.BookSeller.dto.AccountSelectedDto;
import ua.od.BookSeller.dto.ShopSelectedDto;

public interface ShopBookSelectedController {
   ShopSelectedDto getSelectedBook(Integer b_id);
}
