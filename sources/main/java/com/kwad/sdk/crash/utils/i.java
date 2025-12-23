package com.kwad.sdk.crash.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class i {
    private static SimpleDateFormat aRb = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String aO(long j6) {
        return j6 <= 0 ? "unknown" : aRb.format(new Date(j6));
    }
}
