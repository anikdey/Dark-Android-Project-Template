package javarank.com.dreamjournalui.home.model;

public class DateItem {

    private String monthName;
    private int day;

    public DateItem(String monthName, int day) {
        this.monthName = monthName;
        this.day = day;
    }

    public String getMonthName() {
        return monthName;
    }

    public void setMonthName(String monthName) {
        this.monthName = monthName;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
}
