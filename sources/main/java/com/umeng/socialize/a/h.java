package com.umeng.socialize.a;

import java.lang.ref.WeakReference;
import java.util.concurrent.Future;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private static WeakReference<Future<?>> f42233a;

    public static void a() {
        Future<?> future;
        WeakReference<Future<?>> weakReference = f42233a;
        if (weakReference == null || (future = weakReference.get()) == null || future.isDone() || future.isCancelled()) {
            f42233a = new WeakReference<>(j.a(new g()));
        }
    }
}
