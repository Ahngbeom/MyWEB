package org.zerock.mapper;

import org.springframework.stereotype.Repository;
import org.zerock.domain.UserVO;

import java.util.List;

@Repository
public interface UserMapper {

    List<UserVO> selectUserList();
    UserVO selectUser(String userId);

    int insertUser(UserVO user);

    int updateUser(UserVO user);

    int deleteUser(String userId);
}
