package com.huawei.hms.scankit.p;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class w5 {

    /* renamed from: b, reason: collision with root package name */
    private float f34974b;

    /* renamed from: c, reason: collision with root package name */
    private float f34975c;

    /* renamed from: h, reason: collision with root package name */
    private long f34980h;

    /* renamed from: i, reason: collision with root package name */
    private float f34981i;

    /* renamed from: j, reason: collision with root package name */
    private float f34982j;

    /* renamed from: l, reason: collision with root package name */
    private float f34984l;

    /* renamed from: m, reason: collision with root package name */
    private float f34985m;

    /* renamed from: n, reason: collision with root package name */
    private int f34986n;

    /* renamed from: o, reason: collision with root package name */
    private int f34987o;

    /* renamed from: p, reason: collision with root package name */
    private long f34988p;

    /* renamed from: r, reason: collision with root package name */
    private f4 f34990r;

    /* renamed from: a, reason: collision with root package name */
    private float f34973a = 1.0f;

    /* renamed from: d, reason: collision with root package name */
    private int f34976d = 255;

    /* renamed from: e, reason: collision with root package name */
    private float f34977e = 0.0f;

    /* renamed from: f, reason: collision with root package name */
    private float f34978f = 0.0f;

    /* renamed from: q, reason: collision with root package name */
    private int f34989q = 0;

    /* renamed from: k, reason: collision with root package name */
    private float f34983k = 1.0f;

    /* renamed from: g, reason: collision with root package name */
    private int f34979g = 255;

    public void a(long j6, float f6, float f7, long j7, @NonNull f4 f4Var) {
        float f8 = f6 - this.f34986n;
        this.f34984l = f8;
        float f9 = f7 - this.f34987o;
        this.f34985m = f9;
        this.f34981i = f8;
        this.f34982j = f9;
        this.f34988p = j6;
        this.f34980h = j7;
        this.f34990r = f4Var;
    }

    public void b(float f6) {
        this.f34983k = f6;
    }

    public int b() {
        return this.f34989q;
    }

    public float c() {
        return this.f34981i;
    }

    public float d() {
        return this.f34982j;
    }

    public int e() {
        return this.f34976d;
    }

    public float f() {
        return this.f34983k;
    }

    public w5(Bitmap bitmap) {
        if (bitmap != null) {
            this.f34986n = bitmap.getWidth() / 2;
            this.f34987o = bitmap.getHeight() / 2;
        }
    }

    public void b(int i6) {
        this.f34989q = i6;
    }

    public boolean a(long j6) {
        long j7 = j6 - this.f34980h;
        if (j7 > this.f34988p) {
            return false;
        }
        float f6 = j7;
        float f7 = j7 * j7;
        this.f34981i = this.f34984l + (this.f34977e * f6) + (this.f34974b * f7);
        this.f34982j = this.f34985m + (this.f34978f * f6) + (this.f34975c * f7);
        this.f34990r.a(this, j7);
        return true;
    }

    public int a() {
        return this.f34979g;
    }

    public void a(int i6) {
        this.f34979g = i6;
    }

    public void a(float f6) {
        this.f34973a = f6;
    }
}
