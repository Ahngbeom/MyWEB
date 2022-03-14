package org.zerock.mapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("file:web/WEB-INF/dispatcher-servlet.xml")
@Log4j2
class TimeMapperTest {

    @Setter(onMethod_ = @Autowired)
    private UtilMapper utilMapper;

    @Test
    public void testGetTime() {
        assertNotNull(utilMapper);
        log.info(utilMapper.getTime());
    }

    @Test
    public void testGetTime2() {
        assertNotNull(utilMapper);
        log.info(utilMapper.getTime());
    }
}