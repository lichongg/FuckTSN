package com.acse.ottn;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class i0 extends b0 {

    /* renamed from: d, reason: collision with root package name */
    public int f4630d;

    /* renamed from: e, reason: collision with root package name */
    public int f4631e;

    /* renamed from: f, reason: collision with root package name */
    public int f4632f;

    public i0(Context context) {
        this(context, null);
    }

    public i0(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public i0(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f4630d = this.f4237a.h() / 2;
        this.f4631e = this.f4237a.k() / 2;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int g6;
        int h6;
        int i6;
        super.onDraw(canvas);
        int d6 = this.f4237a.d();
        if (d6 > 1) {
            float f6 = 0.0f;
            for (int i7 = 0; i7 < d6; i7++) {
                Paint paint = this.f4238b;
                if (this.f4237a.a() == i7) {
                    g6 = this.f4237a.j();
                } else {
                    g6 = this.f4237a.g();
                }
                paint.setColor(g6);
                if (this.f4237a.a() == i7) {
                    h6 = this.f4237a.k();
                } else {
                    h6 = this.f4237a.h();
                }
                if (this.f4237a.a() == i7) {
                    i6 = this.f4631e;
                } else {
                    i6 = this.f4630d;
                }
                float f7 = i6;
                canvas.drawCircle(f6 + f7, this.f4632f, f7, this.f4238b);
                f6 += h6 + this.f4237a.e();
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i6, int i7) {
        super.onMeasure(i6, i7);
        int d6 = this.f4237a.d();
        if (d6 <= 1) {
            return;
        }
        this.f4630d = this.f4237a.h() / 2;
        int k6 = this.f4237a.k() / 2;
        this.f4631e = k6;
        this.f4632f = Math.max(k6, this.f4630d);
        int i8 = d6 - 1;
        setMeasuredDimension((this.f4237a.e() * i8) + this.f4237a.k() + (this.f4237a.h() * i8), Math.max(this.f4237a.h(), this.f4237a.k()));
    }
}
