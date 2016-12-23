package qunar.com.hotel.common.log.jdk8.stream;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by shixian.zhen on 2016/12/22.
 */

public class TestStreamApiExample {

    @Test
    public void StreamUse(){
        //数据组过滤+打印
        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        Stream<Integer> stream = numbers.stream();
        stream.filter((x) -> x > 4).forEach(System.out::println);
    }

    @Test
    public void NaturalInfinity(){
        Stream<Long> streamNatural = Stream.generate(new NaturalSupplier());
        streamNatural.skip(10).limit(3).forEach(System.out::println);
        /**
         * 打印结果
         *
         *11
         12
         13
         */
    }

    @Test
    public void distinctStream(){
        List<StreamEntityBean> entityBeanList = new ArrayList<>();
        entityBeanList.add(new StreamEntityBean("hotel1","如家酒店"));
        entityBeanList.add(new StreamEntityBean("hotel2","汉庭酒店1"));
        entityBeanList.add(new StreamEntityBean("hotel2","汉庭酒店2"));
        List<StreamEntityBean> resultList = entityBeanList.stream()
                .sorted((c1, c2) -> c2.getHotelName().compareTo(c1.getHotelName()))
                .distinct()  //去重规则：对象根据重写的hashCode和equals方法进行去重，会获取第一个记录，丢弃后面重复记录
                .sorted((c1, c2) -> c1.getHotelSeq().compareTo(c2.getHotelSeq())) //正序排序
                .collect(Collectors.toList()); //结果装载到新的集合类

        resultList.stream().forEach((item) -> System.out.println(item));
        /** 打印结果
         * qunar.com.hotel.common.log.jdk8.stream.StreamEntityBean@532760d8[hotelSeq=hotel1,hotelName=如家酒店]
           qunar.com.hotel.common.log.jdk8.stream.StreamEntityBean@57fa26b7[hotelSeq=hotel2,hotelName=汉庭酒店2]
         */
    }

    @Test
    public void collectionsLambdaUse(){
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        //lambda comparator expression Instead of creating anonymous objects all day long
        Collections.sort(names,(c1, c2 ) -> {return c1.compareTo(c2);});

        //As you can see the code is much shorter and easier to read. But it gets even shorter.
        Collections.sort(names,(String c1, String c2) -> c1.compareTo(c2));

        Collections.sort(names,(c1, c2 ) -> c1.compareTo(c2));

        //Normal comparator expression
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
    }
}
