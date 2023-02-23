package UMS.mapping;


import UMS.dto.UserDTO;
import UMS.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public abstract class UserMapper {

    public static final UserMapper Mapping = Mappers.getMapper(UserMapper.class);

    public abstract UserEntity mapToEntity(UserDTO dto);

    public abstract UserDTO mapToDto(UserEntity entity);

    public abstract List<UserDTO> mapToDtoList(List<UserEntity> entities);
}
