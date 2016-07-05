package com.zhuxiaoxue.controller;


import com.google.common.collect.Maps;
import com.zhuxiaoxue.pojo.Book;
import com.zhuxiaoxue.service.BookService;
import com.zhuxiaoxue.util.Page;
import com.zhuxiaoxue.util.Strings;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/books")
public class BookController {

    @Inject
    private BookService bookService;

    @RequestMapping(method = RequestMethod.GET)
    public String list(@RequestParam(required = false,defaultValue = "1") Integer p,
                       @RequestParam(required = false)String bookname,
                       @RequestParam(required = false)String type,
                       @RequestParam(required = false)String pub,
                       Model model){

        Map<String,Object> params = Maps.newHashMap();

        bookname = Strings.toUTF8(bookname);

        params.put("bookname",bookname);
        params.put("type",type);
        params.put("pub",pub);

        Page<Book> page = bookService.findByParams(p,params);

        model.addAttribute("page",page);
        model.addAttribute("bookPubList",bookService.findAllPub());
        model.addAttribute("bookTypeList",bookService.findAllBookType());

        model.addAttribute("bookname",bookname);
        model.addAttribute("typeid",type);
        model.addAttribute("pubid",pub);

        return "/books/list";
    }

    @RequestMapping(value = "/new",method = RequestMethod.GET)
    public String add(Model model){

        model.addAttribute("bookPubList",bookService.findAllPub());
        model.addAttribute("bookTypeList",bookService.findAllBookType());
        return "/books/new";
    }

    @RequestMapping(value = "/new",method = RequestMethod.POST)
    public String add(Book book){
        bookService.save(book);
        return "redirect:/books";
    }

    @RequestMapping(value = "/{id:\\d+}/del",method = RequestMethod.GET)
    public String del(@PathVariable Integer id, RedirectAttributes redirectAttributes){
        bookService.del(id);
        redirectAttributes.addFlashAttribute("message","删除成功");
        return "redirect:/books";
    }

    @RequestMapping(value = "/{id:\\d+}/update",method = RequestMethod.GET)
    public String update(@PathVariable Integer id, Model model){
        Book book = bookService.findById(id);

        model.addAttribute("book",book);
        model.addAttribute("bookPubList",bookService.findAllPub());
        model.addAttribute("bookTypeList",bookService.findAllBookType());

        return "/books/update";
    }

    @RequestMapping(value = "/{id:\\d+}/update",method = RequestMethod.POST)
    public String update(Book book,RedirectAttributes redirectAttributes){
        bookService.update(book);
        redirectAttributes.addFlashAttribute("message","修改成功");
        return "redirect:/books";
    }




}
