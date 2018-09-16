package javarank.com.dreamjournalui.home.ui.util;

public enum Month {
    JANUARY("Jan"),
    FEBRUARY("Feb"),
    MARCH("Mar"),
    APRIL("Apr"),
    MAY("May"),
    JUNE("Jun"),
    JULY("Jul"),
    AUGUST("Aug"),
    SEPTEMBER("Sep"),
    OCTOBER("Oct"),
    NOVEMBER("Nov"),
    DECEMBER("Dec");

    private final String name;

    Month(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
