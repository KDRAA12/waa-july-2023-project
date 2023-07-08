package com.alumni.Service.impls;

import com.alumni.Exceptions.NotFoundException;
import com.alumni.Service.JobAdvertisementService;
import com.alumni.Service.TagService;
import com.alumni.dtos.request.JobAdvertisementRequestDto;
import com.alumni.dtos.request.TagRequestDTO;
import com.alumni.dtos.response.JobAdvertisementResponseDto;
import com.alumni.dtos.response.TagResponseDTO;
import com.alumni.entity.JobAdvertisement;
import com.alumni.entity.Tag;
import com.alumni.repository.JobAdvertisementRepository;
import com.alumni.repository.TagRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class TagServiceImpl implements TagService {
    private final ModelMapper modelMapper;


    @Autowired
    private final TagRepository repository;




    @Override
    public List<TagResponseDTO> getList(int page, int size) {
           return    repository.findAll(PageRequest.of(page,size)).stream().map((Tag tag)->modelMapper.map(tag,TagResponseDTO.class)).collect(Collectors.toList());
    }


    @Override
    public void create(TagRequestDTO requestDto) {
        Tag jobAdvertisement= modelMapper.map(requestDto,Tag.class);
    repository.save(jobAdvertisement);
    }



    @Override
    public TagResponseDTO findById(Long id) {
        Tag entity=getByID(id);
        return modelMapper.map(entity,TagResponseDTO.class);

    }



    private Tag getByID(Long id){
        return repository.findById(id).orElseThrow(()->new NotFoundException("Tag with ID: " +id +" was not found"));
    }

    @Override
    public void put(Long id, TagRequestDTO requestDto) {
        Tag source=getByID(id);
        modelMapper.map(requestDto,source);
        source.setId(id);
        repository.save(source);
    }

    @Override
    public void deleteById(Long id) {
         repository.deleteById(id);

    }




}
