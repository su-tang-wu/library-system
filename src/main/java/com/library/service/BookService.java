package com.library.service;

import com.library.entity.Book;
import com.library.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookMapper bookMapper;

    public List<Book> getAllBooks(int page, int size) {
        int start = (page - 1) * size;
        return bookMapper.findAll(start, size);
    }

    public Book getBookById(Integer id) {
        return bookMapper.findById(id);
    }

    @Transactional
    public void addBook(Book book) {
        bookMapper.add(book);
    }

    @Transactional
    public void updateBook(Book book) {
        bookMapper.update(book);
    }

    @Transactional
    public void deleteBook(Integer id) {
        bookMapper.delete(id);
    }

    @Transactional
    public boolean borrowBook(Integer bookId) {
        Book book = bookMapper.findById(bookId);
        if (book == null || book.getStock() <= 0) {
            return false;
        }
        bookMapper.reduceStock(bookId);
        return true;
    }

    @Transactional
    public void returnBook(Integer bookId) {
        bookMapper.increaseStock(bookId);
    }
}

