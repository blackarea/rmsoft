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

    @Transactional(readOnly = true)
    public Book getBookById(long bookId){
        return bookMapper.getById(bookId);
    }

    @Transactional(readOnly = true)
    public Book getBookByName(String name){
        return bookMapper.getByName(name);
    }

    public void update(Book book){
        bookMapper.update(book);
    }

    public void delete(long bookId){
        bookMapper.delete(bookId);
    }

}
