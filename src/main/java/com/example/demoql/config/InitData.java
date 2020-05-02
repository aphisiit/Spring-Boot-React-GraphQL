package com.example.demoql.config;

import com.example.demoql.entity.Book;
import com.example.demoql.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//@Component
public class InitData implements CommandLineRunner {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public void run(String... args) throws Exception {
        Book book = new Book();
        book.setAuthor("Aphisit Namracha");
        book.setIsbn("1234-5678-9101");
        book.setNumberOfBook(10);
        book.setPrice(7.50F);

        bookRepository.save(book);
    }
}
