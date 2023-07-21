package com.alumni.Service;

import com.alumni.dtos.response.CityResponseDTO;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface CityService {
    List<CityResponseDTO> getList();
    CityResponseDTO findById(Long id);

    List<CityResponseDTO> FindAllByStateId(Long stateId);

}
