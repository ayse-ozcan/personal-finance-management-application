package com.ayseozcan.service;

import com.ayseozcan.dto.request.ChangePasswordRequestDto;
import com.ayseozcan.dto.request.LoginRequestDto;
import com.ayseozcan.dto.request.RegisterRequestDto;
import com.ayseozcan.dto.request.UserUpdateRequestDto;
import com.ayseozcan.dto.response.FindUserResponseDto;
import com.ayseozcan.dto.response.UserLoginResponseDto;
import com.ayseozcan.exception.ErrorType;
import com.ayseozcan.exception.FinanceManagementException;
import com.ayseozcan.mapper.IUserMapper;
import com.ayseozcan.repository.IUserRepository;
import com.ayseozcan.repository.entity.User;
import com.ayseozcan.utility.JwtProvider;
import com.ayseozcan.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService extends ServiceManager<User, String> {
    private final IUserRepository userRepository;
    private final IUserMapper userMapper;
    private final JwtProvider jwtProvider;

    public UserService(IUserRepository userRepository, IUserMapper userMapper, JwtProvider jwtProvider) {
        super(userRepository);
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.jwtProvider = jwtProvider;
    }

    public Boolean register(RegisterRequestDto dto) {
        Optional<User> optionalUser = userRepository.findOptionalByUsernameIgnoreCase(dto.getUsername());
        if (optionalUser.isPresent()) {
            throw new FinanceManagementException(ErrorType.USERNAME_DUPLICATE);
        }
        User user = userMapper.fromRegisterRequestDtoToUser(dto);
        save(user);
        return true;
    }

    public UserLoginResponseDto login(LoginRequestDto dto) {
        Optional<User> optionalUser = userRepository.findOptionalByUsernameIgnoreCaseAndPassword(dto.getUsername(), dto.getPassword());
        if (optionalUser.isEmpty()) {
            throw new FinanceManagementException(ErrorType.CHECK_INPUT);
        }
        String token = jwtProvider.createToken(optionalUser.get().getId()).orElseThrow(() ->
                new FinanceManagementException(ErrorType.TOKEN_NOT_CREATED));
        return UserLoginResponseDto.builder().token(token).build();
    }

    public Boolean changePassword(ChangePasswordRequestDto dto) {
        Optional<String> userId = jwtProvider.getByIdFromToken(dto.getToken());
        if (userId.isEmpty()) {
            throw new FinanceManagementException(ErrorType.INVALID_TOKEN);
        }
        Optional<User> optionalUser = userRepository.findById(userId.get());
        if (optionalUser.isEmpty()) {
            throw new FinanceManagementException(ErrorType.USER_NOT_FOUND);
        }
        optionalUser.get().setPassword(dto.getNewPassword());
        update(optionalUser.get());
        return true;

    }

    public FindUserResponseDto findUserById(String token) {
        Optional<String> userId = jwtProvider.getByIdFromToken(token);
        if (userId.isEmpty()) {
            throw new FinanceManagementException(ErrorType.INVALID_TOKEN);
        }
        Optional<User> optionalUser = userRepository.findById(userId.get());
        if (optionalUser.isEmpty()) {
            throw new FinanceManagementException(ErrorType.USER_NOT_FOUND);
        }
        FindUserResponseDto dto = userMapper.fromUserToFindUserResponseDto(optionalUser.get());
        return dto;
    }

    public Boolean update(UserUpdateRequestDto dto) {
        Optional<String> userId = jwtProvider.getByIdFromToken(dto.getToken());
        if (userId.isEmpty()) {
            throw new FinanceManagementException(ErrorType.INVALID_TOKEN);
        }
        Optional<User> optionalUser = userRepository.findById(userId.get());
        if (optionalUser.isEmpty()) {
            throw new FinanceManagementException(ErrorType.USER_NOT_FOUND);
        }
        update(userMapper.fromUserUpdateRequestDtoToUser(dto, optionalUser.get()));
        return true;
    }
}

