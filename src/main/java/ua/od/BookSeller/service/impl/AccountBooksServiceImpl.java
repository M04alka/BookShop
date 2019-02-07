package ua.od.BookSeller.service.impl;
import ua.od.BookSeller.dto.AccountBooksDto;
import ua.od.BookSeller.dto.AuthorDto;
import ua.od.BookSeller.model.AuthorEntity;
import ua.od.BookSeller.repository.dao.AccountBooksDao;
import ua.od.BookSeller.service.AccountBooksService;

import java.util.ArrayList;
import java.util.List;

public class AccountBooksServiceImpl implements AccountBooksService {

    public AccountBooksDao accountBooksDao;

    @Override
    public List<AccountBooksDto> getAllAccountBooks(Integer id) {
       List<AccountBooksDto> bookList = new ArrayList<>();
       accountBooksDao.getAllAccountBoks(id).forEach(accountBooksEntity ->
               bookList.add(new AccountBooksDto(){{
                   setName(accountBooksEntity.getName());
                   setAuthors(fillAuthors(accountBooksEntity.getAuthors()));
               }}));
       return  bookList;
    }


    private List<AuthorDto> fillAuthors(List<AuthorEntity> accountBooksEntities){
        List<AuthorDto> authorDtos = new ArrayList<>();
        accountBooksEntities.forEach(AuthorEntity -> authorDtos.add(new AuthorDto(){{
            setName(AuthorEntity.getName());
            setSername(AuthorEntity.getSername());
            setPatronymic(AuthorEntity.getPatronymic());
        }}));
        return authorDtos;
    }
}
