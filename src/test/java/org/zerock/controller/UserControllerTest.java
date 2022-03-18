package org.zerock.controller;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.ModelMap;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;
import org.zerock.domain.UserVO;
import org.zerock.service.UserService;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//@ExtendWith(MockitoExtension.class) // Mokito 프레임워크 확장 기능 구현
@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@ContextConfiguration({"file:web/WEB-INF/dispatcher-servlet.xml"})
@Log4j2
class UserControllerTest {

    private final WebApplicationContext ctx;

    UserControllerTest(WebApplicationContext ctx) {
        this.ctx = ctx;
    }

    @InjectMocks // Mock 객체가 주입될 객체 선언. 해당 객체의 멤버 클래스와 테스트 내에 선언된 @Mock / @Spy 객체가 일치하면 주입.
    @Autowired
    private UserController controller;

    @Mock // Mock 객체 선언
    private UserService service;

    private MockMvc mockMvc;

    @BeforeEach
    void init() {
        mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
//        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void userList() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user/list"))
                .andExpect(status().isOk())
                .andExpect(view().name("user/list"))
                .andDo(print());
    }

    @Test
    void userInfo() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user/info")
                        .param("userId", "admin"))
                .andExpect(status().isOk())
                .andExpect(view().name("user/info"))
                .andDo(print());
    }

    @Test
    void userRegisterGet() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user/register"))
                .andExpect(status().isOk())
                .andExpect(view().name("user/register"))
                .andDo(print());
    }

    @Test
    void userRegisterPost() throws Exception {
        MultiValueMap<String, String> userVoMap = new LinkedMultiValueMap<>();
        userVoMap.add("userId", "RegisterTester");
        userVoMap.add("userPw", "registertester1234");
        userVoMap.add("userName", "RegisterTester");
        mockMvc.perform(MockMvcRequestBuilders.post("/user/registerProcess")
                        .params(userVoMap))
                .andExpect(status().isOk())
                .andExpect(view().name("user/register"))
                .andDo(print());
    }

    @Test
    void userModifyGet() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user/modify"))
                .andExpect(status().isOk())
                .andExpect(view().name("user/modify"))
                .andDo(print());
    }

    @Test
    void userModifyPost() throws Exception {
        MultiValueMap<String, String> userVoMap = new LinkedMultiValueMap<>();
        userVoMap.add("userName", "RegisterTester");
        userVoMap.add("checkPw", "registertester1234");
        mockMvc.perform(MockMvcRequestBuilders.post("/user/modifyProcess")
                        .params(userVoMap))
                .andExpect(status().isOk())
                .andExpect(view().name("/"))
                .andDo(print());
    }

    @Test
    void userRemoveGet() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user/remove"))
                .andExpect(status().isOk())
                .andExpect(view().name("user/remove"))
                .andDo(print());
    }

    @Test
    void userRemovePost() throws Exception {
        MultiValueMap<String, String> userVoMap = new LinkedMultiValueMap<>();
        userVoMap.add("userId", "test0");
        userVoMap.add("checkPw", "0000");
        mockMvc.perform(MockMvcRequestBuilders.post("/user/removeProcess")
                        .params(userVoMap))
                .andExpect(status().isOk())
                .andExpect(view().name("/"))
                .andDo(print());
    }

    @AfterEach
    void tearDown() {
        assertNotNull(mockMvc);
    }

}