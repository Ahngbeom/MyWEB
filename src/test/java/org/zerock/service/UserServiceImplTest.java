package org.zerock.service;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
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

    @Autowired
    private UserService service;

    @BeforeEach
    public void setup() {
        assertNotNull(service);
        log.info(service);
    }

    @Test
    public void testGetUser() {
        log.info(service.getUser("admin"));
    }

    @Test
    public void testGetUserList() {
        service.getUserList().forEach(user -> log.info(user));
    }

    @Test
    public void testRegisterUser() {
        log.info(service.registerUser(new UserVO("abcde", "12345", "ahngbeom")));
        log.info(service.getUser("abcde"));
    }

    @Test
    public void testModifyUserInfo() {
        UserVO modUser = service.getUser("abcde");
        modUser.setUserName("Alphabet");
        log.info(service.modifyUserInfo(modUser, "1234"));
        log.info(service.modifyUserInfo(modUser, "12345"));
        log.info(modUser);
    }

    @Test
    public void testModifyUserPassword() {
        UserVO modUser = service.getUser("abcde");
        log.info(service.modifyUserPassword(modUser, "12345", "54321"));
        log.info(modUser);
    }

    @Test
    public void testRemoveUser() {
        log.info("REMOVE USER : " + service.removeUser(service.getUser("abcde"), "4321"));
        log.info("REMOVE USER : " + service.removeUser(service.getUser("abcde"), "54321"));
    }


}