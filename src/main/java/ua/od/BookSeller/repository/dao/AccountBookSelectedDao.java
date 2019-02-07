package ua.od.BookSeller.repository.dao;

import ua.od.BookSeller.model.SelectedInAccountEntity;

public interface AccountBookSelectedDao {
 SelectedInAccountEntity selectedBook(Integer a_id, Integer b_id);
}
