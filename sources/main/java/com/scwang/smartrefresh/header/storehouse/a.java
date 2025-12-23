package com.scwang.smartrefresh.header.storehouse;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import java.util.Random;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class a extends Animation {

    /* renamed from: a, reason: collision with root package name */
    public PointF f37191a;

    /* renamed from: b, reason: collision with root package name */
    public float f37192b;

    /* renamed from: c, reason: collision with root package name */
    public int f37193c;

    /* renamed from: d, reason: collision with root package name */
    private final Paint f37194d;

    /* renamed from: e, reason: collision with root package name */
    private float f37195e;

    /* renamed from: f, reason: collision with root package name */
    private float f37196f;

    /* renamed from: g, reason: collision with root package name */
    private PointF f37197g;

    /* renamed from: h, reason: collision with root package name */
    private PointF f37198h;

    public void a(Canvas canvas) {
        PointF pointF = this.f37197g;
        float f6 = pointF.x;
        float f7 = pointF.y;
        PointF pointF2 = this.f37198h;
        canvas.drawLine(f6, f7, pointF2.x, pointF2.y, this.f37194d);
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f6, Transformation transformation) {
        float f7 = this.f37195e;
        c(f7 + ((this.f37196f - f7) * f6));
    }

    public void b(int i6) {
        this.f37192b = (-new Random().nextInt(i6)) + i6;
    }

    public void c(float f6) {
        this.f37194d.setAlpha((int) (f6 * 255.0f));
    }

    public void e(int i6) {
        this.f37194d.setColor(i6);
    }

    public void f(int i6) {
        this.f37194d.setStrokeWidth(i6);
    }

    public void g(float f6, float f7) {
        this.f37195e = f6;
        this.f37196f = f7;
        super.start();
    }

    public a(int i6, PointF pointF, PointF pointF2, int i7, int i8) {
        Paint paint = new Paint();
        this.f37194d = paint;
        this.f37195e = 1.0f;
        this.f37196f = 0.4f;
        this.f37193c = i6;
        this.f37191a = new PointF((pointF.x + pointF2.x) / 2.0f, (pointF.y + pointF2.y) / 2.0f);
        float f6 = pointF.x;
        PointF pointF3 = this.f37191a;
        this.f37197g = new PointF(f6 - pointF3.x, pointF.y - pointF3.y);
        float f7 = pointF2.x;
        PointF pointF4 = this.f37191a;
        this.f37198h = new PointF(f7 - pointF4.x, pointF2.y - pointF4.y);
        e(i7);
        f(i8);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
    }
}
