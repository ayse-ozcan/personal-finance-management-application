package com.ayseozcan.mapper;

import com.ayseozcan.dto.request.RegisterRequestDto;
import com.ayseozcan.dto.request.UserUpdateRequestDto;
import com.ayseozcan.dto.response.FindUserResponseDto;
import com.ayseozcan.repository.entity.User;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IUserMapper {
    IUserMapper INSTANCE = Mappers.getMapper(IUserMapper.class);

    User fromRegisterRequestDtoToUser(final RegisterRequestDto dto);

    FindUserResponseDto fromUserToFindUserResponseDto(final User user);
@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE )
    User fromUserUpdateRequestDtoToUser(final UserUpdateRequestDto dto, @MappingTarget User user);
}
