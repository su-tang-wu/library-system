package com.library.mapper;

import com.library.entity.Book;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface BookMapper {
    List<Book> findAll(int start, int size);
    Book findById(Integer id);
    void add(Book book);
    void update(Book book);
    void delete(Integer id);
    void reduceStock(Integer id);
    void increaseStock(Integer id);
}
