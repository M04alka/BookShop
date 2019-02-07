package ua.od.BookSeller.service.impl;

import ua.od.BookSeller.model.SelectedInShopEntity;
import ua.od.BookSeller.repository.dao.ShopBookSelectedDao;
import ua.od.BookSeller.service.ShopBookSelectedService;

public class ShopBookSelectedServiceImpl implements ShopBookSelectedService {

    public ShopBookSelectedDao bookDao;


    @Override
    public String BookInshop(SelectedInShopEntity bookEntity, Integer id) {
        String book = bookDao.BookInshop(id);
        return null;
    }
}
