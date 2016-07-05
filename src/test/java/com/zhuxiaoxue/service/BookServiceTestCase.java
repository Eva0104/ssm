package com.zhuxiaoxue.service;


import com.zhuxiaoxue.pojo.Book;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:ApplicationContext.xml")
public class BookServiceTestCase {

    private Logger logger = LoggerFactory.getLogger(BookServiceTestCase.class);

    @Inject
    private BookService bookService;

    @Test
    public void testFindById(){
        Book book = bookService.findById(1);
        Assert.assertNotNull(book);
    }

    @Test
    public void testSave(){
        Book book = new Book();
        book.setBookname("SSM项目的基本配置");
        book.setBookauthor("XXX");
        book.setBooknum(10);
        book.setBookprice(20F);
        book.setPubid(1);
        book.setTypeid(1);

        bookService.save(book);

    }

    @Test
    public void testUpdate(){
        Book book = bookService.findById(36);
        book.setBookauthor("YYY");
        bookService.update(book);
    }

    @Test
    public void testFindAllBook(){
        List<Book> bookList = bookService.findAllBooks();
        Assert.assertEquals(bookList.size(),30);
    }

    @Test
    public void testDel(){
        bookService.del(36);
    }

}
