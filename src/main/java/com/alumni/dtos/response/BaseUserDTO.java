package com.alumni.dtos.response;

import com.alumni.dtos.DTO;
import com.alumni.dtos.MappingUtils;
import com.alumni.entity.BaseUser;
import com.alumni.entity.City;
import com.alumni.entity.State;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import java.util.List;

@Data
public class BaseUserDTO implements DTO {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private State state;
    private City city;

//    @Override
//    public ModelMapper updateModelMapper(ModelMapper mapper, MappingUtils utils) {
//        mapper.addMappings(buildingMap(utils));
//
//        return mapper;
//    }

//    public PropertyMap<BaseUser, BaseUserDTO> buildingMap(MappingUtils utils) {
//        return new PropertyMap<BaseUser, BaseUserDTO>() {
//            @Override
//            protected void configure() {
//                Converter<BaseUser, Integer> getState = new AbstractConverter<BaseUser, StateResponseDTO>() {
//                    @Override
//                    protected Integer convert(BaseUser baseUser) {
//                        return baseUser.get.size();
//                    }
//                };
//
//                Converter<List<BaseUser>, List<CityResponseDTO>> mapRooms = new AbstractConverter<List<BaseUser>, List<RoomDTO>>() {
//                    @Override
//                    protected List<RoomDTO> convert(BaseUser building) {
//
//                        return utils.mapList(new ArrayList<>(building.getRooms()), RoomDTO.class);
//                    }
//                };
//
//                using(getSize).map(source, destination.getRoomNumber());
//                using(mapRooms).map(source, destination.getRooms());
//                map().setCity(source.getCity().getName());
//
//            }
//        };
//    }

}
