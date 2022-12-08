package com.lhxone.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lhxone.domain.Book;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface BookDao extends BaseMapper<Book> {
}
