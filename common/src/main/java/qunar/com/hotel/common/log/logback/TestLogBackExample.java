package qunar.com.hotel.common.log.logback;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by shixian.zhen on 2016/12/20.
 */

public class TestLogBackExample {

    private Logger logger = LoggerFactory.getLogger(TestLogBackExample.class);
    String printContent = "开始打印...";
    @Test
    public void info (){
        logger.info("logger level info {}", printContent);
    }

    @Test
    public void error (){
        logger.error("logger level error {}", printContent);
    }

}
