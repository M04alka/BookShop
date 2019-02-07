package ua.od.BookSeller.service.impl;

import ua.od.BookSeller.dto.AccountSelectedDto;
import ua.od.BookSeller.dto.AuthorDto;
import ua.od.BookSeller.dto.GanreDto;
import ua.od.BookSeller.model.AccountSelectedEntity;
import ua.od.BookSeller.model.AuthorEntity;
import ua.od.BookSeller.model.GanreEntity;
import ua.od.BookSeller.repository.dao.AccountBookSelectedDao;
import ua.od.BookSeller.repository.dao.imp.AccountBookSelectedDaoImpl;
import ua.od.BookSeller.service.AccountBookSelectedService;

import java.util.ArrayList;
import java.util.List;

public class AccountBookSelectedServiceImpl implements AccountBookSelectedService {

    private AccountBookSelectedDao accountBookSelectedDao;

    @Override

    public AccountSelectedDto selectedBook(Integer a_id, Integer b_id) {
        accountBookSelectedDao = new AccountBookSelectedDaoImpl();
        AccountSelectedDto bookSelected = new AccountSelectedDto();
        AccountSelectedEntity selectedInAccountEntity = accountBookSelectedDao.selectedBook(a_id,b_id);
        bookSelected.setBookName(selectedInAccountEntity.getBookName());
        bookSelected.setDescription(selectedInAccountEntity.getDescription());
        bookSelected.setPublishingHouse(selectedInAccountEntity.getPublishingHouse());
        bookSelected.setContent(selectedInAccountEntity.getContent());
        bookSelected.setAuthors(fillAuthorList(selectedInAccountEntity.getAuthors()));
        bookSelected.setGanres(fillGanreList(selectedInAccountEntity.getGanres()));
        return bookSelected;
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
}
