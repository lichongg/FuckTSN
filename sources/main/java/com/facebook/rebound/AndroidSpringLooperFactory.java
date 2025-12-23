package com.facebook.rebound;

import android.annotation.TargetApi;
import android.os.Handler;
import android.os.SystemClock;
import android.view.Choreographer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
abstract class AndroidSpringLooperFactory {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @TargetApi(16)
    private static class ChoreographerAndroidSpringLooper extends SpringLooper {

        /* renamed from: b, reason: collision with root package name */
        private final Choreographer f32428b;

        /* renamed from: c, reason: collision with root package name */
        private final Choreographer.FrameCallback f32429c = new Choreographer.FrameCallback() { // from class: com.facebook.rebound.AndroidSpringLooperFactory.ChoreographerAndroidSpringLooper.1
            @Override // android.view.Choreographer.FrameCallback
            public void doFrame(long j6) {
                if (!ChoreographerAndroidSpringLooper.this.f32430d || ChoreographerAndroidSpringLooper.this.f32507a == null) {
                    return;
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                ChoreographerAndroidSpringLooper.this.f32507a.i(uptimeMillis - r0.f32431e);
                ChoreographerAndroidSpringLooper.this.f32431e = uptimeMillis;
                ChoreographerAndroidSpringLooper.this.f32428b.postFrameCallback(ChoreographerAndroidSpringLooper.this.f32429c);
            }
        };

        /* renamed from: d, reason: collision with root package name */
        private boolean f32430d;

        /* renamed from: e, reason: collision with root package name */
        private long f32431e;

        @Override // com.facebook.rebound.SpringLooper
        public void c() {
            this.f32430d = false;
            this.f32428b.removeFrameCallback(this.f32429c);
        }

        public static ChoreographerAndroidSpringLooper i() {
            return new ChoreographerAndroidSpringLooper(Choreographer.getInstance());
        }

        @Override // com.facebook.rebound.SpringLooper
        public void b() {
            if (this.f32430d) {
                return;
            }
            this.f32430d = true;
            this.f32431e = SystemClock.uptimeMillis();
            this.f32428b.removeFrameCallback(this.f32429c);
            this.f32428b.postFrameCallback(this.f32429c);
        }

        public ChoreographerAndroidSpringLooper(Choreographer choreographer) {
            this.f32428b = choreographer;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class LegacyAndroidSpringLooper extends SpringLooper {

        /* renamed from: b, reason: collision with root package name */
        private final Handler f32433b;

        /* renamed from: c, reason: collision with root package name */
        private final Runnable f32434c = new Runnable() { // from class: com.facebook.rebound.AndroidSpringLooperFactory.LegacyAndroidSpringLooper.1
            @Override // java.lang.Runnable
            public void run() {
                if (!LegacyAndroidSpringLooper.this.f32435d || LegacyAndroidSpringLooper.this.f32507a == null) {
                    return;
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                LegacyAndroidSpringLooper.this.f32507a.i(uptimeMillis - r2.f32436e);
                LegacyAndroidSpringLooper.this.f32436e = uptimeMillis;
                LegacyAndroidSpringLooper.this.f32433b.post(LegacyAndroidSpringLooper.this.f32434c);
            }
        };

        /* renamed from: d, reason: collision with root package name */
        private boolean f32435d;

        /* renamed from: e, reason: collision with root package name */
        private long f32436e;

        @Override // com.facebook.rebound.SpringLooper
        public void c() {
            this.f32435d = false;
            this.f32433b.removeCallbacks(this.f32434c);
        }

        public static SpringLooper i() {
            return new LegacyAndroidSpringLooper(new Handler());
        }

        @Override // com.facebook.rebound.SpringLooper
        public void b() {
            if (this.f32435d) {
                return;
            }
            this.f32435d = true;
            this.f32436e = SystemClock.uptimeMillis();
            this.f32433b.removeCallbacks(this.f32434c);
            this.f32433b.post(this.f32434c);
        }

        public LegacyAndroidSpringLooper(Handler handler) {
            this.f32433b = handler;
        }
    }

    AndroidSpringLooperFactory() {
    }

    public static SpringLooper a() {
        return ChoreographerAndroidSpringLooper.i();
    }
}
