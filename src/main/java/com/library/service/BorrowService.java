package com.library.service;

import com.library.entity.Borrow;
import com.library.mapper.BorrowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class BorrowService {
    @Autowired
    private BorrowMapper borrowMapper;
    @Autowired
    private BookService bookService;

    @Transactional
    public boolean borrowBook(Integer userId, Integer bookId) {
        if (bookService.borrowBook(bookId)) {
            Borrow borrow = new Borrow();
            borrow.setUserId(userId);
            borrow.setBookId(bookId);
            borrowMapper.add(borrow);
            return true;
        }
        return false;
    }

    @Transactional
    public void returnBook(Integer borrowId, Integer bookId) {
        borrowMapper.updateReturnTime(borrowId);
        bookService.returnBook(bookId);
    }

    public List<Borrow> getBorrowsByUserId(Integer userId) {
        return borrowMapper.findByUserId(userId);
    }
}
