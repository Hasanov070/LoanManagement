package com.example.loanmanagement.controller;

import com.example.loanmanagement.dto.LoanDto;
import com.example.loanmanagement.dto.request.LoanRequest;
import com.example.loanmanagement.service.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/loan")
@RequiredArgsConstructor
public class LoanController {
    final LoanService loanService;

    @GetMapping(value = "/loanList")
    public List<LoanDto> getLoanInfo(){
        return loanService.getAll();
    }
    @GetMapping(value = "/getLoanById/{id}")
    public LoanDto getLoanById(@PathVariable(value = "id")Long id){
        return loanService.getLoanById(id);
    }
    @PostMapping(value = "/saveLoan")
    public void saveLoan(@RequestBody LoanRequest loanRequest)
    {
        loanService.saveLoan(loanRequest);
    }
    @PostMapping(value = "/updateLoan")
    public void updateLoan(@RequestBody LoanRequest loanRequest){
        loanService.updateLoan(loanRequest);
    }
    @DeleteMapping(value = "/deleteById/{id}")
    public void deleteById(@PathVariable(value = "id")Long id)
    {
        loanService.deleteById(id);
    }
}
