package com.groot.demo.service.user;

import com.groot.demo.dto.UserLoginDto;
import com.groot.demo.dto.UserRegisterDto;
import com.groot.demo.entity.User;
import com.groot.demo.entity.UserRepository;
import com.groot.demo.exception.DuplicationException;
import com.groot.demo.exception.LoginException;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public ResponseEntity register(UserRegisterDto userRegisterDto) {

        if (userRepository.existsByUserId(userRegisterDto.getUserId())) {
            throw new DuplicationException("아이디가 중복 입니다.");
        }

        userRepository.save(userRegisterDto.toEntity());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        return new ResponseEntity<String>("회원가입 성공~", headers, HttpStatus.CREATED);
    }

    public ResponseEntity login(UserLoginDto userLoginDto) {

        if (!userRepository.existsByUserId(userLoginDto.getUserId())) {
            throw new LoginException("아이디를 찾지 못하였습니다.");
        }

        User user = userRepository.findByUserId(userLoginDto.getUserId());

        if (!user.isSamePassword(userLoginDto.getPassword())) {
            throw new LoginException("비밀번호가 일치하지 않습니다.");
        }

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sellerCheck", user.getSellerCheck());

        return new ResponseEntity<JSONObject>(jsonObject, HttpStatus.OK);
    }
}
