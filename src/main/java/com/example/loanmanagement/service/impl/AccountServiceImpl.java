package com.example.loanmanagement.service.impl;

import com.example.loanmanagement.dto.AccountDto;
import com.example.loanmanagement.dto.request.AccountRequest;
import com.example.loanmanagement.model.Account;
import com.example.loanmanagement.repository.AccountRepository;
import com.example.loanmanagement.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class AccountServiceImpl implements AccountService {
    final AccountRepository accountRepository;

    @Override
    public AccountDto getAccountById(Long id) {
        Account account = accountRepository.getAccountById(id);
        return AccountDto.builder()
                .frequency(account.getFrequency())
                .date(account.getDate())
                .build();
    }

    @Override
    public void saveAccount(AccountRequest accountRequest) {
        Account account = Account.builder()
                .frequency(accountRequest.getFrequency())
                .date(accountRequest.getDate()).
                build();


    }

    @Override
    public void updateAccount(AccountRequest accountRequest) {
        Account account = Account.builder()
                .id(accountRequest.getId())
                .frequency(accountRequest.getFrequency())
                .date(accountRequest.getDate())
                .build();

    }

    @Override
    public List<AccountDto> getAll() {
        List<Account> accounts = accountRepository.findAll();
        List<AccountDto> accountDtos = new ArrayList<>();
        for (Account account : accounts)
        {
            AccountDto accountDto = AccountDto.builder()
                    .frequency(account.getFrequency())
                    .date(account.getDate())
                    .build();
            accountDtos.add(accountDto);
        }
        return accountDtos;
    }

    @Override
    public void deleteById(Long id) {
        Account account = accountRepository.getAccountById(id);
        accountRepository.deleteById(id);

    }
}
