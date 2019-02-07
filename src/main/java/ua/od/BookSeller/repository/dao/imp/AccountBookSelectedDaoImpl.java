package ua.od.BookSeller.repository.dao.imp;

import ua.od.BookSeller.model.AccountSelectedEntity;
import ua.od.BookSeller.model.AuthorEntity;
import ua.od.BookSeller.model.GanreEntity;
import ua.od.BookSeller.repository.dao.AccountBookSelectedDao;
import ua.od.BookSeller.repository.helper.SQLHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AccountBookSelectedDaoImpl implements AccountBookSelectedDao {

    private AccountSelectedEntity book;
    private String GET_SELECTED_BOOK =
            "Select Book.Name as b_name, Book.description as b_description,Book.content as b_content \n" +
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
                    "Inner Join Book_account\n" +
                    "On Book_account.book_id = Book.id\n" +
                    "Inner Join Account\n" +
                    "On Book_account.account_id = Account.id\n" +
                    "Where Account.id = ? and Book.id = ?;";
    @Override
    public AccountSelectedEntity selectedBook(Integer a_id, Integer b_id) {
        book = new AccountSelectedEntity();
        SQLHelper.prepareStatement(GET_SELECTED_BOOK, bookSelected ->{
            bookSelected.setInt(1,b_id);
            bookSelected.setInt(2,a_id);
            ResultSet rs = bookSelected.executeQuery();
            int count = 1;
            while(rs.next())
            {
                if(count==1)
                {
                    book.setBookName(rs.getString("b_name"));
                    book.setDescription(rs.getString("b_description"));
                    book.setPublishingHouse(rs.getString("p_house"));
                    book.setContent(rs.getString("b_content"));
                    count++;
                }
                book.setAuthors(fillAuthors(rs,book.getAuthors()));
                book.setGanres(fillGanres(rs,book.getGanres()));
            }
            return book;
        });
        return book;
    }

    private static List<AuthorEntity> fillAuthors(ResultSet rs, List<AuthorEntity> authorEntityList) throws SQLException{
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


}
