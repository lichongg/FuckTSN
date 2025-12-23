package com.amap.api.col.p0003l;

import android.os.SystemClock;
import android.util.LongSparseArray;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class e9 {

    /* renamed from: g, reason: collision with root package name */
    private static volatile e9 f6008g;

    /* renamed from: h, reason: collision with root package name */
    private static Object f6009h = new Object();

    /* renamed from: e, reason: collision with root package name */
    private Object f6014e = new Object();

    /* renamed from: f, reason: collision with root package name */
    private Object f6015f = new Object();

    /* renamed from: a, reason: collision with root package name */
    private LongSparseArray<a> f6010a = new LongSparseArray<>();

    /* renamed from: b, reason: collision with root package name */
    private LongSparseArray<a> f6011b = new LongSparseArray<>();

    /* renamed from: c, reason: collision with root package name */
    private LongSparseArray<a> f6012c = new LongSparseArray<>();

    /* renamed from: d, reason: collision with root package name */
    private LongSparseArray<a> f6013d = new LongSparseArray<>();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        int f6016a;

        /* renamed from: b, reason: collision with root package name */
        long f6017b;

        /* renamed from: c, reason: collision with root package name */
        boolean f6018c;

        private a() {
        }

        /* synthetic */ a(byte b6) {
            this();
        }
    }

    private static short c(LongSparseArray<a> longSparseArray, long j6) {
        synchronized (longSparseArray) {
            try {
                a aVar = longSparseArray.get(j6);
                if (aVar == null) {
                    return (short) 0;
                }
                short max = (short) Math.max(1L, Math.min(32767L, (f() - aVar.f6017b) / 1000));
                if (!aVar.f6018c) {
                    max = (short) (-max);
                }
                return max;
            } finally {
            }
        }
    }

    public static e9 a() {
        if (f6008g == null) {
            synchronized (f6009h) {
                try {
                    if (f6008g == null) {
                        f6008g = new e9();
                    }
                } finally {
                }
            }
        }
        return f6008g;
    }

    final short b(long j6) {
        return c(this.f6010a, j6);
    }

    final short g(long j6) {
        return c(this.f6012c, j6);
    }

    private e9() {
    }

    private static void e(List<d9> list, LongSparseArray<a> longSparseArray, LongSparseArray<a> longSparseArray2) {
        long f6 = f();
        byte b6 = 0;
        if (longSparseArray.size() == 0) {
            for (d9 d9Var : list) {
                a aVar = new a(b6);
                aVar.f6016a = d9Var.b();
                aVar.f6017b = f6;
                aVar.f6018c = false;
                longSparseArray2.put(d9Var.a(), aVar);
            }
            return;
        }
        for (d9 d9Var2 : list) {
            long a6 = d9Var2.a();
            a aVar2 = longSparseArray.get(a6);
            if (aVar2 == null) {
                aVar2 = new a(b6);
                aVar2.f6016a = d9Var2.b();
                aVar2.f6017b = f6;
                aVar2.f6018c = true;
            } else if (aVar2.f6016a != d9Var2.b()) {
                aVar2.f6016a = d9Var2.b();
                aVar2.f6017b = f6;
                aVar2.f6018c = true;
            }
            longSparseArray2.put(a6, aVar2);
        }
    }

    private static long f() {
        return SystemClock.elapsedRealtime();
    }

    final void d(List<d9> list) {
        if (list.isEmpty()) {
            return;
        }
        synchronized (this.f6014e) {
            e(list, this.f6010a, this.f6011b);
            LongSparseArray<a> longSparseArray = this.f6010a;
            this.f6010a = this.f6011b;
            this.f6011b = longSparseArray;
            longSparseArray.clear();
        }
    }

    final void h(List<d9> list) {
        if (list.isEmpty()) {
            return;
        }
        synchronized (this.f6015f) {
            e(list, this.f6012c, this.f6013d);
            LongSparseArray<a> longSparseArray = this.f6012c;
            this.f6012c = this.f6013d;
            this.f6013d = longSparseArray;
            longSparseArray.clear();
        }
    }
}
