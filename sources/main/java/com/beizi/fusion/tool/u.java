package com.beizi.fusion.tool;

import android.os.Handler;
import android.os.Looper;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class u {

    /* renamed from: a, reason: collision with root package name */
    private static final Handler f13774a = new Handler(Looper.getMainLooper());

    public static void a(Runnable runnable, long j6) {
        f13774a.postDelayed(runnable, j6);
    }
}
