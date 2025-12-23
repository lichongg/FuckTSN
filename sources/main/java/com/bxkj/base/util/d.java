package com.bxkj.base.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import com.bxkj.base.BaseApp;
import java.util.Random;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class d {

    /* renamed from: w, reason: collision with root package name */
    private static final char[] f16571w = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    /* renamed from: x, reason: collision with root package name */
    private static d f16572x;

    /* renamed from: a, reason: collision with root package name */
    private final int f16573a = 4;

    /* renamed from: b, reason: collision with root package name */
    private final int f16574b;

    /* renamed from: c, reason: collision with root package name */
    private final int f16575c;

    /* renamed from: d, reason: collision with root package name */
    private final int f16576d;

    /* renamed from: e, reason: collision with root package name */
    private final int f16577e;

    /* renamed from: f, reason: collision with root package name */
    private final int f16578f;

    /* renamed from: g, reason: collision with root package name */
    private final int f16579g;

    /* renamed from: h, reason: collision with root package name */
    private final int f16580h;

    /* renamed from: i, reason: collision with root package name */
    private final int f16581i;

    /* renamed from: j, reason: collision with root package name */
    private int f16582j;

    /* renamed from: k, reason: collision with root package name */
    private int f16583k;

    /* renamed from: l, reason: collision with root package name */
    private int f16584l;

    /* renamed from: m, reason: collision with root package name */
    private int f16585m;

    /* renamed from: n, reason: collision with root package name */
    private int f16586n;

    /* renamed from: o, reason: collision with root package name */
    private int f16587o;

    /* renamed from: p, reason: collision with root package name */
    private int f16588p;

    /* renamed from: q, reason: collision with root package name */
    private int f16589q;

    /* renamed from: r, reason: collision with root package name */
    private int f16590r;

    /* renamed from: s, reason: collision with root package name */
    private String f16591s;

    /* renamed from: t, reason: collision with root package name */
    private int f16592t;

    /* renamed from: u, reason: collision with root package name */
    private int f16593u;

    /* renamed from: v, reason: collision with root package name */
    private Random f16594v;

    private int f() {
        return g(1);
    }

    public Bitmap a() {
        this.f16592t = 0;
        Bitmap createBitmap = Bitmap.createBitmap(this.f16582j, this.f16583k, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        this.f16591s = b();
        canvas.drawColor(-1);
        Paint paint = new Paint();
        paint.setTextSize(this.f16590r);
        for (int i6 = 0; i6 < this.f16591s.length(); i6++) {
            i(paint);
            h();
            canvas.drawText(this.f16591s.charAt(i6) + "", this.f16592t, this.f16593u, paint);
        }
        for (int i7 = 0; i7 < this.f16589q; i7++) {
            c(canvas, paint);
        }
        canvas.save();
        canvas.restore();
        return createBitmap;
    }

    private String b() {
        StringBuilder sb = new StringBuilder();
        for (int i6 = 0; i6 < this.f16588p; i6++) {
            char[] cArr = f16571w;
            sb.append(cArr[this.f16594v.nextInt(cArr.length)]);
        }
        return sb.toString();
    }

    public static d e() {
        if (f16572x == null) {
            f16572x = new d();
        }
        return f16572x;
    }

    private int g(int i6) {
        return Color.rgb(this.f16594v.nextInt(256) / i6, this.f16594v.nextInt(256) / i6, this.f16594v.nextInt(256) / i6);
    }

    private void h() {
        this.f16592t += this.f16584l + this.f16594v.nextInt(this.f16585m);
        this.f16593u = this.f16586n + this.f16594v.nextInt(this.f16587o);
    }

    public String d() {
        return this.f16591s;
    }

    public d() {
        int j6 = j(BaseApp.c(), 25.0f);
        this.f16574b = j6;
        this.f16575c = 10;
        int a6 = cn.bluemobi.dylan.base.utils.u.a(10.0f, BaseApp.c());
        this.f16576d = a6;
        int a7 = cn.bluemobi.dylan.base.utils.u.a(15.0f, BaseApp.c());
        this.f16577e = a7;
        int a8 = cn.bluemobi.dylan.base.utils.u.a(15.0f, BaseApp.c());
        this.f16578f = a8;
        int a9 = cn.bluemobi.dylan.base.utils.u.a(20.0f, BaseApp.c());
        this.f16579g = a9;
        int a10 = cn.bluemobi.dylan.base.utils.u.a(100.0f, BaseApp.c());
        this.f16580h = a10;
        int a11 = cn.bluemobi.dylan.base.utils.u.a(40.0f, BaseApp.c());
        this.f16581i = a11;
        this.f16582j = a10;
        this.f16583k = a11;
        this.f16584l = a6;
        this.f16585m = a7;
        this.f16586n = a8;
        this.f16587o = a9;
        this.f16588p = 4;
        this.f16589q = 10;
        this.f16590r = j6;
        this.f16594v = new Random();
    }

    private void c(Canvas canvas, Paint paint) {
        int f6 = f();
        int nextInt = this.f16594v.nextInt(this.f16582j);
        int nextInt2 = this.f16594v.nextInt(this.f16583k);
        int nextInt3 = this.f16594v.nextInt(this.f16582j);
        int nextInt4 = this.f16594v.nextInt(this.f16583k);
        paint.setStrokeWidth(cn.bluemobi.dylan.base.utils.u.a(1.0f, BaseApp.c()));
        paint.setColor(f6);
        canvas.drawLine(nextInt, nextInt2, nextInt3, nextInt4, paint);
    }

    private void i(Paint paint) {
        paint.setColor(f());
        paint.setFakeBoldText(this.f16594v.nextBoolean());
        float nextInt = this.f16594v.nextInt(11) / 10;
        if (!this.f16594v.nextBoolean()) {
            nextInt = -nextInt;
        }
        paint.setTextSkewX(nextInt);
    }

    public int j(Context context, float f6) {
        return (int) ((f6 * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }
}
