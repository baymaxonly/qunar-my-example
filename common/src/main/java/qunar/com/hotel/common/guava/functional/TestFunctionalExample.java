package qunar.com.hotel.common.guava.functional;

import com.google.common.base.Predicate;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by shixian.zhen on 2016/12/23.
 */
public class TestFunctionalExample {

    private final Logger logger = LoggerFactory.getLogger(TestFunctionalExample.class);
    @Test
    public void predicates(){
        Predicate<String> predicate = (s) -> s.length() > 0 ;
        logger.info("Predicates are boolean-valued functions of one argument. invoke apply {}" ,predicate.apply("my length"));
    }
}
