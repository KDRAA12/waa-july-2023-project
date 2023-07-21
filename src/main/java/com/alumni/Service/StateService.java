package com.alumni.Service;

import com.alumni.dtos.response.StateResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StateService {
    List<StateResponseDTO> getList();
    StateResponseDTO findById(Long id);

}
