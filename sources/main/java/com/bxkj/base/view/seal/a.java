package com.bxkj.base.view.seal;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import androidx.core.internal.view.SupportMenu;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private int f17228a;

    /* renamed from: c, reason: collision with root package name */
    private String f17230c;

    /* renamed from: d, reason: collision with root package name */
    private Canvas f17231d;

    /* renamed from: f, reason: collision with root package name */
    private Bitmap f17233f;

    /* renamed from: g, reason: collision with root package name */
    private int f17234g;

    /* renamed from: h, reason: collision with root package name */
    private int f17235h;

    /* renamed from: b, reason: collision with root package name */
    float f17229b = 50.0f;

    /* renamed from: i, reason: collision with root package name */
    private int f17236i = Color.parseColor("#99FF0000");

    /* renamed from: e, reason: collision with root package name */
    private Paint f17232e = new Paint();

    private void a() {
        float f6 = (float) ((this.f17235h / 2) * 1.1d);
        int i6 = this.f17234g;
        float radians = (float) Math.toRadians(72.0d);
        float radians2 = (float) Math.toRadians(36.0d);
        float f7 = i6;
        float f8 = i6 - f6;
        double d6 = i6;
        double d7 = f6;
        double d8 = radians;
        float sin = (float) (d6 - (Math.sin(d8) * d7));
        double d9 = i6;
        float cos = (float) (d9 - (Math.cos(d8) * d7));
        float sin2 = (float) ((Math.sin(d8) * d7) + d6);
        float cos2 = (float) (d9 - (Math.cos(d8) * d7));
        double d10 = radians2;
        float sin3 = (float) (d6 - (Math.sin(d10) * d7));
        float cos3 = (float) ((Math.cos(d10) * d7) + d9);
        float sin4 = (float) (d6 + (Math.sin(d10) * d7));
        float cos4 = (float) (d9 + (d7 * Math.cos(d10)));
        Path path = new Path();
        path.moveTo(f7, f8);
        path.lineTo(sin4, cos4);
        path.lineTo(sin, cos);
        path.lineTo(sin2, cos2);
        path.lineTo(sin3, cos3);
        path.close();
        Paint paint = new Paint();
        paint.setColor(this.f17236i);
        this.f17231d.drawPath(path, paint);
    }

    private void b() {
        Paint paint = new Paint();
        paint.setColor(SupportMenu.CATEGORY_MASK);
        paint.setTypeface(Typeface.DEFAULT_BOLD);
        paint.setTextSize((this.f17235h / 5) + 5);
        paint.setTextAlign(Paint.Align.CENTER);
        int i6 = this.f17235h;
        RectF rectF = new RectF(0.0f, 0.0f, i6 * 2, i6 * 2);
        float length = (((this.f17229b * this.f17230c.length()) / 4.0f) + 90.0f) - (this.f17229b / 8.0f);
        for (int i7 = 0; i7 < this.f17230c.length(); i7++) {
            Path path = new Path();
            float f6 = this.f17229b;
            path.addArc(rectF, -(length - ((i7 * f6) / 2.0f)), f6);
            Canvas canvas = this.f17231d;
            String valueOf = String.valueOf(this.f17230c.charAt(i7));
            int i8 = this.f17235h;
            canvas.drawTextOnPath(valueOf, path, -(i8 / 3), i8 / 3, paint);
        }
    }

    private void d() {
        int width = this.f17231d.getWidth() / 2;
        this.f17234g = width;
        this.f17235h = width - (this.f17228a / 2);
        this.f17232e.setColor(this.f17236i);
        this.f17232e.setStyle(Paint.Style.STROKE);
        this.f17232e.setStrokeWidth(this.f17228a);
        this.f17232e.setAntiAlias(true);
        Canvas canvas = this.f17231d;
        int i6 = this.f17234g;
        canvas.drawCircle(i6, i6, this.f17235h, this.f17232e);
    }

    public int e() {
        return this.f17228a;
    }

    public a(int i6, String str, Bitmap bitmap) {
        this.f17228a = 10;
        this.f17228a = i6;
        this.f17230c = str;
        this.f17233f = bitmap;
        this.f17231d = new Canvas(bitmap);
    }

    private void f() {
        d();
        a();
        b();
    }

    public Bitmap c() {
        f();
        return this.f17233f;
    }
}
