package com.qq.e.ads.cfg;

import com.qq.e.comm.util.GDTLogger;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class MultiProcessFlag {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f36574a;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f36575b;

    public static boolean isMultiProcess() {
        return f36574a;
    }

    public static void setMultiProcess(boolean z5) {
        if (f36575b) {
            GDTLogger.w("MultiProcessFlag已经设置过，再次设置无效");
        } else {
            f36575b = true;
            f36574a = z5;
        }
    }
}
