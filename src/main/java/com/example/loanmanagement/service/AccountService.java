package com.example.loanmanagement.service;

import com.example.loanmanagement.dto.AccountDto;
import com.example.loanmanagement.dto.request.AccountRequest;

import java.util.List;

public interface AccountService {
    AccountDto getAccountById(Long id);

    void saveAccount(AccountRequest accountRequest);

    void updateAccount(AccountRequest accountRequest);

    List<AccountDto> getAll();

    void deleteById(Long id);
}

