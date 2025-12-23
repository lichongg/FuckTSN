package com.google.gson.internal.bind.util;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class ISO8601Utils {
    private static final String UTC_ID = "UTC";
    private static final TimeZone TIMEZONE_UTC = TimeZone.getTimeZone(UTC_ID);

    public static String format(Date date) {
        return format(date, false, TIMEZONE_UTC);
    }

    public static String format(Date date, boolean z5) {
        return format(date, z5, TIMEZONE_UTC);
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00de A[Catch: IllegalArgumentException -> 0x004a, NumberFormatException -> 0x004d, IndexOutOfBoundsException -> 0x0050, TryCatch #2 {IllegalArgumentException -> 0x004a, IndexOutOfBoundsException -> 0x0050, NumberFormatException -> 0x004d, blocks: (B:3:0x0004, B:5:0x0017, B:6:0x0019, B:8:0x0025, B:9:0x0027, B:11:0x0036, B:13:0x003c, B:18:0x005a, B:20:0x006a, B:21:0x006c, B:23:0x0078, B:24:0x007b, B:26:0x0081, B:30:0x008b, B:35:0x009b, B:37:0x00a3, B:42:0x00d8, B:44:0x00de, B:46:0x00e4, B:47:0x0191, B:52:0x00ee, B:53:0x0109, B:54:0x010a, B:57:0x0126, B:59:0x0133, B:62:0x013c, B:64:0x015b, B:67:0x016a, B:68:0x018c, B:70:0x018f, B:71:0x0115, B:72:0x01c2, B:73:0x01c9, B:74:0x00bb, B:75:0x00be), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01c2 A[Catch: IllegalArgumentException -> 0x004a, NumberFormatException -> 0x004d, IndexOutOfBoundsException -> 0x0050, TryCatch #2 {IllegalArgumentException -> 0x004a, IndexOutOfBoundsException -> 0x0050, NumberFormatException -> 0x004d, blocks: (B:3:0x0004, B:5:0x0017, B:6:0x0019, B:8:0x0025, B:9:0x0027, B:11:0x0036, B:13:0x003c, B:18:0x005a, B:20:0x006a, B:21:0x006c, B:23:0x0078, B:24:0x007b, B:26:0x0081, B:30:0x008b, B:35:0x009b, B:37:0x00a3, B:42:0x00d8, B:44:0x00de, B:46:0x00e4, B:47:0x0191, B:52:0x00ee, B:53:0x0109, B:54:0x010a, B:57:0x0126, B:59:0x0133, B:62:0x013c, B:64:0x015b, B:67:0x016a, B:68:0x018c, B:70:0x018f, B:71:0x0115, B:72:0x01c2, B:73:0x01c9, B:74:0x00bb, B:75:0x00be), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01ce  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.Date parse(java.lang.String r18, java.text.ParsePosition r19) throws java.text.ParseException {
        /*
            Method dump skipped, instructions count: 562
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.bind.util.ISO8601Utils.parse(java.lang.String, java.text.ParsePosition):java.util.Date");
    }

    private static int parseInt(String str, int i6, int i7) throws NumberFormatException {
        int i8;
        int i9;
        if (i6 < 0 || i7 > str.length() || i6 > i7) {
            throw new NumberFormatException(str);
        }
        if (i6 < i7) {
            i9 = i6 + 1;
            int digit = Character.digit(str.charAt(i6), 10);
            if (digit < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i6, i7));
            }
            i8 = -digit;
        } else {
            i8 = 0;
            i9 = i6;
        }
        while (i9 < i7) {
            int i10 = i9 + 1;
            int digit2 = Character.digit(str.charAt(i9), 10);
            if (digit2 < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i6, i7));
            }
            i8 = (i8 * 10) - digit2;
            i9 = i10;
        }
        return -i8;
    }

    private static boolean checkOffset(String str, int i6, char c6) {
        if (i6 < str.length() && str.charAt(i6) == c6) {
            return true;
        }
        return false;
    }

    public static String format(Date date, boolean z5, TimeZone timeZone) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(timeZone, Locale.US);
        gregorianCalendar.setTime(date);
        StringBuilder sb = new StringBuilder(19 + (z5 ? 4 : 0) + (timeZone.getRawOffset() == 0 ? 1 : 6));
        padInt(sb, gregorianCalendar.get(1), 4);
        sb.append('-');
        padInt(sb, gregorianCalendar.get(2) + 1, 2);
        sb.append('-');
        padInt(sb, gregorianCalendar.get(5), 2);
        sb.append('T');
        padInt(sb, gregorianCalendar.get(11), 2);
        sb.append(':');
        padInt(sb, gregorianCalendar.get(12), 2);
        sb.append(':');
        padInt(sb, gregorianCalendar.get(13), 2);
        if (z5) {
            sb.append('.');
            padInt(sb, gregorianCalendar.get(14), 3);
        }
        int offset = timeZone.getOffset(gregorianCalendar.getTimeInMillis());
        if (offset != 0) {
            int i6 = offset / 60000;
            int abs = Math.abs(i6 / 60);
            int abs2 = Math.abs(i6 % 60);
            sb.append(offset >= 0 ? '+' : '-');
            padInt(sb, abs, 2);
            sb.append(':');
            padInt(sb, abs2, 2);
        } else {
            sb.append('Z');
        }
        return sb.toString();
    }

    private static int indexOfNonDigit(String str, int i6) {
        while (i6 < str.length()) {
            char charAt = str.charAt(i6);
            if (charAt >= '0' && charAt <= '9') {
                i6++;
            } else {
                return i6;
            }
        }
        return str.length();
    }

    private static void padInt(StringBuilder sb, int i6, int i7) {
        String num = Integer.toString(i6);
        for (int length = i7 - num.length(); length > 0; length--) {
            sb.append('0');
        }
        sb.append(num);
    }
}
