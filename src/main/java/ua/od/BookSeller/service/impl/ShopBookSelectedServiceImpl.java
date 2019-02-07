package ua.od.BookSeller.service.impl;

import ua.od.BookSeller.dto.ShopSelectedDto;
import ua.od.BookSeller.model.ShopSelectedEntity;
import ua.od.BookSeller.repository.dao.ShopBookSelectedDao;
import ua.od.BookSeller.service.ShopBookSelectedService;

public class ShopBookSelectedServiceImpl implements ShopBookSelectedService {

    public ShopBookSelectedDao bookDao;


    @Override
    public ShopSelectedDto BookInshop(Integer id) {
        ShopSelectedDto book = new ShopSelectedDto();
        ShopSelectedEntity bookEntity = bookDao.BookInshop(id);
        book.setBookName(bookEntity.getBookName());
        book.setDescription(bookEntity.getDescription());
        book.setAuthorName(bookEntity.getAuthorName());
        bookEntity.setAuthorSername(bookEntity.getAuthorSername());
        book.setAuthorPatronymic(bookEntity.getAuthorPatronymic());
        return book;
    }
}
