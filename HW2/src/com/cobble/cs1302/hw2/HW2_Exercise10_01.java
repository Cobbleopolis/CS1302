//Class:      CS1302/08
//Term:       Spring 2017
//Name:       Logan Thompson
//Instructor: Monisha Verma
//Assignment: HW2 Exercise 10_1
package com.cobble.cs1302.hw2;

public class HW2_Exercise10_01 {
    public static void main(String[] args) {
        Time time1 = new Time();
        System.out.println("Hour: " + time1.getHour() + " Minute: " +
                time1.getMinute() + " Second: " + time1.getSecond());

        Time time2 = new Time(555550000);
        System.out.println("Hour: " + time2.getHour() + " Minute: " +
                time2.getMinute() + " Second: " + time2.getSecond());
    }
}

class Time {
    private int hour;
    private int minute;
    private int second;

    public Time() {
        this(System.currentTimeMillis());
    }

    public Time(long elapsedTime) {
        setTime(elapsedTime);
    }

    public Time(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }


    //Refer to Listing 2.7 on page 52 of your textbook to implement this method

    /**
     * Sets the time based on a provided time.
     *
     * @param elapsedTime The total number of milliseconds since the Unix Epoch.
     */
    public void setTime(long elapsedTime) {
        // Obtain the total seconds since the Unix Epoch
        int elapsedSecond = (int) (elapsedTime / 1000L);

        // Compute the current second in the minute in the hour
        this.second = elapsedSecond % 60;

        // Obtain the total minutes
        int elapsedMinute = elapsedSecond / 60;

        // Compute the current minute in the hour
        this.minute = elapsedMinute % 60;

        // Obtain the total hours
        int elapsedHour = elapsedMinute / 60;

        // Compute the current hour
        this.hour = elapsedHour % 24;

    }
}
