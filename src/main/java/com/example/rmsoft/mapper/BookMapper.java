package com.example.rmsoft.mapper;

import com.example.rmsoft.model.Book;
import org.apache.ibatis.annotations.*;

@Mapper
public interface BookMapper {

    @Insert("insert into BOOK(ISBN, name, author, publisher, pub_date)" +
            "values (#{ISBN}, #{name}, #{author}, #{publisher}, #{pub_date})")
    @Options(useGeneratedKeys = true, keyProperty = "book_id")
    int insert(Book book);

    @Select("SELECT * FROM BOOK WHERE book_id = #{book_id}")
    Book getBookById(long book_id);

    @Select("SELECT * FROM BOOK WHERE name = #{name}")
    Book getBookByName(String name);

    @Update("UPDATE BOOK SET ISBN = #{ISBN}, name = #{name}, author = #{author}, " +
            "publisher = #{publisher}, pub_date = #{pub_date} WHERE book_id = #{book_id}")
    int update(Book book);

    @Delete("DELETE FROM BOOK WHERE book_id = #{book_id}")
    int delete(long book_id);
}
