package com.example.rmsoft.mapper;

import com.example.rmsoft.model.Book;
import org.apache.ibatis.annotations.*;

@Mapper
public interface BookMapper {

    @Insert("insert into BOOK(ISBN, name, author, publisher, pub_date) " +
            "values (#{ISBN}, #{name}, #{author}, #{publisher}, #{pubDate})")
    @Options(useGeneratedKeys = true, keyProperty = "bookId")
    int insert(Book book);

    @Select("SELECT * FROM BOOK WHERE book_id = #{bookId}")
    Book getById(long bookId);

    @Select("SELECT * FROM BOOK WHERE name = #{name}")
    Book getByName(String name);

    @Update("UPDATE BOOK SET ISBN = #{ISBN}, name = #{name}, author = #{author}, " +
            "publisher = #{publisher}, pub_date = #{pubDate} WHERE book_id = #{bookId}")
    int update(Book book);

    @Delete("DELETE FROM BOOK WHERE book_id = #{bookId}")
    int delete(long book_id);
}
