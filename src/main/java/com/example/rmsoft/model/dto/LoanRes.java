package com.example.rmsoft.model.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Data
public class LoanRes {

    private String status;
    private long memberId;
    private String name;
    private String loanDate;
    private String returnDate;

    public LoanRes(String status, long memberId, String name, LocalDateTime loanDate, LocalDateTime returnDate) {
        this.status = status;
        this.memberId = memberId;
        this.name = name;
        this.loanDate = loanDate.format(DateTimeFormatter.ofPattern("yyyy.MM.dd"));
        Optional<LocalDateTime> returnDateOp = Optional.ofNullable(returnDate);
        if(returnDateOp.isPresent()){
            this.returnDate = returnDate.format(DateTimeFormatter.ofPattern("yyyy.MM.dd"));
        }else {
            this.returnDate = "";
        }

    }
}