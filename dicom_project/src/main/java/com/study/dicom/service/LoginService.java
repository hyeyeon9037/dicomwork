package com.study.dicom.service;

import com.study.dicom.domain.Login;
import com.study.dicom.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    private LoginRepository loginRepository;

    // 로그인 로직 구현
    public boolean login(String userName, String userPassword) {
        // 데이터베이스에서 userName을 기반으로 사용자 조회
        Optional<Login> loginOptional = loginRepository.findById(userName);
        
        if (loginOptional.isPresent()) {
            // 사용자 존재 시, 비밀번호 비교
            Login login = loginOptional.get();
            return login.getUserPassword().equals(userPassword);
        }
        return false; // 사용자가 없거나 비밀번호가 틀리면 false 반환
    }
}
