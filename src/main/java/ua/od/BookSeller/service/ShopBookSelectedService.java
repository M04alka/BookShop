package ua.od.BookSeller.service;

import ua.od.BookSeller.model.SelectedInShopEntity;

public interface ShopBookSelectedService {
    String BookInshop(SelectedInShopEntity bookEntity, Integer id);
}
