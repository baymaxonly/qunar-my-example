package qunar.com.hotel.common.jdk8.date;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;

/**
 * Created by shixian.zhen on 2016/12/23.
 */
public class TestNewDateApiExample {

    private final Logger logger = LoggerFactory.getLogger(TestNewDateApiExample.class);

    @Test
    public void clock(){
        Clock clock = Clock.systemDefaultZone();
        long millis = clock.millis(); //毫秒
        Instant instant = clock.instant();
        Date legacyDate = Date.from(instant); //获取日期对象
        logger.info("now mollis {} date {}", millis, legacyDate);
    }

    @Test
    public void localTime(){
        ZoneId zone1 = ZoneId.of("Europe/Berlin");
        logger.info("zone of Rules {}", zone1.getRules().toString());
        LocalTime localTime = LocalTime.now();
        LocalTime localTime2 = LocalTime.now(zone1);
        logger.info("will system get of localtime {}  Brazil/East of localtime {}", localTime, localTime2);

        //compare both difference times
        logger.info("compare both difference times. {}", localTime.compareTo(localTime2));
        //calculate the difference in hours and minutes between both times
        long hoursBetween = ChronoUnit.HOURS.between(localTime, localTime2);
        logger.info("calculate the difference in hours {}", hoursBetween);
        long minutesBetween = ChronoUnit.MINUTES.between(localTime, localTime2); //-7
        logger.info("calculate the difference in minutes {}", minutesBetween); // -420

        //creation of new instants
        LocalTime defineTime = LocalTime.of(23, 20);
        logger.info("creation of new instants {} ", defineTime);

        //formatter time
        DateTimeFormatter chinaFormatter = DateTimeFormatter.ISO_TIME;
        logger.info("Formatter parse time {}",LocalTime.parse("13:30:00", chinaFormatter));

    }

    @Test
    public void localDate(){
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = today.minus(1, ChronoUnit.DAYS);
        LocalDate yesterday = tomorrow.minusDays(1);
        LocalDate independenceDay = LocalDate.of(2014, Month.JUNE, 1);
        DayOfWeek dayOfWeek = independenceDay.getDayOfWeek();
        logger.info("today {} tomorrow {} yesterday {} independenceDay {} dayOfWeek {}"
                ,today ,tomorrow, yesterday ,independenceDay, dayOfWeek);

        //formatter localDate
        DateTimeFormatter chinaFormatter = DateTimeFormatter
                .ofLocalizedDate(FormatStyle.MEDIUM)
                .withLocale(Locale.CHINA);
        logger.info("formatter localDate of china {}",LocalDate.parse("2014-12-12", chinaFormatter));
    }

}
