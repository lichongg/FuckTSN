package com.google.gson.internal;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class PreJava9DateFormatProvider {
    private static String getDateFormatPattern(int i6) {
        if (i6 == 0) {
            return "EEEE, MMMM d, y";
        }
        if (i6 == 1) {
            return "MMMM d, y";
        }
        if (i6 == 2) {
            return "MMM d, y";
        }
        if (i6 == 3) {
            return "M/d/yy";
        }
        throw new IllegalArgumentException("Unknown DateFormat style: " + i6);
    }

    private static String getDatePartOfDateTimePattern(int i6) {
        if (i6 == 0) {
            return "EEEE, MMMM d, yyyy";
        }
        if (i6 == 1) {
            return "MMMM d, yyyy";
        }
        if (i6 == 2) {
            return "MMM d, yyyy";
        }
        if (i6 == 3) {
            return "M/d/yy";
        }
        throw new IllegalArgumentException("Unknown DateFormat style: " + i6);
    }

    private static String getTimePartOfDateTimePattern(int i6) {
        if (i6 == 0 || i6 == 1) {
            return "h:mm:ss a z";
        }
        if (i6 == 2) {
            return "h:mm:ss a";
        }
        if (i6 == 3) {
            return "h:mm a";
        }
        throw new IllegalArgumentException("Unknown DateFormat style: " + i6);
    }

    public static DateFormat getUSDateFormat(int i6) {
        return new SimpleDateFormat(getDateFormatPattern(i6), Locale.US);
    }

    public static DateFormat getUSDateTimeFormat(int i6, int i7) {
        return new SimpleDateFormat(getDatePartOfDateTimePattern(i6) + " " + getTimePartOfDateTimePattern(i7), Locale.US);
    }
}
