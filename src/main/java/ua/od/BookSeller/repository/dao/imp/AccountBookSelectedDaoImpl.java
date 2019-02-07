package ua.od.BookSeller.repository.dao.imp;

import ua.od.BookSeller.model.SelectedInAccountEntity;
import ua.od.BookSeller.repository.dao.AccountBookSelectedDao;
import ua.od.BookSeller.repository.helper.SQLHelper;

import java.sql.ResultSet;

public class AccountBookSelectedDaoImpl implements AccountBookSelectedDao {

    private SelectedInAccountEntity book;
    private String GET_SELECTED_BOOK =
            "Select Book.Name as b_name, Author.name as a_name, Author.sername as a_sername, Author.patronymic as a_patronymic\n" +
            "From Book_Author\n" +
            "Inner join Book\n" +
            "On Book_author.book_id =Book.id\n" +
            "Inner  Join Author\n" +
            "On Book_author.Author_id = Author.id\n" +
            "Where Account.id = ? and Book.id = ?;";
    @Override
    public SelectedInAccountEntity selectedBook(Integer a_id, Integer b_id) {
        book = new SelectedInAccountEntity();
        SQLHelper.prepareStatement(GET_SELECTED_BOOK, bookSelected ->{
            bookSelected.setInt(1,b_id);
            bookSelected.setInt(2,a_id);
            ResultSet rs = bookSelected.executeQuery();
            book.setAuthorName(rs.getString("b_name"));
            book.setAuthorName(rs.getString("a_name"));
            book.setAuthorSername(rs.getString("a_sername"));
            book.setAuthorPatronymic(rs.getString("a_patronymic"));
            return book;
        });
        return book;
    }
}
