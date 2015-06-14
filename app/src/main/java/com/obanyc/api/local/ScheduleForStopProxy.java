package com.obanyc.api.local;

import android.graphics.BitmapFactory;

import java.util.List;

import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.obanyc.api.where.scheduleforstop.*;

import javax.annotation.Nullable;

import autovalue.shaded.com.google.common.common.base.Function;
import autovalue.shaded.com.google.common.common.collect.Lists;

/**
 * Created by toliuweijing on 6/13/15.
 */
public class ScheduleForStopProxy {

  public static Optional<List<Primitives.Schedule>> toSchedules(
      ScheduleForStopRoot root,
      final String routeId) {
    Optional<StopRouteSchedule> stopRouteDirectionSchedule = Iterables.tryFind(
        root.getData().getEntry().getStopRouteSchedules(),
        new Predicate<StopRouteSchedule>() {
          @Override
          public boolean apply(StopRouteSchedule input) {
            return input.getRouteId().equals(routeId);
          }
        });
    if (!stopRouteDirectionSchedule.isPresent()) {
      return Optional.absent();
    }

    StopRouteDirectionSchedule s = stopRouteDirectionSchedule
        .orNull()
        .getStopRouteDirectionSchedules()
        .get(0);
    List<Primitives.Schedule> schedules = Lists.transform(
        s.getScheduleStopTimes(),
        new Function<ScheduleStopTime, Primitives.Schedule>() {
          @Override
          public Primitives.Schedule apply(ScheduleStopTime scheduleStopTime) {
            return toSchedules(scheduleStopTime);
          }
        });
    return Optional.of(schedules);
  }

  public static Primitives.Schedule toSchedules(ScheduleStopTime scheduleStopTime) {
    return Primitives.Schedule.create(
        scheduleStopTime.getArrivalTime(),
        scheduleStopTime.getDepartureTime());
  }
}
