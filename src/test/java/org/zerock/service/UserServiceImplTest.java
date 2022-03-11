package org.zerock.service;

import lombok.Setter;
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
class UserServiceImplTest {

    @Setter(onMethod_ = @Autowired)
    private UserServiceImpl service;

    @Test
    public void testGetUser() {
        assertNotNull(service);
        log.info(service);
        log.info(service.getUser("admin"));
    }

    @Test
    public void testGetUserList() {
        assertNotNull(service);
        log.info(service);
        log.info(service.getTime());
        service.registerUser(new UserVO("user", "abcde", "ahngbeom"));
        service.getUserList().forEach(user -> log.info(user));
        log.info(service.getUser("user1").getUserPw());
    }

    @Test
    public void testRegisterUser() {
        assertNotNull(service);
        log.info(service);
        log.info(service.registerUser(new UserVO("abcde", "12345", "ahngbeom")));
        log.info(service.getUser("abcde"));
    }

    @Test
    public void testModifyUser() {
        assertNotNull(service);
        log.info(service);
        UserVO modUser = service.getUser("abcde");
        modUser.setUserName("Alphabet");
        log.info(service.modifyUser(modUser));
        log.info(modUser);
    }

    @Test
    public void testRemoveUser() {
        assertNotNull(service);
        log.info(service);
        log.info("REMOVE USER : " + service.removeUser("user"));
    }


}