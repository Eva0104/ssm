package com.zhuxiaoxue.service;


import com.zhuxiaoxue.mapper.BookMapper;
import com.zhuxiaoxue.mapper.BookTypeMapper;
import com.zhuxiaoxue.mapper.PublisherMapper;
import com.zhuxiaoxue.pojo.Book;
import com.zhuxiaoxue.pojo.BookType;
import com.zhuxiaoxue.pojo.Publisher;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@Transactional
public class BookService {

    @Inject
    private BookMapper bookMapper;

    @Inject
    private BookTypeMapper bookTypeMapper;

    @Inject
    private PublisherMapper publisherMapper;

    public List<Publisher> findAllPub(){
        return publisherMapper.findAll();
    }

    public List<BookType> findAllBookType(){
        return bookTypeMapper.findAll();
    }

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
