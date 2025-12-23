package com.kwad.sdk.utils;

import java.util.Formatter;
import java.util.Locale;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class bu {
    public static String aq(long j6) {
        if (j6 <= 0 || j6 >= 86400000) {
            return "00:00";
        }
        try {
            long j7 = j6 / 1000;
            long j8 = j7 % 60;
            long j9 = (j7 / 60) % 60;
            long j10 = j7 / 3600;
            Formatter formatter = new Formatter(new StringBuilder(), Locale.getDefault());
            return j10 > 0 ? formatter.format("%d:%02d:%02d", Long.valueOf(j10), Long.valueOf(j9), Long.valueOf(j8)).toString() : formatter.format("%02d:%02d", Long.valueOf(j9), Long.valueOf(j8)).toString();
        } catch (Exception e6) {
            com.kwad.sdk.core.d.c.printStackTrace(e6);
            return "";
        }
    }
}
