package com.lhxone.dao;

import com.lhxone.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class DaoTest {
    @Autowired
    private BookDao bookDao;

    @Test
    void TestGet() {
        List<Book> books = bookDao.selectList(null);
        books.forEach(System.out::println);
    }
}
