package qunar.com.hotel.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by shixian.zhen on 2016/12/21.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-mvc.xml")
public class SpringJunitForConfigurationExample {

    Logger logger = LoggerFactory.getLogger(SpringJunitForConfigurationExample.class);
    @Test
    public void getContextObject(){
        logger.info("test");
    }
}
