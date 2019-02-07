package ua.od.BookSeller.repository.dao;

import ua.od.BookSeller.model.AddNewBookEntity;
import ua.od.BookSeller.model.ShopSelectedEntity;

public interface ShopBookSelectedDao {
   ShopSelectedEntity bookInshop(Integer id);
   void addBook(Integer a_id, Integer b_id);
   Float checkMoney(Integer a_id);
 }

