package com.kwad.sdk.utils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class p {
    public static long aYX;
    public static long sLaunchTime;

    public static long PP() {
        return aYX - sLaunchTime;
    }

    public static String a(StackTraceElement stackTraceElement) {
        return stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName();
    }

    public static void setInitStartTime(long j6) {
        aYX = j6;
    }

    public static void setLaunchTime(long j6) {
        sLaunchTime = j6;
    }
}
