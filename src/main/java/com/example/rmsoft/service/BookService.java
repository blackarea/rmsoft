package com.example.rmsoft.service;

import com.example.rmsoft.mapper.BookMapper;
import com.example.rmsoft.model.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class BookService {

    private final BookMapper bookMapper;

    public void insert(Book book){
        int result = bookMapper.insert(book);
    }

    public Book getBookById(long book_id){
        return bookMapper.getBookById(book_id);
    }

    public Book getBookByName(String name){
        return bookMapper.getBookByName(name);
    }

    public void update(Book book){
        bookMapper.update(book);
    }

    public void delete(long book_id){
        bookMapper.delete(book_id);
    }

}
