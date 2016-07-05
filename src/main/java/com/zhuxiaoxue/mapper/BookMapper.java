package com.zhuxiaoxue.mapper;

import com.zhuxiaoxue.pojo.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by Eric on 2016/7/5.
 */
public interface BookMapper {

    List<Book> findAll();

    void save(Book book);

    void update(Book book);

    void del(Integer id);

    Book findById(Integer id);

    List<Book> findByPage(@Param("start") Integer start,@Param("size") Integer size);

    Long count();

    Long countByParams(Map<String,Object> params);

    List<Book> findByParams(Map<String,Object> params);
}
