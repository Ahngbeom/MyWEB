package org.zerock.mapper;

import org.springframework.stereotype.Repository;
import org.zerock.domain.UserVO;

@Repository
public interface LoginMapper {

    String duplCheckUserId(String userId);

    UserVO checkUserPw(UserVO userVO);
}
