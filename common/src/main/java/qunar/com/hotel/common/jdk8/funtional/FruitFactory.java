package qunar.com.hotel.common.jdk8.funtional;

import java.time.LocalDate;

/**
 * Created by shixian.zhen on 2016/12/23.
 */
public interface FruitFactory<P extends Banana> {

    P create(double weight, LocalDate makeDate);

}
