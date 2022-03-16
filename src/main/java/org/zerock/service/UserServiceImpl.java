package org.zerock.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.zerock.domain.UserVO;
import org.zerock.mapper.UserMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper mapper;

    @Override
    public List<UserVO> getUserList() {
        return mapper.selectUserList();
    }

    @Override
    public UserVO getUser(String userId) {
        return mapper.selectUser(userId);
    }

    @Override
    public int registerUser(UserVO user) {
        return mapper.insertUser(user);
    }

    @Override
    public int modifyUserInfo(UserVO user, String originPw) {
        return mapper.updateUserInfo(user, originPw);
    }

    @Override
    public int modifyUserPassword(UserVO user, String originPw, String newPw) {
        return mapper.updateUserPassword(user, originPw, newPw);
    }

    @Override
    public int removeUser(UserVO user, String originPw) {
        return mapper.deleteUser(user, originPw);
    }
}
