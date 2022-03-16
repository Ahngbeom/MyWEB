package org.zerock.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.zerock.domain.UserVO;

import java.util.List;

@Repository
public interface UserMapper {

    List<UserVO> selectUserList();
    UserVO selectUser(String userId);

    int insertUser(UserVO user);

    int updateUserInfo(@Param("user") UserVO user, @Param("originPw") String originPw);

    int updateUserPassword(@Param("user") UserVO user, @Param("originPw") String originPw, @Param("newPw") String newPw);

    int deleteUser(@Param("user") UserVO user, @Param("originPw") String originPw);
}
