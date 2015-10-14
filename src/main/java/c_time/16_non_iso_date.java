package c_time;

import java.time.LocalDateTime;
import java.time.chrono.HijrahDate;
import java.time.chrono.JapaneseDate;
import java.time.chrono.MinguoDate;
import java.time.chrono.ThaiBuddhistDate;

class NonIsoDate {
    public static void main(String[] args) {
        LocalDateTime date = LocalDateTime.now();
        System.out.println(JapaneseDate.from(date));
        System.out.println(HijrahDate.from(date));
        System.out.println(MinguoDate.from(date));
        System.out.println(ThaiBuddhistDate.from(date));
    }
}
