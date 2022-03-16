package org.zerock.service;

import org.zerock.domain.UserVO;

import java.util.List;

public interface UserService {

    List<UserVO> getUserList();
    UserVO getUser(String userId);

    int  registerUser(UserVO user);

    int modifyUserInfo(UserVO user, String originPw);

    int modifyUserPassword(UserVO user, String originPw, String newPw);

    int  removeUser(UserVO user, String originPw);
}
