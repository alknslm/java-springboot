package com.alknslm.scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component //spring container'da nesnesi üeritlsin diye konuldu
public class ScheduledExample {

//    @Scheduled(cron = "0 30 17 * * *") // saat 17.27'de servisi çalıştır.
//    public void write1To10(){
//        for(int i=1; i<=10; i++){
//            System.out.print(i+ " ");
//        }
//    }
//
//    @Scheduled(cron = "*/5 * * * * *") // her 5 snde çalış.
//    public void writeEvery5second(){
//        for(int i=1; i<=10; i++){
//            System.out.print(i+ " ");
//        }
//    }
}
