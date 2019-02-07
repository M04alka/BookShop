package ua.od.BookSeller.repository.dao.imp;

import ua.od.BookSeller.model.AccountEntity;
import ua.od.BookSeller.model.NewAccountEntity;
import ua.od.BookSeller.repository.dao.AccountDao;
import ua.od.BookSeller.repository.helper.SQLHelper;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AccountDaoImpl implements AccountDao {

    private static final String GET_CREDENTILAS = "Select * from Account";

    @Override
    public List<AccountEntity> loginUser() {
        return SQLHelper.prepareStatement(GET_CREDENTILAS, statement->{
            List<AccountEntity> accounts = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                accounts.add(new AccountEntity(){{
                    setId(resultSet.getInt("Id"));
                    setName(resultSet.getString("Login"));
                    setPassword(resultSet.getString("Password"));
                }});
            }
        return accounts;
    });
    }

    @Override
    public String createNewUser(NewAccountEntity user) {

        String token = SQLHelper.prepareStatement("INSERT INTO User(name, password) values(?,?)", pstmt -> {
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getPassword());
            return pstmt.executeUpdate();
        });

        return null;
    }
}
