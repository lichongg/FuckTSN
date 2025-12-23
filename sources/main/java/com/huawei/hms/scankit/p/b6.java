package com.huawei.hms.scankit.p;

import android.graphics.Bitmap;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.Rect;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class b6 {

    /* renamed from: r, reason: collision with root package name */
    private static final Object f34024r = new Object();

    /* renamed from: c, reason: collision with root package name */
    private int f34027c;

    /* renamed from: d, reason: collision with root package name */
    private long f34028d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f34029e;

    /* renamed from: f, reason: collision with root package name */
    private float f34030f;

    /* renamed from: g, reason: collision with root package name */
    private int[] f34031g;

    /* renamed from: h, reason: collision with root package name */
    private int f34032h;

    /* renamed from: i, reason: collision with root package name */
    private int f34033i;

    /* renamed from: j, reason: collision with root package name */
    private int f34034j;

    /* renamed from: k, reason: collision with root package name */
    private int f34035k;

    /* renamed from: l, reason: collision with root package name */
    private int f34036l;

    /* renamed from: n, reason: collision with root package name */
    private Path f34038n;

    /* renamed from: o, reason: collision with root package name */
    private PathMeasure f34039o;

    /* renamed from: a, reason: collision with root package name */
    private final ArrayList<w5> f34025a = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    private final ArrayList<w5> f34026b = new ArrayList<>();

    /* renamed from: m, reason: collision with root package name */
    private boolean f34037m = false;

    /* renamed from: p, reason: collision with root package name */
    private x5 f34040p = new x5();

    /* renamed from: q, reason: collision with root package name */
    private z5 f34041q = new z5();

    private void a(@NonNull g4 g4Var) {
        if (this.f34041q == null) {
            this.f34041q = new z5();
        }
        this.f34041q.a(g4Var);
    }

    public b6 b(float f6, float f7) {
        a(new a6(f6, f7));
        return this;
    }

    public void b(long j6) {
        boolean z5 = this.f34029e;
        float f6 = this.f34030f * j6;
        ArrayList arrayList = new ArrayList();
        synchronized (f34024r) {
            while (z5) {
                try {
                    if (this.f34025a.isEmpty() || this.f34032h >= f6) {
                        break;
                    } else {
                        a(j6);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            Iterator<w5> it = this.f34026b.iterator();
            while (it.hasNext()) {
                w5 next = it.next();
                if (!next.a(j6)) {
                    it.remove();
                    arrayList.add(next);
                }
            }
        }
        this.f34025a.addAll(arrayList);
    }

    public List<w5> c() {
        List<w5> unmodifiableList;
        synchronized (f34024r) {
            unmodifiableList = Collections.unmodifiableList(this.f34026b);
        }
        return unmodifiableList;
    }

    public b6(int i6, long j6) {
        a(i6, j6);
        a((Bitmap) null);
    }

    public b6 a(int i6, int i7, long j6, long j7, @NonNull Interpolator interpolator) {
        a(new j5(i6, i7, j6, j7, interpolator));
        return this;
    }

    private void a(@NonNull f4 f4Var) {
        if (this.f34040p == null) {
            this.f34040p = new x5();
        }
        this.f34040p.a(f4Var);
    }

    private void a(int i6, long j6) {
        this.f34031g = new int[2];
        this.f34027c = i6;
        this.f34028d = j6;
    }

    private void a(Bitmap bitmap) {
        for (int i6 = 0; i6 < this.f34027c; i6++) {
            this.f34025a.add(new w5(bitmap));
        }
    }

    public void a(@NonNull Rect rect, int i6) {
        a(rect);
        a(i6);
    }

    private void a(int i6) {
        synchronized (f34024r) {
            this.f34032h = 0;
        }
        this.f34030f = i6 / 1000.0f;
        this.f34029e = true;
    }

    private void b() {
        ArrayList arrayList;
        synchronized (f34024r) {
            arrayList = new ArrayList(this.f34026b);
        }
        this.f34025a.addAll(arrayList);
    }

    private void a(@NonNull Rect rect) {
        int i6 = rect.left - this.f34031g[0];
        this.f34034j = i6;
        this.f34033i = i6 + rect.width();
        int i7 = rect.top - this.f34031g[1];
        this.f34036l = i7;
        this.f34035k = i7 + rect.height();
    }

    private void a(long j6) {
        PathMeasure pathMeasure;
        w5 remove = this.f34025a.remove(0);
        this.f34041q.a(remove);
        if (this.f34037m && (pathMeasure = this.f34039o) != null) {
            float[] a6 = a(0.0f, pathMeasure.getLength());
            remove.a(this.f34028d, (int) a6[0], (int) a6[1], j6, this.f34040p);
        } else {
            remove.a(this.f34028d, a(this.f34034j, this.f34033i), a(this.f34036l, this.f34035k), j6, this.f34040p);
        }
        synchronized (f34024r) {
            this.f34026b.add(remove);
            this.f34032h++;
        }
    }

    private int a(int i6, int i7) {
        if (i6 == i7) {
            return i6;
        }
        if (i6 < i7) {
            return n6.a(i7 - i6) + i6;
        }
        return n6.a(i6 - i7) + i7;
    }

    private float[] a(float f6, float f7) {
        float a6;
        if (Float.compare(f6, f7) <= 0) {
            a6 = n6.a(f7 - f6) + f6;
        } else {
            a6 = f7 + n6.a(f6 - f7);
        }
        if (this.f34039o == null) {
            this.f34039o = new PathMeasure(this.f34038n, true);
        }
        float[] fArr = new float[2];
        this.f34039o.getPosTan(a6, fArr, null);
        float f8 = fArr[0];
        int[] iArr = this.f34031g;
        fArr[0] = f8 - iArr[0];
        fArr[1] = fArr[1] - iArr[1];
        return fArr;
    }

    public void a() {
        b();
    }
}
