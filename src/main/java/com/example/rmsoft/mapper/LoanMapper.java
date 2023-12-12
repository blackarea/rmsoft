package com.example.rmsoft.mapper;

import com.example.rmsoft.model.Loan;
import com.example.rmsoft.model.dto.LoanRes;
import org.apache.ibatis.annotations.*;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface LoanMapper {

    @Select("SELECT l.status, l.member_id, m.name, l.loan_date, l.return_date FROM LOAN l " +
            "join MEMBER m on l.member_id = m.member_id " +
            "WHERE l.book_id = #{bookId}")
    List<LoanRes> getLoanHistory(long bookId);

    @Insert("INSERT INTO LOAN(member_id, book_id, status, loan_date, due_date)" +
            "values (#{memberId}, #{bookId}, #{status}, #{loanDate}, #{dueDate})")
    @Options(useGeneratedKeys = true, keyProperty = "loanId")
    int borrowing(Loan loan);

    @Update("UPDATE LOAN SET status = 'RETURN', return_date = #{returnDate}" +
            "WHERE loan_id = #{loanId}")
    int returnBook(@Param("loanId") long loanId, @Param("returnDate") LocalDateTime returnDate);

}
