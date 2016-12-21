package qunar.com.hotel.common.log.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by shixian.zhen on 2016/12/20.
 */


public class TestLogBackExample {

    private Logger logger = LoggerFactory.getLogger(TestLogBackExample.class);

    public void info (String printContent){
        logger.info("logger level info {}", printContent);
    }

    public void error (String printContent){
        logger.error("logger level error {}", printContent);
    }

    public static void main(String args[]){
        TestLogBackExample logExecute = new TestLogBackExample();
        logExecute.info("开始打印了。。");
        logExecute.error("开始打印了。。");
    }

}
