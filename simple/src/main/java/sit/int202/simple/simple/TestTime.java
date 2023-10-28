package sit.int202.simple.simple;

import java.util.Date;

public class TestTime {
    public static void main(String[] args) {
        Date d1 = new Date(1000*60*60*24); // 1000=1s * 60s = 1min * 60min = 1hr * 1day = 24hr -> จะได้เวลามา 1 วัน
        System.out.println(d1); // -> Fri Jan 02 07:00:00 ICT 1970 = วันที่เริ่มนับเป็นครั้งแรกตอน 7 โมงเช้า
        System.out.println(System.currentTimeMillis()); // -> 1693803854146L
        Date d2 = new Date(1693803854146L);
        System.out.println(d2); // -> Mon Sep 04 12:04:14 ICT 2023
    }
}
