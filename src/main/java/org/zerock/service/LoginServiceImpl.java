package org.zerock.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.zerock.domain.UserVO;
import org.zerock.mapper.LoginMapper;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService{

    private final LoginMapper loginMapper;

    @Override
    public boolean duplCheckId(String userId) {
        return loginMapper.duplCheckUserId(userId) != null ? true : false;
    }

    @Override
    public boolean identityCheck(UserVO userVO) {
        return loginMapper.checkUserPw(userVO) != null ? true : false;
    }
}
