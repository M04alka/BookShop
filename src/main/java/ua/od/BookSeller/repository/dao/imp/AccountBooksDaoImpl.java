package ua.od.BookSeller.repository.dao.imp;

import ua.od.BookSeller.model.AccountBooksEntity;
import ua.od.BookSeller.model.AuthorEntity;
import ua.od.BookSeller.repository.dao.AccountBooksDao;
import ua.od.BookSeller.repository.helper.SQLHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountBooksDaoImpl implements AccountBooksDao {

    private final String GET_ALL_BOOKS_IN_ACCOUNT =
            "Select Book.id as b_id, Book.name as b_name, Author.name as a_name, Author.sername as a_sername, Author.patronymic as a_patronymic\n" +
            "From Book_Author\n" +
            "Inner Join Book \n" +
            "On Book_author.book_id =Book.id\n" +
            "Inner  Join Author\n" +
            "On Book_author.Author_id = Author.id\n" +
            "Where Book.id In (Select Book_id From Book_account where Account.id = ?);";

    @Override
    public List<AccountBooksEntity> getAllAccountBoks(Integer id) {
        return SQLHelper.prepareStatement(GET_ALL_BOOKS_IN_ACCOUNT, statement ->{
            statement.setInt(1,id);
            List<AccountBooksEntity> accountBooks = new ArrayList<>();
            ResultSet rs = statement.executeQuery();
            AccountBooksEntity accountBooksEntity = null;
            int currentId = -1;
            while(rs.next()){
                int bookId = rs.getInt("b_id");
                if(currentId != bookId) {
                    accountBooks.add(new AccountBooksEntity(){{
                    setName(rs.getString("b_name"));
                    setAuthors(new ArrayList<>());}
                });
                }
                fillAuthors(rs, accountBooksEntity.getAuthors());
            }
            return  accountBooks;
        });
    }

    private void fillAuthors(ResultSet rs ,List<AuthorEntity> authorsEntities) throws SQLException {
        authorsEntities.add(new AuthorEntity(){{
            setName(rs.getString("a_name"));
            setSername(rs.getString("a_sername"));
            setPatronymic(rs.getString("a_patronymic"));
        }});
    };
}
