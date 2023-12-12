package com.example.rmsoft.controller;

import com.example.rmsoft.model.base.BaseResponse;
import com.example.rmsoft.model.dto.LoanReq;
import com.example.rmsoft.model.dto.LoanRes;
import com.example.rmsoft.service.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loan")
@RequiredArgsConstructor
public class LoanController {

    private final LoanService loanService;

    @GetMapping("/{bookId}")
    public BaseResponse<List<LoanRes>> getLoanHistory(@PathVariable long bookId) {
        return new BaseResponse<>(loanService.getLoanHistory(bookId));
    }

    @PostMapping("")
    public BaseResponse<Void> borrowing(@RequestBody LoanReq loanReq) {
        loanService.borrowing(loanReq);
        return new BaseResponse<>();
    }

    @PatchMapping("/{loanId}")
    public BaseResponse<Void> returnBook(@PathVariable long loanId) {
        loanService.returnBook(loanId);
        return new BaseResponse<>();
    }

}
