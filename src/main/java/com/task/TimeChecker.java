package com.task;

import java.time.LocalTime;
import static com.task.DayPart.*;

/**
 * @author Sergiy_Solovyov
 */
public class TimeChecker {


    public DayPart getDayPart(LocalTime current){

        if(current.isAfter(MORNING.getStart().minusNanos(1)) && current.isBefore(MORNING.getEnd())) {
            return MORNING;
        } else if (current.isAfter(DAY.getStart().minusNanos(1)) && current.isBefore(DAY.getEnd())){
            return DAY;
        } else if (current.isAfter(EVENING.getStart().minusNanos(1)) && current.isBefore(EVENING.getEnd())){
            return EVENING;
        } else
            return NIGHT;
    }
}
