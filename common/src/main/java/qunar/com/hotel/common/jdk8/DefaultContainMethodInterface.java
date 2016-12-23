package qunar.com.hotel.common.log.jdk8;

/**
 * Created by shixian.zhen on 2016/12/23.
 *
 * 通过default关键字可以在接口里定义实体方法
 */
public interface DefaultContainMethodInterface {

    double calcalate(int a);

    default double randomNumber(){
        return Math.random();
    }

}
