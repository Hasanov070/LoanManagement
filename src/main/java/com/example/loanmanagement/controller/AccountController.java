package com.example.loanmanagement.controller;

import com.example.loanmanagement.dto.AccountDto;
import com.example.loanmanagement.dto.request.AccountRequest;
import com.example.loanmanagement.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/account")
@RequiredArgsConstructor
public class AccountController {
    final AccountService accountService;

    @GetMapping(value = "/accountList")
    public List<AccountDto> getAccountInto(){
        return accountService.getAll();
    }
    @GetMapping(value = "/getAccountById/{id}")
    public AccountDto getAccountById(@PathVariable(value = "id")Long id){
        return accountService.getAccountById(id);
    }
    @PostMapping(value = "/saveAccount")
    public void saveAccount(@RequestBody AccountRequest accountRequest){
        accountService.saveAccount(accountRequest);
    }
    @PostMapping(value = "/updateAccount")
    public void updateAccount(@RequestBody AccountRequest accountRequest)
    {
        accountService.updateAccount(accountRequest);
    }
    @DeleteMapping(value = "/deleteById/{id}")
    public void deleteById(@PathVariable(value = "id")Long id)
    {
        accountService.deleteById(id);
    }
}
