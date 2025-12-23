package com.google.android.material.datepicker;

import androidx.annotation.Nullable;
import java.util.Calendar;
import java.util.TimeZone;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
class TimeSource {
    private static final TimeSource SYSTEM_TIME_SOURCE = new TimeSource(null, null);

    @Nullable
    private final Long fixedTimeMs;

    @Nullable
    private final TimeZone fixedTimeZone;

    static TimeSource fixed(long j6, @Nullable TimeZone timeZone) {
        return new TimeSource(Long.valueOf(j6), timeZone);
    }

    Calendar now() {
        return now(this.fixedTimeZone);
    }

    static TimeSource fixed(long j6) {
        return new TimeSource(Long.valueOf(j6), null);
    }

    static TimeSource system() {
        return SYSTEM_TIME_SOURCE;
    }

    Calendar now(@Nullable TimeZone timeZone) {
        Calendar calendar = timeZone == null ? Calendar.getInstance() : Calendar.getInstance(timeZone);
        Long l6 = this.fixedTimeMs;
        if (l6 != null) {
            calendar.setTimeInMillis(l6.longValue());
        }
        return calendar;
    }

    private TimeSource(@Nullable Long l6, @Nullable TimeZone timeZone) {
        this.fixedTimeMs = l6;
        this.fixedTimeZone = timeZone;
    }
}
