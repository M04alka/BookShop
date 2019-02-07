package ua.od.BookSeller.repository.dao.imp;

import ua.od.BookSeller.model.ShopBooksEntity;
import ua.od.BookSeller.repository.dao.ShopBooksDao;
import ua.od.BookSeller.repository.helper.SQLHelper;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ShopBooksDaoImpl implements ShopBooksDao {

    private static  String GET_ALL_BOOKS="";

    public List<ShopBooksEntity> getAllBooks() {
        return SQLHelper.prepareStatement(GET_ALL_BOOKS, statement->{
            final ResultSet resultSet = statement.executeQuery();
            List<ShopBooksEntity> bookList = new ArrayList();
            while (resultSet.next()){
               bookList.add(new ShopBooksEntity(){{
                   setName(resultSet.getString(""));
                   setAuthorName(resultSet.getString(""));
                   setAuthotSername(resultSet.getString(""));
                   setAuthorPatronymic(resultSet.getString(""));
                   setPrice(resultSet.getFloat(""));
               }});
           }
            return bookList;
        });
    }
}
