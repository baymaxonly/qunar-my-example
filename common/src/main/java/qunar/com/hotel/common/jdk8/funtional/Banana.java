package qunar.com.hotel.common.jdk8.funtional;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.time.LocalDate;

/**
 * Created by shixian.zhen on 2016/12/23.
 */
public class Banana {

    private double weight;
    private LocalDate makeDate;

    public Banana(double weight, LocalDate makeDate) {
        this.weight = weight;
        this.makeDate = makeDate;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public LocalDate getMakeDate() {
        return makeDate;
    }

    public void setMakeDate(LocalDate makeDate) {
        this.makeDate = makeDate;
    }

    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this);
    }
}
