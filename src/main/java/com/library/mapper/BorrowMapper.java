package com.library.mapper;

import com.library.entity.Borrow;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface BorrowMapper {
    void add(Borrow borrow);
    void updateReturnTime(Integer id);
    List<Borrow> findByUserId(Integer userId);
}
