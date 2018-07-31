package com.toko.dates;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class TokoDates {

    private static final String BEFORE="Before";
    private static final String AFTER="After";
    public static void main(String[] args){
       main2();
;    }


    public static void main2(){

        Set<Date> dates=new LinkedHashSet<>();
        int addDays = 5;
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 4);
        int firstCall=1;
        System.out.println("Current Date :"+calendar.getTime());
        do {
            getResult(calendar,dates,firstCall);
           } while (dates.size() < addDays);
        System.out.println("Here is new solution: " + dates.size());
        for (Date f:dates){
            System.out.println("Test :"+f +" :");
        }
    }
    public static void addDate(Calendar calendar,int incrementDays,Set<Date> dates,String type){
        if(AFTER.equals(type)){
            calendar.add(Calendar.DAY_OF_MONTH, incrementDays);
            dates.add(calendar.getTime());
            return;
        }
        dates.add(calendar.getTime());
        calendar.add(Calendar.DAY_OF_MONTH, incrementDays);
    }

    public static void getResult(Calendar calendar,Set<Date> dates,int firstCall){
        if (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY
                && calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY)
        {
            switch (calendar.get(Calendar.DAY_OF_WEEK)){
                case Calendar.FRIDAY: {
                    if(firstCall==1) {
                    addDate(calendar, 3, dates, AFTER);
                    firstCall=0;
                    return;
                }
                addDate(calendar,2,dates,BEFORE);}
                ;break;
                default:addDate(calendar,1,dates,AFTER);break;
            }
        }
        switch (calendar.get(Calendar.DAY_OF_WEEK)){
            case Calendar.SATURDAY: addDate(calendar,2,dates,AFTER);break;
            case Calendar.SUNDAY: addDate(calendar,1,dates,AFTER);break;
        }
    }
}
