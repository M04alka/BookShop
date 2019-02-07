package ua.od.BookSeller.service.impl;

import ua.od.BookSeller.dto.AccountDto;
import ua.od.BookSeller.model.AccountEntity;
import ua.od.BookSeller.model.NewAccountEntity;
import ua.od.BookSeller.repository.dao.AccountDao;
import ua.od.BookSeller.service.AccountService;

import javax.inject.Inject;
import java.util.UUID;

public class AccountServiceImpl implements AccountService {

    private static boolean verify;

    @Inject
    public AccountDao accountDao;
    private AccountEntity accountEntity;


    @Override
    public String loginAccount(AccountDto user) {

        String verification= "";
        boolean testing = authentication(user);
        if(testing = true) {
            verification = "exist";
        }
        else {
            verification = "not exist";
        }
        return verification;
    }

    @Override
    public String createNewUser(AccountDto user) {
        return accountDao.createNewUser(new NewAccountEntity() {{
            setName(user.getName());
            setPassword(user.getPassword());
        }});
    }

    public Boolean authentication(AccountDto user){

        accountDao.loginUser().forEach(AccountEntity -> {
            if(AccountEntity.getName().equals(user.getName())&&
                    AccountEntity.getPassword().equals(user.getPassword())){
                verify = true;
            }
            else {
                verify = false;
            }
        });
        return verify;
    }

}
