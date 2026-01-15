package com.nghiapham.identity_service.mapper;

import com.nghiapham.identity_service.dto.request.UserCreationRequest;
import com.nghiapham.identity_service.dto.request.UserUpdateRequest;
import com.nghiapham.identity_service.dto.respone.UserResponse;
import com.nghiapham.identity_service.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreationRequest request);
    UserResponse toUserRespone(User user);
    void updateUser(@MappingTarget User user, UserUpdateRequest request);
}
