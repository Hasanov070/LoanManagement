package com.example.loanmanagement.repository;

import com.example.loanmanagement.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Long> {
    Loan getLoanById(Long id);
}
