package ua.od.BookSeller.repository.dao.imp;

import ua.od.BookSeller.model.SelectedInShopEntity;
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
    public String BookInshop(Integer id) {
        return SQLHelper.prepareStatement(GET_SELECTED_BOOKS, statement->{
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            new SelectedInShopEntity(){{
                    setBookName(resultSet.getString("b_name"));
                    setPrice(resultSet.getFloat("b_price"));
                    setDescription(resultSet.getString("description"));
                    setAuthorName(resultSet.getString("a_name"));
                    setAuthorSername(resultSet.getString("a_sername"));
                    setAuthorPatronymic(resultSet.getString("a_patronymic"));
            }};
            return null;
        });
    }
}
