package com.facebook.rebound;

import android.annotation.TargetApi;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class ChoreographerCompat {

    /* renamed from: c, reason: collision with root package name */
    private static final long f32462c = 17;

    /* renamed from: d, reason: collision with root package name */
    private static final boolean f32463d = true;

    /* renamed from: e, reason: collision with root package name */
    private static ChoreographerCompat f32464e = new ChoreographerCompat();

    /* renamed from: a, reason: collision with root package name */
    private Handler f32465a;

    /* renamed from: b, reason: collision with root package name */
    private Choreographer f32466b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static abstract class FrameCallback {

        /* renamed from: a, reason: collision with root package name */
        private Runnable f32467a;

        /* renamed from: b, reason: collision with root package name */
        private Choreographer.FrameCallback f32468b;

        public abstract void a(long j6);

        @TargetApi(16)
        Choreographer.FrameCallback b() {
            if (this.f32468b == null) {
                this.f32468b = new Choreographer.FrameCallback() { // from class: com.facebook.rebound.ChoreographerCompat.FrameCallback.1
                    @Override // android.view.Choreographer.FrameCallback
                    public void doFrame(long j6) {
                        FrameCallback.this.a(j6);
                    }
                };
            }
            return this.f32468b;
        }

        Runnable c() {
            if (this.f32467a == null) {
                this.f32467a = new Runnable() { // from class: com.facebook.rebound.ChoreographerCompat.FrameCallback.2
                    @Override // java.lang.Runnable
                    public void run() {
                        FrameCallback.this.a(System.nanoTime());
                    }
                };
            }
            return this.f32467a;
        }
    }

    @TargetApi(16)
    private void a(Choreographer.FrameCallback frameCallback) {
        this.f32466b.postFrameCallback(frameCallback);
    }

    @TargetApi(16)
    private void b(Choreographer.FrameCallback frameCallback, long j6) {
        this.f32466b.postFrameCallbackDelayed(frameCallback, j6);
    }

    @TargetApi(16)
    private void c(Choreographer.FrameCallback frameCallback) {
        this.f32466b.removeFrameCallback(frameCallback);
    }

    public static ChoreographerCompat e() {
        return f32464e;
    }

    public void f(FrameCallback frameCallback) {
        if (f32463d) {
            a(frameCallback.b());
        } else {
            this.f32465a.postDelayed(frameCallback.c(), 0L);
        }
    }

    public void g(FrameCallback frameCallback, long j6) {
        if (f32463d) {
            b(frameCallback.b(), j6);
        } else {
            this.f32465a.postDelayed(frameCallback.c(), j6 + f32462c);
        }
    }

    public void h(FrameCallback frameCallback) {
        if (f32463d) {
            c(frameCallback.b());
        } else {
            this.f32465a.removeCallbacks(frameCallback.c());
        }
    }

    private ChoreographerCompat() {
        if (f32463d) {
            this.f32466b = d();
        } else {
            this.f32465a = new Handler(Looper.getMainLooper());
        }
    }

    @TargetApi(16)
    private Choreographer d() {
        return Choreographer.getInstance();
    }
}
