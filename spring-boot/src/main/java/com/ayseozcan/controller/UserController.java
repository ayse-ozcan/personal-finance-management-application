package com.ayseozcan.controller;

import com.ayseozcan.dto.request.ChangePasswordRequestDto;
import com.ayseozcan.dto.request.LoginRequestDto;
import com.ayseozcan.dto.request.RegisterRequestDto;
import com.ayseozcan.dto.request.UserUpdateRequestDto;
import com.ayseozcan.dto.response.FindUserResponseDto;
import com.ayseozcan.dto.response.UserLoginResponseDto;
import com.ayseozcan.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.ayseozcan.constant.ApiUrls.*;

@RestController
@RequiredArgsConstructor
@RequestMapping((USER))
public class UserController {
    private final UserService userService;

    @PostMapping(REGISTER)
    @CrossOrigin("*")
    public ResponseEntity<Boolean> register(@RequestBody @Valid RegisterRequestDto dto) {
        return ResponseEntity.ok(userService.register(dto));
    }

    @PostMapping(LOGIN)
    @CrossOrigin("*")
    public ResponseEntity<UserLoginResponseDto> login(@RequestBody @Valid LoginRequestDto dto) {
        return ResponseEntity.ok(userService.login(dto));
    }

    @PutMapping(CHANGE_PASSWORD)
    @CrossOrigin("*")
    public ResponseEntity<Boolean> changePassword(@RequestBody @Valid ChangePasswordRequestDto dto) {
        return ResponseEntity.ok(userService.changePassword(dto));
    }

    @GetMapping(FIND_BY_ID + "/{token}")
    @CrossOrigin("*")
    public ResponseEntity<FindUserResponseDto> findUserById(@PathVariable @Valid String token) {
        return ResponseEntity.ok(userService.findUserById(token));
    }

    @PutMapping(UPDATE)
    @CrossOrigin("*")
    public ResponseEntity<Boolean> update(@RequestBody @Valid UserUpdateRequestDto dto) {
        return ResponseEntity.ok(userService.update(dto));
    }
}

