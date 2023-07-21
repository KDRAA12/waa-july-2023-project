package com.alumni.Service.impls;

import com.alumni.Service.CityService;
import com.alumni.dtos.response.CityResponseDTO;
import com.alumni.entity.JobApplication;
import com.alumni.entity.Role;
import com.alumni.entity.enums.RoleEnum;
import com.alumni.repository.CityRepository;
import com.alumni.repository.RoleRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CityServiceImpl implements CityService {
    public final CityRepository repository;
    public final ModelMapper modelMapper;

    @Override
    public List<CityResponseDTO> getList() {
        return repository.findAll().stream().map(city -> modelMapper.map(city, CityResponseDTO.class)).collect(Collectors.toList());
    }

    @Override
    public CityResponseDTO findById(Long id) {
        return modelMapper.map(repository.findById(id), CityResponseDTO.class);
    }

    @Override
    public List<CityResponseDTO> FindAllByStateId(Long stateId){
        return repository.findAllByStateId(stateId).stream().map(city -> modelMapper.map(city, CityResponseDTO.class)).collect(Collectors.toList());
    }



}
