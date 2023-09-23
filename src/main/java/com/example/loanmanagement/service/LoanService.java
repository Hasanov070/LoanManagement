package com.example.loanmanagement.service;

import com.example.loanmanagement.dto.LoanDto;
import com.example.loanmanagement.dto.request.LoanRequest;

import java.util.List;

public interface LoanService {
    LoanDto getLoanById(Long id);
    void saveLoan(LoanRequest loanRequest);
    void updateLoan(LoanRequest loanRequest);
    List<LoanDto> getAll();
    void deleteById(Long id);
}
