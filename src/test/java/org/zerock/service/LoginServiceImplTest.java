package org.zerock.service;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.zerock.domain.UserVO;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("file:web/WEB-INF/dispatcher-servlet.xml")
@Log4j2
class LoginServiceImplTest {

    @Autowired
    private LoginService service;

    @Test
    void duplCheckId() {
        log.info(service.duplCheckId("admin"));
    }

    @Test
    void identityCheck() {
        log.info(service.identityCheck(new UserVO("admin", "1234", "adminstrator")));
    }
}