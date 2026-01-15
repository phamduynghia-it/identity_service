package com.nghiapham.identity_service.controller;

import com.nghiapham.identity_service.dto.request.UserCreationRequest;
import com.nghiapham.identity_service.dto.request.UserUpdateRequest;
import com.nghiapham.identity_service.dto.respone.ApiResponse;
import com.nghiapham.identity_service.dto.respone.UserResponse;
import com.nghiapham.identity_service.service.UserService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserController {
    UserService userService;

    @PostMapping
    ApiResponse<UserResponse> createUser(@RequestBody @Valid UserCreationRequest request) {
        return ApiResponse.<UserResponse>builder()
                .result(userService.createUser(request))
                .build();
    }

    @GetMapping("/getmyinfo")
    ApiResponse<UserResponse> getMyInfo() {
        return ApiResponse.<UserResponse>builder()
                .result(userService.getMyInfo())
                .build();
    }

    @GetMapping
    ApiResponse<List<UserResponse>> getUsers() {
        return ApiResponse.<List<UserResponse>>builder().result(userService.getUsers())
                .build();
    }

    @GetMapping("/{userId}")
    ApiResponse<UserResponse> getUser(@PathVariable("userId") String userId) {
        return ApiResponse.<UserResponse>builder()
                .result(userService.getUser(userId))
                .build();
    }

    @PutMapping("/{userId}")
    ApiResponse<UserResponse> updateUser(@RequestBody UserUpdateRequest request, @PathVariable String userId) {

        //return
        return ApiResponse.<UserResponse>builder().result(userService.updateUser(userId, request))
                .build();
    }

    @DeleteMapping("/{userId}")
    ApiResponse<String> deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
//        return ApiRespone<String>builder().result("User deleted")
//                .build();
        return ApiResponse.<String>builder().result("User has been deleted").build();
    }
}
