package com.fx.test;

import org.junit.Test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.TimeZone;


@SuppressWarnings("ALL")
public class PrivateTestMain {
        public static void main(String [] args){
            Singleton singleton = Singleton.getInstance();
        }


    //获取指定时间的 指定时区时间    参照点:默认时区
    public LocalDateTime getZongTime2(LocalDateTime time, ZoneId dest) {
        Objects.requireNonNull(dest);
        return getZongTime2(time, null, dest);
    }
    //版本2
    public LocalDateTime getZongTime2(LocalDateTime time, ZoneId src, ZoneId dest) {
        //难点就是如何求偏移量
        //这里使用默认时区,在中国的就是中国,在美国的就是美国,这样估计更合适
        Objects.requireNonNull(dest);
        ZonedDateTime z1=null;
        if (src==null) {
            z1 = time.atZone(ZoneId.systemDefault());
        }else{
            z1 = time.atZone(src);
        }
//
        ZonedDateTime z2 = z1.withZoneSameInstant(dest);
        //处理重叠问题
        long hours = Duration.between(z2.withEarlierOffsetAtOverlap(),  z2.withLaterOffsetAtOverlap()).toHours();
        z2= z2.plusHours(hours);

        System.out.println(dest.getId()+"对应得标准时区:"+getZoneDesc( TimeZone.getTimeZone(dest)));
        System.out.println("目标时区"+dest+"的时间"+z2.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        System.out.println("-------------");
        return time;
    }

    //获取标准时区,方式1
    //在jdk8之前的方法,利用TimeZone
    private static String getZoneDesc(TimeZone destzone) {
        Objects.requireNonNull(destzone);
        int Offset = destzone.getRawOffset() / (1000 * 60 * 60);
        if (Offset <= 0) {
            return "GMT"+String.valueOf(Offset);
        } else {
            return "GMT+" + String.valueOf(Offset);
        }
    }

    @Test
    public void test4() throws Exception {
        //预计不在夏令时 2016-03-13 01:59:59
        LocalDateTime time4= LocalDateTime.of(2016, 3, 13, 14, 59, 59);
        getZongTime2(time4,ZoneId.of("America/New_York"));

        //预计在夏令时 2016-03-13 03:00:00
        LocalDateTime time1= LocalDateTime.of(2016, 3, 13, 15, 00, 00);
        getZongTime2(time1,ZoneId.of("America/New_York"));

        //预计在夏令时 2016-11-06 02:59:59
        LocalDateTime time2= LocalDateTime.of(2016, 11, 6, 14, 59, 59);
        getZongTime2(time2,ZoneId.of("America/New_York"));
        //预计不在夏令时2016-11-06 02:00:00
        LocalDateTime time3= LocalDateTime.of(2016, 11, 6, 15, 00, 00);
        getZongTime2(time3,ZoneId.of("America/New_York"));

        //预计不在夏令时2018-03-16 08:14:27
        LocalDateTime time5= LocalDateTime.of(2018, 3, 16, 8, 14, 27);
        getZongTime2(time5,ZoneId.of("America/New_York"));

    }

}
