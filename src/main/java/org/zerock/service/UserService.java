package org.zerock.service;

import org.zerock.domain.UserVO;

import java.util.List;

public interface UserService {
    public String getTime();

    public List<UserVO> getUserList();
    public UserVO getUser(String userId);

    public int  registerUser(UserVO user);

    public int  modifyUser(UserVO user);

    public int  removeUser(String userId);
}
