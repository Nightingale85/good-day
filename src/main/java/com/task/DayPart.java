package com.task;

import java.time.LocalTime;

/**
 * @author Sergiy_Solovyov
 */
public enum DayPart {

    MORNING(LocalTime.of(6, 0), LocalTime.of(9, 0)),
    DAY(LocalTime.of(9, 0), LocalTime.of(19, 0)),
    EVENING(LocalTime.of(19, 0), LocalTime.of(23, 0)),
    NIGHT(LocalTime.of(23, 0), LocalTime.of(6, 0));

    private final LocalTime start;
    private final LocalTime end;

    DayPart(final LocalTime start, final LocalTime end) {
        this.start = start;
        this.end = end;
    }

    public static DayPart getDayPart(LocalTime current){
        if(isInRange(current, MORNING)) {
            return MORNING;
        } else if (isInRange(current, DAY)) {
            return DAY;
        } else if (isInRange(current, EVENING)) {
            return EVENING;
        } else
            return NIGHT;
    }

    private static boolean isInRange(LocalTime current, DayPart dayPart){
        return current.isAfter(dayPart.getStart().minusNanos(1)) && current.isBefore(dayPart.getEnd());
    }

    public LocalTime getEnd() {
        return end;
    }

    public LocalTime getStart() {
        return start;
    }

    public String toLowerCase(){
        return this.name().toLowerCase();
    }
}
