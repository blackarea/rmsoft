package com.example.rmsoft.service;

import com.example.rmsoft.mapper.LoanMapper;
import com.example.rmsoft.mapper.MemberMapper;
import com.example.rmsoft.model.Loan;
import com.example.rmsoft.model.dto.LoanReq;
import com.example.rmsoft.model.dto.LoanRes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class LoanService {

    private final LoanMapper loanMapper;
    private final MemberMapper memberMapper;

    public List<LoanRes> getLoanHistory(long bookId) {
        return loanMapper.getLoanHistory(bookId);
    }

    public void borrowing(LoanReq loanReq) {
        long memberId = memberMapper.getById(loanReq.getId()).getMemberId();
        Loan loan = new Loan(memberId, loanReq.getBookId(), "BORROWING", LocalDateTime.now(),
                LocalDateTime.now().truncatedTo(ChronoUnit.DAYS).plus(2, ChronoUnit.WEEKS));

        loanMapper.borrowing(loan);
    }

    public void returnBook(long loanId) {
        loanMapper.returnBook(loanId, LocalDateTime.now());
    }
}
