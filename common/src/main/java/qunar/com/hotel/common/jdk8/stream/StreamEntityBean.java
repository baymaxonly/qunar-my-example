package qunar.com.hotel.common.log.jdk8.stream;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by shixian.zhen on 2016/12/22.
 */
public class StreamEntityBean {

    private String hotelSeq;

    private String hotelName;

    public String getHotelSeq() {
        return hotelSeq;
    }

    public void setHotelSeq(String hotelSeq) {
        this.hotelSeq = hotelSeq;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;

    }

    public StreamEntityBean(String hotelSeq, String hotelName) {
        this.hotelSeq = hotelSeq;
        this.hotelName = hotelName;
    }

    @Override
    public int hashCode(){
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + (this.hotelSeq == null ? 0 : this.hotelSeq.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj != null && (obj instanceof StreamEntityBean)){
            StreamEntityBean tmp = (StreamEntityBean) obj;
            if (this.hotelSeq != null && this.hotelSeq.equals(tmp.hotelSeq)){
                return true;
            }else if (tmp.hotelSeq != null && tmp.hotelSeq.equals(this.hotelSeq)){
                return true;
            }
        }
        return true;
    }

    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this);
    }

}
