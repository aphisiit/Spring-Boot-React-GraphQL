package com.example.demoql.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.demoql.entity.Book;
import com.example.demoql.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookQuery implements GraphQLQueryResolver {

    @Autowired
    private BookService bookService;

    public Book getBook(Long id) {
        return bookService.findById(id);
    }

    public List<Book> getBooks() {
        return bookService.findAll();
    }
}
