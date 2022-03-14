package org.zerock.service;

import org.zerock.domain.UserVO;

import java.util.List;

public interface UserService {

    List<UserVO> getUserList();
    UserVO getUser(String userId);

    int  registerUser(UserVO user);

    int  modifyUser(UserVO user);

    int  removeUser(String userId);
}
