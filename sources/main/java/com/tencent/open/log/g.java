package com.tencent.open.log;

import android.text.format.Time;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public static final g f40626a = new g();

    public final String a(int i6) {
        return i6 != 1 ? i6 != 2 ? i6 != 4 ? i6 != 8 ? i6 != 16 ? i6 != 32 ? "-" : ExifInterface.GPS_MEASUREMENT_IN_PROGRESS : ExifInterface.LONGITUDE_EAST : ExifInterface.LONGITUDE_WEST : "I" : "D" : ExifInterface.GPS_MEASUREMENT_INTERRUPTED;
    }

    public String a(int i6, Thread thread, long j6, String str, String str2, Throwable th) {
        long j7 = j6 % 1000;
        Time time = new Time();
        time.set(j6);
        StringBuilder sb = new StringBuilder();
        sb.append(a(i6));
        sb.append('/');
        sb.append(time.format("%Y-%m-%d %H:%M:%S"));
        sb.append('.');
        if (j7 < 10) {
            sb.append("00");
        } else if (j7 < 100) {
            sb.append('0');
        }
        sb.append(j7);
        sb.append(' ');
        sb.append('[');
        if (thread == null) {
            sb.append("N/A");
        } else {
            sb.append(thread.getName());
        }
        sb.append(']');
        sb.append('[');
        sb.append(str);
        sb.append(']');
        sb.append(' ');
        sb.append(str2);
        sb.append('\n');
        if (th != null) {
            sb.append("* Exception : \n");
            sb.append(Log.getStackTraceString(th));
            sb.append('\n');
        }
        return sb.toString();
    }
}
