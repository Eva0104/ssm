package com.zhuxiaoxue.service;


import com.zhuxiaoxue.mapper.BookMapper;
import com.zhuxiaoxue.pojo.Book;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@Transactional
public class BookService {

    @Inject
    private BookMapper bookMapper;

    public Book findById(Integer id){
        return bookMapper.findById(id);
    }

    public List<Book> findAllBooks(){
        return bookMapper.findAll();
    }

    public void save(Book book){
        bookMapper.save(book);
    }

    public void del(Integer id){
        bookMapper.del(id);
    }

    public void update(Book book){
        bookMapper.update(book);
    }





}
