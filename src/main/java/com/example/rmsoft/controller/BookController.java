package com.example.rmsoft.controller;

import com.example.rmsoft.model.Book;
import com.example.rmsoft.model.base.BaseResponse;
import com.example.rmsoft.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping("")
    public BaseResponse<Void> insertBook(@RequestBody Book book) {
        bookService.insert(book);
        return new BaseResponse<>();
    }

    @GetMapping("/{bookId}")
    public BaseResponse<Book> getBookById(@PathVariable long bookId) {
        return new BaseResponse<>(bookService.getBookById(bookId));
    }

    @PutMapping("")
    public BaseResponse<Void> updateBook(@RequestBody Book book) {
        bookService.update(book);
        return new BaseResponse<>();
    }

    @DeleteMapping("/{bookId}")
    public BaseResponse<Void> deleteBook(@PathVariable long bookId) {
        bookService.delete(bookId);
        return new BaseResponse<>();
    }
}
