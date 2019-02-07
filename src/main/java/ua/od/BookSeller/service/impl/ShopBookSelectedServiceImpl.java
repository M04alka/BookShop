package ua.od.BookSeller.service.impl;

import ua.od.BookSeller.dto.AuthorDto;
import ua.od.BookSeller.dto.GanreDto;
import ua.od.BookSeller.dto.ShopSelectedDto;
import ua.od.BookSeller.model.AuthorEntity;
import ua.od.BookSeller.model.GanreEntity;
import ua.od.BookSeller.model.ShopSelectedEntity;
import ua.od.BookSeller.repository.dao.ShopBookSelectedDao;
import ua.od.BookSeller.service.ShopBookSelectedService;

import java.util.ArrayList;
import java.util.List;

public class ShopBookSelectedServiceImpl implements ShopBookSelectedService {

    public ShopBookSelectedDao bookDao;


    @Override
    public ShopSelectedDto BookInshop(Integer id) {
        ShopSelectedDto book = new ShopSelectedDto();
        ShopSelectedEntity bookEntity = bookDao.bookInshop(id);
        book.setBookName(bookEntity.getBookName());
        book.setDescription(bookEntity.getDescription());
        book.setPrice(bookEntity.getPrice());
        book.setPublishingHouse(bookEntity.getPublishingHouse());
        book.setAuthors(fillAuthorList(bookEntity.getAuthors()));
        book.setGanres(fillGanreList(bookEntity.getGanres()));
        return book;
    }

    private List<AuthorDto> fillAuthorList(List<AuthorEntity> authorEntityList) {
        List<AuthorDto> authorDtoArrayList = new ArrayList<>();
        authorEntityList.forEach(authorEntity -> authorDtoArrayList.add(new AuthorDto() {
            {
                setName(authorEntity.getName());
                setSername(authorEntity.getSername());
                setPatronymic(authorEntity.getPatronymic());
            }
        }));
        return authorDtoArrayList;
    }

    private List<GanreDto> fillGanreList(List<GanreEntity> buildinSetLists) {
        List<GanreDto> ganreDtoList = new ArrayList<>();
        buildinSetLists.forEach(ganreEntity -> ganreDtoList.add(new GanreDto() {
            {
                setGanre(ganreEntity.getGanre());
            }
        }));
        return ganreDtoList;
    }

    @Override
    public String addBook(Integer a_id, Integer b_id) {
        String result = null;
        if(bookDao.bookInshop(b_id).getPrice()< bookDao.checkMoney(a_id))
        {
            bookDao.addBook(a_id,b_id);
            result = "Book Added";
        }
        else  result = "Not enought money!";
        return result ;
    }
}
