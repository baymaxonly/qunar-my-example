package qunar.com.hotel.common.log.jdk8.stream;

import java.util.function.Supplier;

/**
 * Created by shixian.zhen on 2016/12/22.
 */
public class NaturalSupplier implements Supplier<Long> {

    long value = 0;
    @Override
    public Long get() {
        value = this.value + 1;
        return this.value;
    }
}
