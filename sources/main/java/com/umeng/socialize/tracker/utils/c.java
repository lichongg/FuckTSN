package com.umeng.socialize.tracker.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static final int f42526a = 1;

    /* renamed from: b, reason: collision with root package name */
    private static ExecutorService f42527b = Executors.newFixedThreadPool(1);

    public static void a(Runnable runnable) {
        if (runnable != null) {
            f42527b.execute(runnable);
        }
    }
}
