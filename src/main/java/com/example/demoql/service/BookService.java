package com.example.demoql.service;

import com.example.demoql.entity.Book;
import com.example.demoql.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

public interface BookService {
    Book findById(Long id);
    List<Book> findAll();
    Book createBook(String name, String isbn, String author, Float price);
}

@Service
class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book findById(Long id) {
        return bookRepository.findById(id).get();
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book createBook(String name, String isbn, String author, Float price) {
        Book book = new Book();
        book.setPublishDate(new Date());
        book.setName(name);
        book.setIsbn(isbn);
        book.setAuthor(author);
        book.setPrice(price);
        return bookRepository.save(book);
    }
}
