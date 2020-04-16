package com.education.system_edu.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
    /**MaNongXF
     * 判断时间是否处于某个时间段内
     *
     * @param time 需要比较的时间
     * @param from 起始时间
     * @param to 结束时间
     * @return
     */
    public static boolean belongCalendar(Date time, Date from, Date to) {
        Calendar date = Calendar.getInstance();
        date.setTime(time);
        Calendar after = Calendar.getInstance();
        after.setTime(from);
        Calendar before = Calendar.getInstance();
        before.setTime(to);
        if (date.after(after) && date.before(before)) {
            return true;
        } else {
            return false;
        }
    }
    public static boolean belongCalendarStringDate(String time, String from, String to) throws ParseException {
        return belongCalendar(stringToDate(time),stringToDate(from),stringToDate(to));
    }
    public static boolean belongCalendarDateStringDate(Date date, String from, String to) throws ParseException {
        return belongCalendar(date,stringToDate(from),stringToDate(to));
    }
    public static Date stringToDate(String time) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//yyyy-mm-dd, 会出现时间不对, 因为小写的mm是代表: 秒
        return sdf.parse(time);
    }

}
