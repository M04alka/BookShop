package ua.od.BookSeller.repository.dao.imp;


import ua.od.BookSeller.model.ShopSelectedEntity;
import ua.od.BookSeller.repository.dao.ShopBookSelectedDao;
import ua.od.BookSeller.repository.helper.SQLHelper;

import java.sql.ResultSet;

public class ShopBookSelectedDaoImpl implements ShopBookSelectedDao {

    private static  String GET_SELECTED_BOOKS =
            "Select Book.id, Book.Name as b_name, Book.price as b_price, Book.description, " +
            "Author.name as a_name, Author.sername as a_sername, Author.patronymic as a_patronymic\n" +
            "From Book_Author\n" +
            "Inner join Book\n" +
            "On Book_author.book_id =Book.id\n" +
            "Inner  Join Author\n" +
            "On Book_author.Author_id = Author.id\n"+
            "Where Book.id = ?;";

    @Override
    public ShopSelectedEntity bookInshop(Integer id) {
        return SQLHelper.prepareStatement(GET_SELECTED_BOOKS, statement->{
            statement.setInt(1,id);
            ShopSelectedEntity book = new ShopSelectedEntity();
            ResultSet resultSet = statement.executeQuery();
            book.setBookName(resultSet.getString("b_name"));
            book.setPrice(resultSet.getFloat("b_price"));
            book.setDescription(resultSet.getString("description"));
            book.setAuthorName(resultSet.getString("a_name"));
            book.setAuthorSername(resultSet.getString("a_sername"));
            book.setAuthorPatronymic(resultSet.getString("a_patronymic"));
            return book;
        });
    }

    private static  String ADD_NEW_BOOK = "" +
            "Insert into Book_account (book_id,account_id)\n" +
            "values(?,?);";

    @Override
    public void addBook(Integer a_id, Integer b_id) {
        SQLHelper.prepareStatement(ADD_NEW_BOOK, book -> {
            book.setInt(1,b_id);
            book.setInt(2,a_id);
            ResultSet rs = book.executeQuery();
            return book.executeUpdate();
        });
    }
    private static  String GET_MONEY =
            "Select account.creditCardNumber as a_money\n" +
            "From Account\n" +
            "Where Account = ?;";

    @Override
    public Float checkMoney(Integer a_id) {
        return SQLHelper.prepareStatement(GET_MONEY, money -> {
            Float accountMoney = 0f;
            money.setInt(1,a_id);
            ResultSet rs = money.executeQuery();
            accountMoney = rs.getFloat("a_money");
            return accountMoney;
        });
    }
}
