package org.zerock.sample;

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
class HotelTest {

    @Autowired
    private Hotel hotel;

    @Test
    public void testExist() {
        assertNotNull(hotel);
        log.info(hotel);
        log.info(hotel.getChef());
    }
}