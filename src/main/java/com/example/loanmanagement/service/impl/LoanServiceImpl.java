package com.example.loanmanagement.service.impl;

import com.example.loanmanagement.dto.LoanDto;
import com.example.loanmanagement.dto.request.LoanRequest;
import com.example.loanmanagement.model.Loan;
import com.example.loanmanagement.repository.LoanRepository;
import com.example.loanmanagement.service.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class LoanServiceImpl implements LoanService {
    final LoanRepository loanRepository;
    @Override
    public LoanDto getLoanById(Long id) {
        Loan loan = loanRepository.getLoanById(id);
        return LoanDto.builder()
                .date(loan.getDate())
                .amount(loan.getAmount())
                .payment(loan.getPayment())
                .build();
    }

    @Override
    public void saveLoan(LoanRequest loanRequest) {
        Loan loan = Loan.builder()
                .date(loanRequest.getDate())
                .amount(loanRequest.getAmount())
                .payment(loanRequest.getPayment())
                .build();

    }

    @Override
    public void updateLoan(LoanRequest loanRequest) {
        Loan loan = Loan.builder()
                .id(loanRequest.getId())
                .date(loanRequest.getDate())
                .amount(loanRequest.getAmount())
                .duration(loanRequest.getDuration())
                .payment(loanRequest.getPayment())
                .build();

    }


    @Override
    public List<LoanDto> getAll() {
        List<Loan> loans = loanRepository.findAll();
        List<LoanDto> loanDtos = new ArrayList<>();
        for(Loan loan : loans)
        {
            LoanDto loanDto = LoanDto.builder()
                    .date(loan.getDate())
                    .amount(loan.getAmount())
                    .payment(loan.getPayment())
                    .build();
            loanDtos.add(loanDto);
        }
        return loanDtos;

    }

    @Override
    public void deleteById(Long id) {
        Loan loan = loanRepository.getLoanById(id);
        loanRepository.deleteById(id);

    }
}
