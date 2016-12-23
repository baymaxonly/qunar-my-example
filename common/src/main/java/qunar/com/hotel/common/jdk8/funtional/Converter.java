package qunar.com.hotel.common.jdk8.funtional;

/**
 * Created by shixian.zhen on 2016/12/23.
 *
 *
 */

// Keep in mind that the code is also valid if the @FunctionalInterface annotation would be ommited.
@FunctionalInterface
public interface Converter<F, T> {
    T convert(F from);
}
