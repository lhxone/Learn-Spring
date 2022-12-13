package com.lhxone;

import com.lhxone.dao.BookDao;
import com.lhxone.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

@SpringBootTest
class Spring002MongodbApplicationTests {

    @Autowired
    MongoTemplate mongoTemplate;
    @Autowired
    BookDao bookDao;

    @Test
    void MySql2MongoDB() {
        List<Book> allBooks = bookDao.selectList(null);
        allBooks.forEach(book -> mongoTemplate.save(book));
    }

    @Test
    void SaveBook() {

        Book book =new Book();
        book.setId(2);
        book.setName("spring");
        book.setType("spring-boot");
        book.setDescription("mongodb");
        System.out.println(book);
        mongoTemplate.save(book);

    }

    @Test
    void DeleteAllBook() {
        mongoTemplate.remove(null);
    }

    @Test
    void GetBook() {
        List<Book> bookList = mongoTemplate.findAll(Book.class);
        bookList.forEach(System.out::println);
    }
}
