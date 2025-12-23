package com.huawei.secure.android.common.util;

import android.os.Handler;
import android.os.Looper;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class l0 {

    /* renamed from: a, reason: collision with root package name */
    private static Handler f35289a = new Handler(Looper.getMainLooper());

    public static void a(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        f35289a.post(runnable);
    }
}
