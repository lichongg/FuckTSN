package com.kwad.sdk.crash.utils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class j {
    public static String aP(long j6) {
        String valueOf;
        String valueOf2;
        long j7 = j6 / 60000;
        long j8 = (j6 - (60000 * j7)) / 1000;
        if (j7 < 10) {
            valueOf = "0" + j7;
        } else {
            valueOf = String.valueOf(j7);
        }
        if (j8 < 10) {
            valueOf2 = "0" + j8;
        } else {
            valueOf2 = String.valueOf(j8);
        }
        return valueOf + ":" + valueOf2;
    }
}
