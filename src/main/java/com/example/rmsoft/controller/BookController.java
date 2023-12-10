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

    @GetMapping("/{book_id}")
    public BaseResponse<Book> getBookById(@PathVariable long book_id) {
        return new BaseResponse<>(bookService.getBookById(book_id));
    }

    @PutMapping("")
    public BaseResponse<Void> updateBook(@RequestBody Book book) {
        bookService.update(book);
        return new BaseResponse<>();
    }

    @DeleteMapping("/{book_id}")
    public BaseResponse<Void> deleteBook(@PathVariable long book_id) {
        bookService.delete(book_id);
        return new BaseResponse<>();
    }
}
