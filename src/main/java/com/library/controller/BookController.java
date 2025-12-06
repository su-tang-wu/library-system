package com.library.controller;

import com.library.entity.Book;
import com.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import javax.xml.transform.Result;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public Map<String, Object> getBooks(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size) {
        Map<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("data", bookService.getAllBooks(page, size));
        return result;
    }

    @GetMapping("/{id}")
    public Map<String, Object> getBook(@PathVariable Integer id) {
        Map<String, Object> result = new HashMap<>();
        Book book = bookService.getBookById(id);
        result.put("success", book != null);
        result.put("data", book);
        return result;
    }

    @PostMapping
    public Map<String, Object> addBook(@RequestBody Book book) {
        bookService.addBook(book);
        Map<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("msg", "添加成功");
        return result;
    }

    // 正确的路径写法（无多余符号）
    @PutMapping("/{id}")
    public Map<String, Object> updateBook(@PathVariable Integer id, @RequestBody Book book) {
        book.setId(id);
        bookService.updateBook(book);
        Map<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("msg", "更新成功");
        return result;
    }
    @DeleteMapping("/{id}")
    public Map<String, Object> deleteBook(@PathVariable Integer id) {
        bookService.deleteBook(id);
        Map<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("msg", "删除成功");
        return result;
    }
}
