package com.baidu.liantian.b;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class l {

    /* renamed from: c, reason: collision with root package name */
    private static final l f10364c = new l();

    /* renamed from: a, reason: collision with root package name */
    private HandlerThread f10365a;

    /* renamed from: b, reason: collision with root package name */
    private Handler f10366b;

    public static Looper a() {
        return f10364c.f10366b.getLooper();
    }

    private l() {
        HandlerThread handlerThread = new HandlerThread("rp_th", 10);
        this.f10365a = handlerThread;
        handlerThread.start();
        this.f10366b = new Handler(this.f10365a.getLooper());
    }
}
