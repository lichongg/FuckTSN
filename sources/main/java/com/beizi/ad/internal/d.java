package com.beizi.ad.internal;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import com.beizi.ad.internal.view.BannerAdViewImpl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class d {

    /* renamed from: e, reason: collision with root package name */
    private final com.beizi.ad.internal.a f11715e;

    /* renamed from: f, reason: collision with root package name */
    private m f11716f;

    /* renamed from: a, reason: collision with root package name */
    private int f11711a = -1;

    /* renamed from: c, reason: collision with root package name */
    private long f11713c = -1;

    /* renamed from: d, reason: collision with root package name */
    private long f11714d = -1;

    /* renamed from: g, reason: collision with root package name */
    private b f11717g = b.STOPPED;

    /* renamed from: b, reason: collision with root package name */
    private final a f11712b = new a(this);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    enum b {
        STOPPED,
        SINGLE_REQUEST,
        AUTO_REFRESH
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.beizi.ad.internal.d$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f11718a;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f11719b;

        static {
            int[] iArr = new int[k.values().length];
            f11719b = iArr;
            try {
                iArr[k.BANNER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11719b[k.INTERSTITIAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f11719b[k.SPLASH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f11719b[k.NEW_SPLASH.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f11719b[k.NATIVE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f11719b[k.PREFETCH.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f11719b[k.SPLASHUNIFIED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f11719b[k.REWARDEDVIDEO.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            int[] iArr2 = new int[b.values().length];
            f11718a = iArr2;
            try {
                iArr2[b.STOPPED.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f11718a[b.SINGLE_REQUEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f11718a[b.AUTO_REFRESH.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class a extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private final d f11728a;

        @Override // android.os.Handler
        @SuppressLint({"NewApi"})
        public synchronized void handleMessage(Message message) {
            try {
                d dVar = this.f11728a;
                if (dVar != null && dVar.f11715e.isReadyToStart()) {
                    dVar.f11713c = System.currentTimeMillis();
                    switch (AnonymousClass1.f11719b[dVar.f11715e.getMediaType().ordinal()]) {
                        case 1:
                            dVar.f11716f = new g((BannerAdViewImpl) dVar.f11715e);
                            break;
                        case 2:
                            dVar.f11716f = new com.beizi.ad.internal.c.b((com.beizi.ad.internal.c.a) dVar.f11715e);
                            break;
                        case 3:
                            dVar.f11716f = new g((BannerAdViewImpl) dVar.f11715e);
                            break;
                        case 4:
                            dVar.f11716f = new com.beizi.ad.internal.splash.b((com.beizi.ad.internal.splash.a) dVar.f11715e);
                            break;
                        case 5:
                            dVar.f11716f = new com.beizi.ad.internal.e.d((com.beizi.ad.internal.e.c) dVar.f11715e);
                            break;
                        case 6:
                            dVar.f11716f = new l();
                            break;
                        case 7:
                            dVar.f11716f = new com.beizi.ad.internal.splash.d((com.beizi.ad.internal.splash.c) dVar.f11715e);
                            break;
                        case 8:
                            dVar.f11716f = new com.beizi.ad.internal.g.b((com.beizi.ad.internal.g.a) dVar.f11715e);
                            break;
                    }
                    dVar.f11716f.a();
                }
            } finally {
            }
        }

        a(d dVar) {
            this.f11728a = dVar;
        }
    }

    public void b() {
        a aVar;
        int i6 = AnonymousClass1.f11718a[this.f11717g.ordinal()];
        if (i6 != 1) {
            if (i6 == 2 && (aVar = this.f11712b) != null) {
                aVar.sendEmptyMessage(0);
                return;
            }
            return;
        }
        int i7 = this.f11711a;
        if (i7 <= 0) {
            this.f11717g = b.SINGLE_REQUEST;
            a aVar2 = this.f11712b;
            if (aVar2 != null) {
                aVar2.sendEmptyMessage(0);
                return;
            }
            return;
        }
        long j6 = this.f11714d;
        if (j6 != -1) {
            long j7 = this.f11713c;
            if (j7 != -1) {
                long j8 = i7;
                Math.min(j8, Math.max(0L, j8 - (j6 - j7)));
            }
        }
        this.f11717g = b.AUTO_REFRESH;
    }

    public void c() {
        this.f11713c = -1L;
        this.f11714d = -1L;
    }

    public d(com.beizi.ad.internal.a aVar) {
        this.f11715e = aVar;
    }

    public void a(int i6) {
        boolean z5 = this.f11711a != i6;
        this.f11711a = i6;
        if (!z5 || this.f11717g.equals(b.STOPPED)) {
            return;
        }
        a();
        b();
    }

    public void a() {
        m mVar = this.f11716f;
        if (mVar != null) {
            mVar.e();
            this.f11716f = null;
        }
        this.f11714d = System.currentTimeMillis();
        this.f11717g = b.STOPPED;
    }
}
