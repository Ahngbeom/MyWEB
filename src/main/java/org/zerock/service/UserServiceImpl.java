package org.zerock.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.UserVO;
import org.zerock.mapper.TimeMapper;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    private TimeMapper mapper;

    @Override
    public String getTime() {
        return mapper.getTime();
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
