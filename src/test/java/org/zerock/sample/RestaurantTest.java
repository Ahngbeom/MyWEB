package org.zerock.sample;

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
class RestaurantTest {

    @Setter(onMethod_ = @Autowired)
    private Restaurant restaurant;

    @Test
    public void testExist() {
        assertNotNull(restaurant);
        log.info(restaurant);
        log.info("--------------");
        log.info(restaurant.getChef());
    }
}