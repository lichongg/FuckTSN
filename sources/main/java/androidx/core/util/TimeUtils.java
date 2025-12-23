package androidx.core.util;

import androidx.annotation.RestrictTo;
import java.io.PrintWriter;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: D:\Downloads\app\classes.dex */
public final class TimeUtils {

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final int HUNDRED_DAY_FIELD_LEN = 19;
    private static final int SECONDS_PER_DAY = 86400;
    private static final int SECONDS_PER_HOUR = 3600;
    private static final int SECONDS_PER_MINUTE = 60;
    private static final Object sFormatSync = new Object();
    private static char[] sFormatStr = new char[24];

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static void formatDuration(long j6, StringBuilder sb) {
        synchronized (sFormatSync) {
            sb.append(sFormatStr, 0, formatDurationLocked(j6, 0));
        }
    }

    private static int accumField(int i6, int i7, boolean z5, int i8) {
        if (i6 > 99 || (z5 && i8 >= 3)) {
            return i7 + 3;
        }
        if (i6 > 9 || (z5 && i8 >= 2)) {
            return i7 + 2;
        }
        if (z5 || i6 > 0) {
            return i7 + 1;
        }
        return 0;
    }

    private static int formatDurationLocked(long j6, int i6) {
        char c6;
        int i7;
        int i8;
        int i9;
        int i10;
        long j7 = j6;
        if (sFormatStr.length < i6) {
            sFormatStr = new char[i6];
        }
        char[] cArr = sFormatStr;
        if (j7 == 0) {
            int i11 = i6 - 1;
            while (i11 > 0) {
                cArr[0] = ' ';
            }
            cArr[0] = '0';
            return 1;
        }
        if (j7 > 0) {
            c6 = '+';
        } else {
            j7 = -j7;
            c6 = '-';
        }
        int i12 = (int) (j7 % 1000);
        int floor = (int) Math.floor(j7 / 1000);
        if (floor > 86400) {
            i7 = floor / 86400;
            floor -= 86400 * i7;
        } else {
            i7 = 0;
        }
        if (floor > 3600) {
            i8 = floor / 3600;
            floor -= i8 * 3600;
        } else {
            i8 = 0;
        }
        if (floor > 60) {
            int i13 = floor / 60;
            floor -= i13 * 60;
            i9 = i13;
        } else {
            i9 = 0;
        }
        if (i6 != 0) {
            int accumField = accumField(i7, 1, false, 0);
            int accumField2 = accumField + accumField(i8, 1, accumField > 0, 2);
            int accumField3 = accumField2 + accumField(i9, 1, accumField2 > 0, 2);
            int accumField4 = accumField3 + accumField(floor, 1, accumField3 > 0, 2);
            i10 = 0;
            for (int accumField5 = accumField4 + accumField(i12, 2, true, accumField4 > 0 ? 3 : 0) + 1; accumField5 < i6; accumField5++) {
                cArr[i10] = ' ';
                i10++;
            }
        } else {
            i10 = 0;
        }
        cArr[i10] = c6;
        int i14 = i10 + 1;
        boolean z5 = i6 != 0;
        int printField = printField(cArr, i7, 'd', i14, false, 0);
        int printField2 = printField(cArr, i8, 'h', printField, printField != i14, z5 ? 2 : 0);
        int printField3 = printField(cArr, i9, 'm', printField2, printField2 != i14, z5 ? 2 : 0);
        int printField4 = printField(cArr, floor, 's', printField3, printField3 != i14, z5 ? 2 : 0);
        int printField5 = printField(cArr, i12, 'm', printField4, true, (!z5 || printField4 == i14) ? 0 : 3);
        cArr[printField5] = 's';
        return printField5 + 1;
    }

    private static int printField(char[] cArr, int i6, char c6, int i7, boolean z5, int i8) {
        int i9;
        if (!z5 && i6 <= 0) {
            return i7;
        }
        if ((!z5 || i8 < 3) && i6 <= 99) {
            i9 = i7;
        } else {
            int i10 = i6 / 100;
            cArr[i7] = (char) (i10 + 48);
            i9 = i7 + 1;
            i6 -= i10 * 100;
        }
        if ((z5 && i8 >= 2) || i6 > 9 || i7 != i9) {
            int i11 = i6 / 10;
            cArr[i9] = (char) (i11 + 48);
            i9++;
            i6 -= i11 * 10;
        }
        cArr[i9] = (char) (i6 + 48);
        cArr[i9 + 1] = c6;
        return i9 + 2;
    }

    private TimeUtils() {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static void formatDuration(long j6, PrintWriter printWriter, int i6) {
        synchronized (sFormatSync) {
            printWriter.print(new String(sFormatStr, 0, formatDurationLocked(j6, i6)));
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static void formatDuration(long j6, PrintWriter printWriter) {
        formatDuration(j6, printWriter, 0);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static void formatDuration(long j6, long j7, PrintWriter printWriter) {
        if (j6 == 0) {
            printWriter.print("--");
        } else {
            formatDuration(j6 - j7, printWriter, 0);
        }
    }
}
