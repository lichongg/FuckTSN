package com.acse.ottn;

import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class m0 {

    /* renamed from: a, reason: collision with root package name */
    public static m0 f4774a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class a extends CountDownTimer {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f4775a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(long j6, long j7, d dVar) {
            super(j6, j7);
            this.f4775a = dVar;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            this.f4775a.a();
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j6) {
            this.f4775a.a(j6);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class b extends TimerTask {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int[] f4777a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f4778b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f4779c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ d f4780d;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f4780d.a();
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.acse.ottn.m0$b$b, reason: collision with other inner class name */
        public class RunnableC0081b implements Runnable {
            public RunnableC0081b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f4780d.a(r0.f4779c - r0.f4777a[0]);
            }
        }

        public b(int[] iArr, int i6, int i7, d dVar) {
            this.f4777a = iArr;
            this.f4778b = i6;
            this.f4779c = i7;
            this.f4780d = dVar;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (k0.f4672h) {
                cancel();
            } else {
                k0.f4672h = false;
            }
            int[] iArr = this.f4777a;
            int i6 = iArr[0] + this.f4778b;
            iArr[0] = i6;
            if (i6 < this.f4779c) {
                new Handler(Looper.getMainLooper()).postDelayed(new RunnableC0081b(), 0L);
            } else {
                cancel();
                new Handler(Looper.getMainLooper()).postDelayed(new a(), 0L);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class c extends TimerTask {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int[] f4784a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f4785b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f4786c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ d f4787d;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.f4787d.a();
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.f4787d.a(r0.f4786c - r0.f4784a[0]);
            }
        }

        public c(int[] iArr, int i6, int i7, d dVar) {
            this.f4784a = iArr;
            this.f4785b = i6;
            this.f4786c = i7;
            this.f4787d = dVar;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            int[] iArr = this.f4784a;
            int i6 = iArr[0] + this.f4785b;
            iArr[0] = i6;
            if (i6 < this.f4786c) {
                new Handler(Looper.getMainLooper()).postDelayed(new b(), 0L);
            } else {
                cancel();
                new Handler(Looper.getMainLooper()).postDelayed(new a(), 0L);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface d {
        void a();

        void a(long j6);
    }

    public static m0 a() {
        if (f4774a == null) {
            synchronized (m0.class) {
                try {
                    if (f4774a == null) {
                        f4774a = new m0();
                    }
                } finally {
                }
            }
        }
        return f4774a;
    }

    public TimerTask b(int i6, int i7, d dVar) {
        k0.f4672h = false;
        b bVar = new b(new int[]{0}, i7, i6, dVar);
        new Timer().scheduleAtFixedRate(bVar, 0L, i7);
        return bVar;
    }

    public Timer c(int i6, int i7, d dVar) {
        c cVar = new c(new int[]{0}, i7, i6, dVar);
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(cVar, 0L, i7);
        return timer;
    }

    public CountDownTimer a(int i6, int i7, d dVar) {
        return new a(i6, i7, dVar);
    }
}
