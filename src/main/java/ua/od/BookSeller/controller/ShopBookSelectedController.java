package ua.od.BookSeller.controller;

import ua.od.BookSeller.dto.ShopSelectedDto;

public interface ShopBookSelectedController {
   ShopSelectedDto getSelectedBook(Integer b_id);
   String addBook(Integer a_id, Integer b_id);
}
