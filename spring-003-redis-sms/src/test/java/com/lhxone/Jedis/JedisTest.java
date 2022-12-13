package com.lhxone.Jedis;

import com.lhxone.dao.BookDao;
import com.lhxone.domain.Book;
import com.lhxone.utils.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

@SpringBootTest
public class JedisTest {

    @Autowired
    private BookDao bookDao;
    private JedisPool jedisPool = new JedisPool("localhost", 6379);

    @Test
    void TestPoolSet() {
        try (Jedis jedis = jedisPool.getResource()) {
            jedis.auth("123456");
            jedis.set("clientName", "Jedis");
        }
    }

    @Test
    void TestPoolGet() {
        try (Jedis jedis = jedisPool.getResource()) {
            jedis.auth("123456");
            String clientName = jedis.get("clientName");
            System.out.println(clientName);
        }
    }

    @Test
    void TestGenerateCode() {
        String code = new Code().GenerateCode();
        System.out.println(code);
        Jedis jedis = jedisPool.getResource();
        jedis.auth("123456");
        jedis.set("code",code);
    }

    @Test
    void TestGetBookFromRedis() {
        HashMap<Integer,String> books =new HashMap<>();
        try (Jedis jedis = jedisPool.getResource()) {
            jedis.auth("123456");
            for (int i = 0; i < 100; i++) {
                try {
                    String book = jedis.get(i + "");
                    books.put(i,book);
                }catch (Exception e){
                    continue;
                }
            }
        }
        System.out.println(books);
    }
}
