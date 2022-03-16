package org.zerock.mapper;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.zerock.domain.UserVO;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("file:web/WEB-INF/dispatcher-servlet.xml")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Log4j2
class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    @Order(1)
    void selectUserList() {
        log.info(userMapper.selectUserList());
    }

    @Test
    @Order(3)
    void selectUser() {
        log.info(userMapper.selectUser("test0"));
    }

    @Test
    @Order(2)
    void insertUser() {
        if (userMapper.insertUser(new UserVO("test0", "0000", "tester0")) == 1)
            log.info("INSERT : " + userMapper.selectUser("test0"));
        else
            log.error("Insert Failed.");
    }

    @Test
    @Order(4)
    void updateUserInfo() {
        UserVO user = userMapper.selectUser("test0");
        log.info(user);
        user.setUserName("tester00");
        log.info(user);
        if (userMapper.updateUserInfo(user, "0000") == 1)
            log.info("UPDATE User Info : " + userMapper.selectUser("test0"));
        else
            log.error("Update User Info Failed.");
    }

    @Test
    @Order(5)
    void updateUserPassword() {
        UserVO user = userMapper.selectUser("test0");
        log.info(user);
        if (userMapper.updateUserPassword(user, "000000", "0000") == 1)
            log.info("UPDATE User Password : " + userMapper.selectUser("test0"));
        else
            log.error("Update User Password Failed.");
    }

    @Test
    @Order(6)
    void deleteUser() {
        if (userMapper.deleteUser(userMapper.selectUser("test0"), "0000") == 1)
            log.info("DELETE Success");
        else
            log.info("DELETE Failed");
    }
}