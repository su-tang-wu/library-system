package com.library.controller;

import com.library.entity.User;
import com.library.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/borrow")
public class BorrowController {
    @Autowired
    private BorrowService borrowService;

    @PostMapping("/{bookId}")
    public Map<String, Object> borrowBook(@PathVariable Integer bookId, HttpSession session) {
        Map<String, Object> result = new HashMap<>();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            result.put("success", false);
            result.put("msg", "请先登录");
            return result;
        }
        boolean success = borrowService.borrowBook(user.getId(), bookId);
        result.put("success", success);
        result.put("msg", success ? "借阅成功" : "库存不足");
        return result;
    }

    @PutMapping("/{borrowId}/{bookId}")
    public Map<String, Object> returnBook(@PathVariable Integer borrowId, @PathVariable Integer bookId) {
        borrowService.returnBook(borrowId, bookId);
        Map<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("msg", "归还成功");
        return result;
    }
}
