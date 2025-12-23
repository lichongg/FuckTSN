package com.kwad.components.core.t;

import java.util.Locale;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class e {
    public static String a(long j6, boolean z5) {
        String[] strArr = {" B", " KB", " MB", " GB", " TB", " PB", " EB", " ZB", " YB"};
        if (j6 > 1) {
            double d6 = j6;
            int log = (int) (Math.log(d6) / Math.log(1024.0d));
            return String.format(Locale.ENGLISH, "%.1f%s", Double.valueOf(j6 > 1024 ? d6 / Math.pow(1024.0d, log) : d6 / 1024.0d), strArr[log]);
        }
        return j6 + "B";
    }
}
