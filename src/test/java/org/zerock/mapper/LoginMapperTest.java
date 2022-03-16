package org.zerock.mapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.zerock.domain.UserVO;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("file:web/WEB-INF/dispatcher-servlet.xml")
@Log4j2
class LoginMapperTest {

    @Autowired
    private LoginMapper loginMapper;

    @Test
    void duplCheckUserId() throws Exception {
        if (loginMapper.duplCheckUserId("admin") != null)
            log.error("This is a duplicate ID.");
        else
            log.info("This is a available ID");
    }

    @Test
    void checkUserPw() throws Exception {
        try {
            UserVO user = loginMapper.checkUserPw(new UserVO("admin", "1234", "adminstrator"));
            if (user != null)
                log.info("Login Successes.\n Welcome to MyWEB !\n " + user);
            else
                throw new NullPointerException("Login Failed.\n Passwords do not match.");
        } catch (Exception e) {
            log.error(e);
        }
    }
}