package com.nghiapham.identity_service.controller;

import com.nghiapham.identity_service.dto.request.AuthenticationRequest;
import com.nghiapham.identity_service.dto.request.IntrospectRequest;
import com.nghiapham.identity_service.dto.respone.ApiResponse;
import com.nghiapham.identity_service.dto.respone.AuthenticationRespone;
import com.nghiapham.identity_service.dto.respone.IntrospecResponse;
import com.nghiapham.identity_service.service.AuthenticationService;
import com.nimbusds.jose.JOSEException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)

public class AuthenticationController {
 AuthenticationService authenticationService;

 @PostMapping("token")
 ApiResponse<AuthenticationRespone> authenticate(@RequestBody AuthenticationRequest request) throws JOSEException {
    var result =  authenticationService.authenticate(request);
    return ApiResponse.<AuthenticationRespone>builder()
            .result(result)
            .build();
 }
 @PostMapping("introspect")
    ApiResponse<IntrospecResponse> introspect(@RequestBody IntrospectRequest request) throws ParseException, JOSEException {
     var result = authenticationService.introspect(request);
     return ApiResponse.<IntrospecResponse>builder()
             .result(result)
             .build();
 }
}
