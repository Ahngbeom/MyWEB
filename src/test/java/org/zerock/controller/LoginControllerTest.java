package org.zerock.controller;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.zerock.service.UserService;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/* Spring MVC를 모킹하여 웹 애플리케이션을 테스트
* 실제 서블릿 컨테이너에서 컨트롤러를 실행하지 않고 컨트롤러에 HTTP 요청이 가능하다.
* MockMvc 초기화 : 정적 메소드인 webAppContextSetup, standaloneSetup를 통해 초기화 (택 1) */

@ExtendWith(SpringExtension.class)
@WebAppConfiguration    /* 통합 테스트를 위해 로드된 ApplicationContext 중 WebApplicationContext 객체를 사용한다는 목적의 클래스 레벨 어노테이션.
                            web.xml과 dispatcher-servlet을 참조하여 WebApplicationContext 구축 */
@ContextConfiguration("file:web/WEB-INF/dispatcher-servlet.xml")
@Log4j2
class LoginControllerTest {

    private final WebApplicationContext ctx;

    LoginControllerTest(WebApplicationContext ctx) {
        this.ctx = ctx;
    }

    @InjectMocks // Mock 객체가 주입될 객체 선언. 해당 객체의 멤버 클래스와 테스트 내에 선언된 @Mock/@Spy 객체가 일치하면 주입.
    @Autowired
    private LoginController controller;

    @Mock // Mock 객체 선언
    private UserService service;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() throws Exception {
        try {
            MockitoAnnotations.openMocks(this); // Mock Annotation이 적용된 변수에 대한 객체 생성

            // MockMvc 인스턴스에 WebApplicationContext 적용.
            // Spring이 로드한 WebApplicationContext를 기반으로 동작.
            // 통합 테스트
/*[1]*/     mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();

            // MockMvc 인스턴스에 특정 Controller를 등록. 컨트롤러에 수동으로 모의 종속성을 주입
            // 테스트할 컨트롤러를 수동으로 초기화하고 주입.
            // 단위 테스트
/*[2]*/     mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        }
        catch (Exception e) {
            log.error(e);
        }
    }

    // TDD (Test-Driven Development) 테스트 주도 개발

    @Test
    void loginGET() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/login"))
                .andExpect(status().isOk())
                .andExpect(view().name("login"))
                .andExpect(model().attribute("Title", "Login"))
                .andDo(print());
//                .andExpect(redirectedUrl("/"));

        // Stub : Mock 객체를 주입하여 결과물에 대한 기댓값을 설정하는 과정 또는 메소드 (andExpect(), doReturn(), doNothing() 등)
    }

    @Test
    void loginPOST() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/loginProcess")
                        .param("userId", "admin")
                        .param("userPw", "1234"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"))
                .andExpect(model().attribute("Title", "Welcome to Home"))
                .andExpect(model().attribute("Content", "Welcome!"))
                .andDo(print());

        mockMvc.perform(MockMvcRequestBuilders.post("/loginProcess")
                        .param("userId", "admin")
                        .param("userPw", "4321"))
                .andExpect(status().isOk())
                .andExpect(view().name("login"))
                .andExpect(model().attribute("Title", "Login"))
                .andExpect(model().attribute("Content", "This account does not exist."))
                .andDo(print());
    }

    @AfterEach
    void tearDown() {
        assertNotNull(ctx);
        assertNotNull(controller);
        assertNotNull(service);
        assertNotNull(mockMvc);
    }

}