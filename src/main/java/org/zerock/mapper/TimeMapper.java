package org.zerock.mapper;

import org.apache.ibatis.annotations.Select;
import org.zerock.domain.UserVO;

import java.util.List;

public interface TimeMapper {
    @Select("SELECT now()")
    String getTime();

    List<UserVO> selectUserList();
    UserVO selectUser(String userId);

    int insertUser(UserVO user);

    int updateUser(UserVO user);

    int deleteUser(String userId);
}
