package com.google.android.material.datepicker;

import android.content.Context;
import android.os.Build;
import android.text.format.DateUtils;
import androidx.annotation.Nullable;
import androidx.core.util.Pair;
import com.google.android.material.R;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
class DateStrings {
    static Pair<String, String> getDateRangeString(@Nullable Long l6, @Nullable Long l7) {
        return getDateRangeString(l6, l7, null);
    }

    static String getDateString(long j6) {
        return getDateString(j6, null);
    }

    static String getMonthDay(long j6) {
        return getMonthDay(j6, Locale.getDefault());
    }

    static String getMonthDayOfWeekDay(long j6) {
        return getMonthDayOfWeekDay(j6, Locale.getDefault());
    }

    static String getYearMonthDay(long j6) {
        return getYearMonthDay(j6, Locale.getDefault());
    }

    static String getYearMonthDayOfWeekDay(long j6) {
        return getYearMonthDayOfWeekDay(j6, Locale.getDefault());
    }

    static Pair<String, String> getDateRangeString(@Nullable Long l6, @Nullable Long l7, @Nullable SimpleDateFormat simpleDateFormat) {
        if (l6 == null && l7 == null) {
            return Pair.create(null, null);
        }
        if (l6 == null) {
            return Pair.create(null, getDateString(l7.longValue(), simpleDateFormat));
        }
        if (l7 == null) {
            return Pair.create(getDateString(l6.longValue(), simpleDateFormat), null);
        }
        Calendar todayCalendar = UtcDates.getTodayCalendar();
        Calendar utcCalendar = UtcDates.getUtcCalendar();
        utcCalendar.setTimeInMillis(l6.longValue());
        Calendar utcCalendar2 = UtcDates.getUtcCalendar();
        utcCalendar2.setTimeInMillis(l7.longValue());
        if (simpleDateFormat != null) {
            return Pair.create(simpleDateFormat.format(new Date(l6.longValue())), simpleDateFormat.format(new Date(l7.longValue())));
        }
        return utcCalendar.get(1) == utcCalendar2.get(1) ? utcCalendar.get(1) == todayCalendar.get(1) ? Pair.create(getMonthDay(l6.longValue(), Locale.getDefault()), getMonthDay(l7.longValue(), Locale.getDefault())) : Pair.create(getMonthDay(l6.longValue(), Locale.getDefault()), getYearMonthDay(l7.longValue(), Locale.getDefault())) : Pair.create(getYearMonthDay(l6.longValue(), Locale.getDefault()), getYearMonthDay(l7.longValue(), Locale.getDefault()));
    }

    static String getDateString(long j6, @Nullable SimpleDateFormat simpleDateFormat) {
        return simpleDateFormat != null ? simpleDateFormat.format(new Date(j6)) : isDateWithinCurrentYear(j6) ? getMonthDay(j6) : getYearMonthDay(j6);
    }

    static String getMonthDay(long j6, Locale locale) {
        String format;
        if (Build.VERSION.SDK_INT < 24) {
            return UtcDates.getMediumNoYear(locale).format(new Date(j6));
        }
        format = UtcDates.getAbbrMonthDayFormat(locale).format(new Date(j6));
        return format;
    }

    static String getMonthDayOfWeekDay(long j6, Locale locale) {
        String format;
        if (Build.VERSION.SDK_INT < 24) {
            return UtcDates.getFullFormat(locale).format(new Date(j6));
        }
        format = UtcDates.getMonthWeekdayDayFormat(locale).format(new Date(j6));
        return format;
    }

    static String getYearMonth(long j6) {
        String format;
        if (Build.VERSION.SDK_INT < 24) {
            return DateUtils.formatDateTime(null, j6, 8228);
        }
        format = UtcDates.getYearMonthFormat(Locale.getDefault()).format(new Date(j6));
        return format;
    }

    static String getYearMonthDay(long j6, Locale locale) {
        String format;
        if (Build.VERSION.SDK_INT < 24) {
            return UtcDates.getMediumFormat(locale).format(new Date(j6));
        }
        format = UtcDates.getYearAbbrMonthDayFormat(locale).format(new Date(j6));
        return format;
    }

    static String getYearMonthDayOfWeekDay(long j6, Locale locale) {
        String format;
        if (Build.VERSION.SDK_INT < 24) {
            return UtcDates.getFullFormat(locale).format(new Date(j6));
        }
        format = UtcDates.getYearMonthWeekdayDayFormat(locale).format(new Date(j6));
        return format;
    }

    private DateStrings() {
    }

    static String getDayContentDescription(Context context, long j6, boolean z5, boolean z6, boolean z7) {
        String optionalYearMonthDayOfWeekDay = getOptionalYearMonthDayOfWeekDay(j6);
        if (z5) {
            optionalYearMonthDayOfWeekDay = String.format(context.getString(R.string.mtrl_picker_today_description), optionalYearMonthDayOfWeekDay);
        }
        if (z6) {
            return String.format(context.getString(R.string.mtrl_picker_start_date_description), optionalYearMonthDayOfWeekDay);
        }
        if (z7) {
            return String.format(context.getString(R.string.mtrl_picker_end_date_description), optionalYearMonthDayOfWeekDay);
        }
        return optionalYearMonthDayOfWeekDay;
    }

    static String getOptionalYearMonthDayOfWeekDay(long j6) {
        if (isDateWithinCurrentYear(j6)) {
            return getMonthDayOfWeekDay(j6);
        }
        return getYearMonthDayOfWeekDay(j6);
    }

    static String getYearContentDescription(Context context, int i6) {
        if (UtcDates.getTodayCalendar().get(1) == i6) {
            return String.format(context.getString(R.string.mtrl_picker_navigate_to_current_year_description), Integer.valueOf(i6));
        }
        return String.format(context.getString(R.string.mtrl_picker_navigate_to_year_description), Integer.valueOf(i6));
    }

    private static boolean isDateWithinCurrentYear(long j6) {
        Calendar todayCalendar = UtcDates.getTodayCalendar();
        Calendar utcCalendar = UtcDates.getUtcCalendar();
        utcCalendar.setTimeInMillis(j6);
        if (todayCalendar.get(1) == utcCalendar.get(1)) {
            return true;
        }
        return false;
    }
}
