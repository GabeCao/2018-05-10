package com.lv.Utils;

import java.util.Date;

public class DateUtils {
    //beginDate <= inputDate < endDate
    public static boolean betweenDates(Date beginDate, Date endDate, Date inputDate) {
        return inputDate.after(beginDate)&&inputDate.before(endDate) || (inputDate.getTime() == beginDate.getTime());
    }
}
