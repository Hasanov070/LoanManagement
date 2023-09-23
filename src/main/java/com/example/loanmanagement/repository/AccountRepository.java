package com.example.loanmanagement.repository;

import com.example.loanmanagement.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface AccountRepository extends JpaRepository<Account, Long> {
    Account getAccountById(Long id);
}
