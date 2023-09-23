package com.example.loanmanagement.repository;

import com.example.loanmanagement.model.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistrictRepository extends JpaRepository<District, Long> {
    District getDistrictById(Long id);
}
