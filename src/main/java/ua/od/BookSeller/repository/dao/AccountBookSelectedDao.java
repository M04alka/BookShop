package ua.od.BookSeller.repository.dao;

import ua.od.BookSeller.model.AccountSelectedEntity;

public interface AccountBookSelectedDao {
 AccountSelectedEntity selectedBook(Integer a_id, Integer b_id);
}
