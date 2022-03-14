package org.zerock.controller;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class) // JUnit5를 통해 Spring 프레임워크 테스트
@WebAppConfiguration // WebApplicationContext 객체 활성화. Controller 및 Web 환경에 사용되는 Bean들을 자동으로 생성 및 등록
@ContextConfiguration({"file:web/WEB-INF/dispatcher-servlet.xml"}) // Bean 설정 파일 경로 명시
@Log4j2
class HomeControllerTest {

    // WebApplicationContext 생성자 주입
    private final WebApplicationContext ctx;

    HomeControllerTest(WebApplicationContext ctx) {
        this.ctx = ctx;
    }

    // MockMvc : 웹 어플리케이션을 WAS에 배포하지 않고 테스트용 MVC 환경을 만들어 요청 및 전송, 응답기능을 제공해주는 유틸리티 클래스.
    private MockMvc mockMvc;

    @Autowired
    private HomeController controller;

    @BeforeEach
    void init() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void home() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/"));
    }

    @AfterEach
    void tearDown() {
        assertNotNull(mockMvc);
    }

}