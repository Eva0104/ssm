package com.zhuxiaoxue.mapper;

import com.zhuxiaoxue.pojo.Book;

import java.util.List;

/**
 * Created by Eric on 2016/7/5.
 */
public interface BookMapper {

    List<Book> findAll();

    void save(Book book);

    void update(Book book);

    void del(Integer id);

    Book findById(Integer id);

}
