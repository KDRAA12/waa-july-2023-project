package com.alumni.Service.impls;

import com.alumni.Service.StateService;
import com.alumni.dtos.response.StateResponseDTO;
import com.alumni.repository.CityRepository;
import com.alumni.repository.StateRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StateServiceImpl implements StateService {
    public final StateRepository repository;
    public final ModelMapper modelMapper;

    @Override
    public  List<StateResponseDTO> getList(){
        return repository.findAll().stream().map((state) -> modelMapper.map(state, StateResponseDTO.class)).collect(Collectors.toList());
    }

    @Override
    public StateResponseDTO findById(Long id){
        return modelMapper.map(repository.findById(id), StateResponseDTO.class);
    }

}
