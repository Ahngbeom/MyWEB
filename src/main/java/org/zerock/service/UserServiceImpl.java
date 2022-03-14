package org.zerock.service;

import org.springframework.stereotype.Service;
import org.zerock.domain.UserVO;
import org.zerock.mapper.UserMapper;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserMapper mapper;

    public UserServiceImpl(UserMapper mapper) {
        this.mapper = mapper;
    }

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
    public int modifyUser(UserVO user) {
        return mapper.updateUser(user);
    }

    @Override
    public int removeUser(String userId) {
        return mapper.deleteUser(userId);
    }
}
