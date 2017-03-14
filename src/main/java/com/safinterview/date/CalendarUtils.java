package com.safinterview.date;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CalendarUtils {
    public static String getMonth(int monthOfYear) {
        switch (monthOfYear) {
            case 1:
                return "January";

            case 2:
                return "February";

            case 3:
                return "March";

            case 4:
                return "April";

            case 5:
                return "May";

            case 6:
                return "June";

            case 7:
                return "July";

            case 8:
                return "August";

            case 9:
                return "September";

            case 10:
                return "October";

            case 11:
                return "November";

            case 12:
                return "December";

            default:
                return "Invalid";
        }
    }

    /**
     * Get the time in milliseconds of this time
     *
     * @param pattern date format
     * @param time    time to convert
     * @return timeInMillis
     */
    public static long parseTime(String pattern, String time) {
        try {
            return new SimpleDateFormat(pattern).parse(time).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * Formats the passed milliseconds to the defined pattern
     *
     * @param pattern      time/date pattern
     * @param milliSeconds milliseconds
     * @return formatted time/date
     */
    public static String getFormattedDate(String pattern, long milliSeconds) {
        return new SimpleDateFormat(pattern, Locale.ENGLISH).format(new Date(milliSeconds));
    }

    /**
     * Performs a quick time comparison to determine if the passed timestamp is an incoming time stamp
     *
     * @param timeInMillis time stamp to test
     * @return dateIsIncoming
     */
    public static boolean isIncomingDate(long timeInMillis) {
        return timeInMillis > System.currentTimeMillis();
    }

    public static String getFriendlyTime(long baseTime, long targetTime) {
        String tense = baseTime > targetTime ? "ago" : "coming";
        return CalendarUtils.getFormattedDate("hh:mm", (targetTime - baseTime));
    }

    /**
     * Get the system year
     *
     * @return year
     */
    public static int getSystemYear() {
        return Integer.parseInt(getFormattedDate("yyy", System.currentTimeMillis()));
    }

    /**
     * Get the current system month
     *
     * @return month of the year
     */
    public static int getSystemMonth() {
        return Integer.parseInt(getFormattedDate("MM", System.currentTimeMillis()));
    }

    /**
     * Get the current system date
     *
     * @return date of the month
     */
    public static int getSystemDate() {
        return Integer.parseInt(getFormattedDate("dd", System.currentTimeMillis()));
    }

    /**
     * Get the current minute of the system
     *
     * @return minutes of the hour
     */
    public static int getSystemMinute() {
        return Integer.parseInt(getFormattedDate("mm", System.currentTimeMillis()));
    }

    /**
     * Get the current hour of the system
     *
     * @return hour of the day
     */
    public static int getSystemHour() {
        return Integer.parseInt(getFormattedDate("hh", System.currentTimeMillis()));
    }

    /**
     * Returns time in yyy-MM-dd hh:mm:ss a format
     *
     * @param millis
     * @return
     */
    public static String getDefaultDate(long millis) {
        return getFormattedDate("yyy-MM-dd hh:mm:ss a", millis);
    }
}
