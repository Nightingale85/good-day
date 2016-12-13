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

        if(current.isAfter(MORNING.getStart().minusNanos(1)) && current.isBefore(MORNING.getEnd())) {
            return MORNING;
        } else if (current.isAfter(DAY.getStart().minusNanos(1)) && current.isBefore(DAY.getEnd())){
            return DAY;
        } else if (current.isAfter(EVENING.getStart().minusNanos(1)) && current.isBefore(EVENING.getEnd())){
            return EVENING;
        } else
            return NIGHT;
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
