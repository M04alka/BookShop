package ua.od.BookSeller.service;

import ua.od.BookSeller.dto.ShopSelectedDto;
import ua.od.BookSeller.model.ShopSelectedEntity;

public interface ShopBookSelectedService {
    ShopSelectedDto BookInshop(Integer id);
}
