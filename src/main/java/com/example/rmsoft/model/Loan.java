package com.example.rmsoft.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Loan {

    private long loanId;
    private long memberId;
    private long bookId;
    private String status;
    private LocalDateTime loanDate;
    private LocalDateTime dueDate;
    private LocalDateTime returnDate;

    public Loan(long memberId, long bookId, String status, LocalDateTime loanDate, LocalDateTime dueDate) {
        this.memberId = memberId;
        this.bookId = bookId;
        this.status = status;
        this.loanDate = loanDate;
        this.dueDate = dueDate;
    }
}
