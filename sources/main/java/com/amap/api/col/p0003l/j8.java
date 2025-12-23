package com.amap.api.col.p0003l;

import android.os.SystemClock;
import com.amap.api.col.p0003l.i8;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class j8 {

    /* renamed from: g, reason: collision with root package name */
    private static volatile j8 f6635g;

    /* renamed from: h, reason: collision with root package name */
    private static Object f6636h = new Object();

    /* renamed from: c, reason: collision with root package name */
    private long f6639c;

    /* renamed from: d, reason: collision with root package name */
    private k9 f6640d;

    /* renamed from: f, reason: collision with root package name */
    private k9 f6642f = new k9();

    /* renamed from: a, reason: collision with root package name */
    private i8 f6637a = new i8();

    /* renamed from: b, reason: collision with root package name */
    private k8 f6638b = new k8();

    /* renamed from: e, reason: collision with root package name */
    private f8 f6641e = new f8();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public k9 f6643a;

        /* renamed from: b, reason: collision with root package name */
        public List<l9> f6644b;

        /* renamed from: c, reason: collision with root package name */
        public long f6645c;

        /* renamed from: d, reason: collision with root package name */
        public long f6646d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f6647e;

        /* renamed from: f, reason: collision with root package name */
        public long f6648f;

        /* renamed from: g, reason: collision with root package name */
        public byte f6649g;

        /* renamed from: h, reason: collision with root package name */
        public String f6650h;

        /* renamed from: i, reason: collision with root package name */
        public List<ko> f6651i;

        /* renamed from: j, reason: collision with root package name */
        public boolean f6652j;
    }

    public static j8 a() {
        if (f6635g == null) {
            synchronized (f6636h) {
                try {
                    if (f6635g == null) {
                        f6635g = new j8();
                    }
                } finally {
                }
            }
        }
        return f6635g;
    }

    public final l8 b(a aVar) {
        l8 l8Var = null;
        if (aVar == null) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        k9 k9Var = this.f6640d;
        if (k9Var != null && aVar.f6643a.a(k9Var) < 10.0d) {
            return null;
        }
        i8.a a6 = this.f6637a.a(aVar.f6643a, aVar.f6652j, aVar.f6649g, aVar.f6650h, aVar.f6651i);
        List<l9> a7 = this.f6638b.a(aVar.f6643a, aVar.f6644b, aVar.f6647e, aVar.f6646d, currentTimeMillis);
        if (a6 != null || a7 != null) {
            h9.a(this.f6642f, aVar.f6643a, aVar.f6648f, currentTimeMillis);
            l8Var = new l8(0, this.f6641e.f(this.f6642f, a6, aVar.f6645c, a7));
        }
        this.f6640d = aVar.f6643a;
        this.f6639c = elapsedRealtime;
        return l8Var;
    }

    private j8() {
    }
}
