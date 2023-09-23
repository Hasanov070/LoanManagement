package com.example.loanmanagement.service.impl;

import com.example.loanmanagement.dto.DistrictDto;
import com.example.loanmanagement.dto.request.DistrictRequest;
import com.example.loanmanagement.model.District;
import com.example.loanmanagement.repository.DistrictRepository;
import com.example.loanmanagement.service.DistrictService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service

public class DistrictServiceImpl implements DistrictService {
    final DistrictRepository districtRepository;
    @Override
    public DistrictDto getDistrictById(Long id) {
        District district = districtRepository.getDistrictById(id);
        return DistrictDto.builder()
                .region(district.getRegion())
                .build();
    }

    @Override
    public void saveDistrict(DistrictRequest districtRequest) {
        District district = District.builder()
                .region(districtRequest.getRegion())
                .build();


    }

    @Override
    public void updateDistrict(DistrictRequest districtRequest) {
        District district = District.builder()
                .id(districtRequest.getId())
                .region(districtRequest.getRegion())
                .people(districtRequest.getPeople())
                .build();

    }

    @Override
    public List<DistrictDto> getAll() {
        List<District> districts = districtRepository.findAll();
        List<DistrictDto> districtDtos = new ArrayList<>();
        for (District district : districts)
        {
            DistrictDto districtDto = DistrictDto.builder()
                    .region(district.getRegion())
                    .build();
            districtDtos.add(districtDto);
        }
        return  districtDtos;

    }

    @Override
    public void deleteById(Long id) {
        District district = districtRepository.getDistrictById(id);
        districtRepository.deleteById(id);

    }
}
