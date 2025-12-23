package com.google.android.material.datepicker;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.icu.text.DisplayContext;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.R;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
class UtcDates {
    static final String UTC = "UTC";
    static AtomicReference<TimeSource> timeSourceRef = new AtomicReference<>();

    static SimpleDateFormat getDefaultTextInputFormat() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(getDatePatternAsInputFormat(((SimpleDateFormat) DateFormat.getDateInstance(3, Locale.getDefault())).toPattern()), Locale.getDefault());
        simpleDateFormat.setTimeZone(getTimeZone());
        simpleDateFormat.setLenient(false);
        return simpleDateFormat;
    }

    static DateFormat getFullFormat() {
        return getFullFormat(Locale.getDefault());
    }

    static DateFormat getMediumFormat() {
        return getMediumFormat(Locale.getDefault());
    }

    static DateFormat getMediumNoYear() {
        return getMediumNoYear(Locale.getDefault());
    }

    static SimpleDateFormat getSimpleFormat(String str) {
        return getSimpleFormat(str, Locale.getDefault());
    }

    static Calendar getUtcCalendar() {
        return getUtcCalendarOf(null);
    }

    @NonNull
    private static String removeYearFromDateFormatPattern(@NonNull String str) {
        int findCharactersInDateFormatPattern = findCharactersInDateFormatPattern(str, "yY", 1, 0);
        if (findCharactersInDateFormatPattern >= str.length()) {
            return str;
        }
        String str2 = "EMd";
        int findCharactersInDateFormatPattern2 = findCharactersInDateFormatPattern(str, "EMd", 1, findCharactersInDateFormatPattern);
        if (findCharactersInDateFormatPattern2 < str.length()) {
            str2 = "EMd,";
        }
        return str.replace(str.substring(findCharactersInDateFormatPattern(str, str2, -1, findCharactersInDateFormatPattern) + 1, findCharactersInDateFormatPattern2), " ").trim();
    }

    private static int findCharactersInDateFormatPattern(@NonNull String str, @NonNull String str2, int i6, int i7) {
        while (i7 >= 0 && i7 < str.length() && str2.indexOf(str.charAt(i7)) == -1) {
            if (str.charAt(i7) == '\'') {
                do {
                    i7 += i6;
                    if (i7 >= 0 && i7 < str.length()) {
                    }
                } while (str.charAt(i7) != '\'');
            }
            i7 += i6;
        }
        return i7;
    }

    @TargetApi(24)
    static android.icu.text.DateFormat getAbbrMonthDayFormat(Locale locale) {
        return getAndroidFormat("MMMd", locale);
    }

    @NonNull
    static String getDatePatternAsInputFormat(@NonNull String str) {
        return str.replaceAll("[^dMy/\\-.]", "").replaceAll("d{1,2}", "dd").replaceAll("M{1,2}", "MM").replaceAll("y{1,4}", "yyyy").replaceAll("\\.$", "").replaceAll("My", "M/y");
    }

    static DateFormat getFullFormat(Locale locale) {
        return getFormat(0, locale);
    }

    static DateFormat getMediumFormat(Locale locale) {
        return getFormat(2, locale);
    }

    static DateFormat getMediumNoYear(Locale locale) {
        SimpleDateFormat simpleDateFormat = (SimpleDateFormat) getMediumFormat(locale);
        simpleDateFormat.applyPattern(removeYearFromDateFormatPattern(simpleDateFormat.toPattern()));
        return simpleDateFormat;
    }

    @TargetApi(24)
    static android.icu.text.DateFormat getMonthWeekdayDayFormat(Locale locale) {
        return getAndroidFormat("MMMMEEEEd", locale);
    }

    private static SimpleDateFormat getSimpleFormat(String str, Locale locale) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, locale);
        simpleDateFormat.setTimeZone(getTimeZone());
        return simpleDateFormat;
    }

    static TimeSource getTimeSource() {
        TimeSource timeSource = timeSourceRef.get();
        return timeSource == null ? TimeSource.system() : timeSource;
    }

    private static TimeZone getTimeZone() {
        return TimeZone.getTimeZone(UTC);
    }

    @TargetApi(24)
    private static android.icu.util.TimeZone getUtcAndroidTimeZone() {
        android.icu.util.TimeZone timeZone;
        timeZone = android.icu.util.TimeZone.getTimeZone(UTC);
        return timeZone;
    }

    @TargetApi(24)
    static android.icu.text.DateFormat getYearAbbrMonthDayFormat(Locale locale) {
        return getAndroidFormat("yMMMd", locale);
    }

    @TargetApi(24)
    static android.icu.text.DateFormat getYearMonthFormat(Locale locale) {
        return getAndroidFormat("yMMMM", locale);
    }

    @TargetApi(24)
    static android.icu.text.DateFormat getYearMonthWeekdayDayFormat(Locale locale) {
        return getAndroidFormat("yMMMMEEEEd", locale);
    }

    static void setTimeSource(@Nullable TimeSource timeSource) {
        timeSourceRef.set(timeSource);
    }

    private UtcDates() {
    }

    static long canonicalYearMonthDay(long j6) {
        Calendar utcCalendar = getUtcCalendar();
        utcCalendar.setTimeInMillis(j6);
        return getDayCopy(utcCalendar).getTimeInMillis();
    }

    @TargetApi(24)
    private static android.icu.text.DateFormat getAndroidFormat(String str, Locale locale) {
        android.icu.text.DateFormat instanceForSkeleton;
        DisplayContext displayContext;
        instanceForSkeleton = android.icu.text.DateFormat.getInstanceForSkeleton(str, locale);
        instanceForSkeleton.setTimeZone(getUtcAndroidTimeZone());
        displayContext = DisplayContext.CAPITALIZATION_FOR_STANDALONE;
        instanceForSkeleton.setContext(displayContext);
        return instanceForSkeleton;
    }

    static Calendar getDayCopy(Calendar calendar) {
        Calendar utcCalendarOf = getUtcCalendarOf(calendar);
        Calendar utcCalendar = getUtcCalendar();
        utcCalendar.set(utcCalendarOf.get(1), utcCalendarOf.get(2), utcCalendarOf.get(5));
        return utcCalendar;
    }

    static String getDefaultTextInputHint(Resources resources, SimpleDateFormat simpleDateFormat) {
        String pattern = simpleDateFormat.toPattern();
        String string = resources.getString(R.string.mtrl_picker_text_input_year_abbr);
        String string2 = resources.getString(R.string.mtrl_picker_text_input_month_abbr);
        String string3 = resources.getString(R.string.mtrl_picker_text_input_day_abbr);
        if (Locale.getDefault().getLanguage().equals(Locale.KOREAN.getLanguage())) {
            pattern = pattern.replaceAll("d+", "d").replaceAll("M+", "M").replaceAll("y+", "y");
        }
        return pattern.replace("d", string3).replace("M", string2).replace("y", string);
    }

    private static DateFormat getFormat(int i6, Locale locale) {
        DateFormat dateInstance = DateFormat.getDateInstance(i6, locale);
        dateInstance.setTimeZone(getTimeZone());
        return dateInstance;
    }

    static DateFormat getNormalizedFormat(@NonNull DateFormat dateFormat) {
        DateFormat dateFormat2 = (DateFormat) dateFormat.clone();
        dateFormat2.setTimeZone(getTimeZone());
        return dateFormat2;
    }

    static Calendar getTodayCalendar() {
        Calendar now = getTimeSource().now();
        now.set(11, 0);
        now.set(12, 0);
        now.set(13, 0);
        now.set(14, 0);
        now.setTimeZone(getTimeZone());
        return now;
    }

    static Calendar getUtcCalendarOf(@Nullable Calendar calendar) {
        Calendar calendar2 = Calendar.getInstance(getTimeZone());
        if (calendar == null) {
            calendar2.clear();
            return calendar2;
        }
        calendar2.setTimeInMillis(calendar.getTimeInMillis());
        return calendar2;
    }
}
