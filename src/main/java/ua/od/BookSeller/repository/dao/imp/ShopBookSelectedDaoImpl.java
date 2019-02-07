package ua.od.BookSeller.repository.dao.imp;


import ua.od.BookSeller.model.AuthorEntity;
import ua.od.BookSeller.model.GanreEntity;
import ua.od.BookSeller.model.ShopSelectedEntity;
import ua.od.BookSeller.repository.dao.ShopBookSelectedDao;
import ua.od.BookSeller.repository.helper.SQLHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class ShopBookSelectedDaoImpl implements ShopBookSelectedDao {

    private static  String GET_SELECTED_BOOKS =
            "Select Book.id as b_id, Book.Name as b_name, Book.price as b_price, Book.description as b_description, \n" +
                    "Author.name as a_name, Author.sername as a_sername, Author.patronymic as a_patronymic,\n" +
                    "Publishing_house.name as p_house, Ganre.ganre\n" +
                    "From Book_Author\n" +
                    "Inner join Book\n" +
                    "On Book_author.book_id =Book.id\n" +
                    "Inner  Join Author\n" +
                    "On Book_author.Author_id = Author.id\n" +
                    "Inner join Book_ganre\n" +
                    "On Book_ganre.book_id = Book.id\n" +
                    "Inner join Ganre\n" +
                    "On Book_ganre.ganre_id = Ganre.id\n" +
                    "Inner Join Publishing_house\n" +
                    "On Book.publishinghouse_id = Publishing_house.id\n" +
                    "Where Book.id = ?;";

    @Override
    public ShopSelectedEntity bookInshop(Integer id) {
        return SQLHelper.prepareStatement(GET_SELECTED_BOOKS, statement->{
            statement.setInt(1,id);
            ShopSelectedEntity book = new ShopSelectedEntity();
            ResultSet rs = statement.executeQuery();
            int count = 1;
            while(rs.next()) {
                if(count==1)
                {
                    book.setBookName(rs.getString("b_name"));
                    book.setPrice(rs.getFloat("b_price"));
                    book.setDescription(rs.getString("description"));
                    book.setPublishingHouse(rs.getString("publishing_house"));
                    book.setAuthors(new LinkedList<AuthorEntity>());
                    book.setGanres(new LinkedList<GanreEntity>());
                    count++;
                }
                book.setAuthors(fillAuthors(rs, book.getAuthors()));
                book.setGanres(fillGanres(rs, book.getGanres()));

            }
            return book;
        });
    }

    private static List<AuthorEntity> fillAuthors(ResultSet rs,List<AuthorEntity> authorEntityList) throws SQLException {
        authorEntityList.add(new AuthorEntity(){{
            setName(rs.getString("a_name"));
            setSername(rs.getString("a_sername"));
            setPatronymic(rs.getString("a_patronymic"));
        }});
        return authorEntityList;
    }

    private static List<GanreEntity> fillGanres(ResultSet rs, List<GanreEntity> ganreEntityList) throws SQLException {
        ganreEntityList.add(new GanreEntity(){{
            setGanre(rs.getString("ganre"));
        }});
        return ganreEntityList;
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
