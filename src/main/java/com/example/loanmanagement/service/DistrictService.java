package com.example.loanmanagement.service;

import com.example.loanmanagement.dto.DistrictDto;
import com.example.loanmanagement.dto.request.DistrictRequest;

import java.util.List;

public interface DistrictService {
    DistrictDto getDistrictById(Long id);
    void saveDistrict(DistrictRequest districtRequest);
    void updateDistrict(DistrictRequest districtRequest);
    List<DistrictDto> getAll();
    void deleteById(Long id);
}
