package org.zerock.service;

import org.zerock.domain.UserVO;

public interface LoginService {

    public boolean duplCheckId(String userId);

    public boolean identityCheck(UserVO userVO);
}
