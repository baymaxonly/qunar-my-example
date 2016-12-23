package qunar.com.hotel.common.jdk8.funtional;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import qunar.com.hotel.common.log.logback.TestLogBackExample;

import java.time.LocalDate;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Created by shixian.zhen on 2016/12/23.
 */
public class TestFunctionalExample {

    private final Logger logger = LoggerFactory.getLogger(TestLogBackExample.class);

    //Converter
    @Test
    public void SelfDefineFunctional(){
        int num = 1;
        Converter<String, Integer> stringToInteger = (from) -> Integer.valueOf(from) + num;
        //However num must be implicitly final for the code to compile. The following code does not compile:
        // num = 3;  Lambda Scopes 本地变量和声明final变量都是可以使用，但是在lambda表达之后修改本地变量就会报编译错误

        Integer converted =  stringToInteger.convert("3435");

        logger.info("String to Integer {}", converted);
        // Method and Constructor static References
        Converter<String, Integer> converterWithConstructorReferences = Integer::valueOf;
        converted =  converterWithConstructorReferences.convert("3435");
        logger.info("String to Integer {}", converted);
    }

    /**
     * objectBean::startsWith;
     */
    @Test
    public void withObjectMethod(){
        SomethingObjectBean objectBean = new SomethingObjectBean();
        Converter<String, String> converterForString = objectBean::startsWith;
        String converted = converterForString.convert("123456");
        logger.info("Method object method invoke {}", converted); //print 1
    }

    /**
     * Banana::new
     */
    @Test
    public void withObjectConstructMethod(){
        FruitFactory<Banana> bananaFruitFactory = Banana::new;
        Banana banana = bananaFruitFactory.create(10, LocalDate.now());
        logger.info("Object Construct Method {}", banana.toString());
        
    }

    @Test
    public void accessingDefaultInterfaceMethods(){
        // Default methods cannot be accessed from within lambda expressions. The following code does not compile.
        //DefaultContainMethodInterface interfaceObject = (a) -> DefaultContainMethodInterface::randomNumber() ;
    }


    /**
     *  predicates
     *  functions
     *  suppliers
     *  consumes
     */
    @Test
    public void normalFunctionalInterfaceUse(){

        //preidcate use
        Predicate<String> predicate = (s) -> s.length() >0 ;
        logger.info("predicate str length than zero {}",predicate.test("my length"));
        logger.info("predicate str length than zero and negate {}", predicate.negate().test("my length"));
        Predicate<Object> nonNull = Objects::nonNull;
        Predicate<Object> isNull = Objects::isNull;
        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> isNotEmpty = isEmpty.negate();
        //function
        Function<String, Integer> toInteger = Integer::valueOf;
        Function<String, String> backToString = toInteger.andThen(String::valueOf);
        logger.info("Function use invoke result {}" , backToString.apply("100"));
        //suppliers
        int num = 1;
        Supplier<Double> supplier = () -> Math.random();
        logger.info("Suppler random number {}", supplier.get());
        //consumes
        Consumer<Double> greeter = (p) -> logger.info("Consumes {}",p);
        greeter.accept(1223D);

    }



}
