package com.example.loanmanagement.controller;

import com.example.loanmanagement.dto.DistrictDto;
import com.example.loanmanagement.dto.request.DistrictRequest;
import com.example.loanmanagement.service.DistrictService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/district")
@RequiredArgsConstructor
public class DistrictController {
    final DistrictService districtService;

    @GetMapping(value = "/districtList")
    public List<DistrictDto> getDistrictInfo(){
        return districtService.getAll();
    }
    @GetMapping(value = "/getDistrictById/{id}")
    public DistrictDto getDistrictById(@PathVariable(value = "id")Long id){
        return districtService.getDistrictById(id);
    }
    @PostMapping(value = "/saveDistrict")
    public void saveDistrict(@RequestBody DistrictRequest districtRequest)
    {
        districtService.saveDistrict(districtRequest);
    }
    @PostMapping(value = "/updateDistrict")
    public void updateDistrict(@RequestBody DistrictRequest districtRequest)
    {
        districtService.updateDistrict(districtRequest);
    }
    @DeleteMapping(value = "/delteById/{id}")
    public void deleteById(@PathVariable(value = "id")Long id)
    {
        districtService.deleteById(id);
    }
}
