package com.example.demoql.query;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.demoql.entity.Book;
import com.example.demoql.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookMutation implements GraphQLMutationResolver {

    @Autowired
    private BookService bookService;

    public Book createBook(String name, String isbn, String author, Float price) {
        return bookService.createBook(name, isbn, author, price);
    }
}
