package com.alumni.Service.impls;

import com.alumni.Exceptions.NotFoundException;
import com.alumni.Service.AuthService;
import com.alumni.Service.BaseUserService;
import com.alumni.Service.JwtService;
import com.alumni.dtos.request.LoginRequestDTO;
import com.alumni.dtos.request.SignupRequestDTO;
import com.alumni.dtos.response.LoginResponseDTO;
import com.alumni.entity.BaseUser;
import com.alumni.repository.BaseUserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;


@AllArgsConstructor
@Service
public class AuthServiceImpl implements AuthService {

    private final BaseUserService BaseUserService;
    private final JwtService jwtService;
    private final ModelMapper modelMapper;
    private final BaseUserRepository baseUserRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final AuthenticationManager authenticationManager;

    @Override
    public LoginResponseDTO signup(SignupRequestDTO signupRequestDTO) {
        BaseUser baseUser = modelMapper.map(signupRequestDTO, BaseUser.class);
        baseUser = BaseUserService.save(baseUser);
        String token = jwtService.generateToken(baseUser);
        LoginResponseDTO loginResponseDTO = modelMapper.map(baseUser, LoginResponseDTO.class);
        loginResponseDTO.setToken(token);
        return loginResponseDTO;
    }

    @Override
    public LoginResponseDTO login(LoginRequestDTO loginRequestDTO) throws NotFoundException {
        Optional<BaseUser> baseUser = baseUserRepository.findByEmail(loginRequestDTO.getEmail());
        baseUser.orElseThrow(() -> new NotFoundException("User not found"));
        if(!bCryptPasswordEncoder.matches(loginRequestDTO.getPassword(), baseUser.get().getPassword()))
        {
            throw  new NotFoundException("User not found");
        }

        String token = jwtService.generateToken(baseUser.get());
        LoginResponseDTO loginResponseDTO = modelMapper.map(baseUser, LoginResponseDTO.class);
        loginResponseDTO.setToken(token);
        return loginResponseDTO;
    }
}
