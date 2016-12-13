package com.task;

import java.time.LocalTime;

/**
 * @author Sergiy_Solovyov
 */
public enum DayPart {

    MORNING(LocalTime.of(6, 00), LocalTime.of(9, 00)),
    DAY(LocalTime.of(9, 0), LocalTime.of(19, 0)),
    EVENING(LocalTime.of(19, 0), LocalTime.of(23, 0)),
    NIGHT(LocalTime.of(23, 0), LocalTime.of(6, 0));

    private final LocalTime start;
    private final LocalTime end;

    DayPart(final LocalTime start, final LocalTime end) {
        this.start = start;
        this.end = end;
    }

    public LocalTime getEnd() {
        return end;
    }

    public LocalTime getStart() {
        return start;
    }
}
