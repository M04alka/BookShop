package ua.od.BookSeller.service.impl;

import ua.od.BookSeller.dto.AccountSelectedDto;
import ua.od.BookSeller.model.AccountSelectedEntity;
import ua.od.BookSeller.repository.dao.AccountBookSelectedDao;
import ua.od.BookSeller.repository.dao.imp.AccountBookSelectedDaoImpl;
import ua.od.BookSeller.service.AccountBookSelectedService;

public class AccountBookSelectedServiceImpl implements AccountBookSelectedService {

    private AccountBookSelectedDao accountBookSelectedDao;

    @Override

    public AccountSelectedDto selectedBook(Integer a_id, Integer b_id) {
        accountBookSelectedDao = new AccountBookSelectedDaoImpl();
        AccountSelectedDto bookSelected = new AccountSelectedDto();
        AccountSelectedEntity selectedInAccountEntity = accountBookSelectedDao.selectedBook(a_id,b_id);
        bookSelected.setBookName(selectedInAccountEntity.getBookName());
        bookSelected.setAuthorName(selectedInAccountEntity.getAuthorName());
        bookSelected.setAuthorSername(selectedInAccountEntity.getAuthorSername());
        bookSelected.setAuthorPatronymic(selectedInAccountEntity.getAuthorPatronymic());
        return bookSelected;
    }
}
