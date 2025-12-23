package com.acse.ottn;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class k3 extends b0 {

    /* renamed from: d, reason: collision with root package name */
    public RectF f4709d;

    public k3(Context context) {
        this(context, null);
    }

    public k3(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public k3(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f4709d = new RectF();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int g6;
        int h6;
        super.onDraw(canvas);
        int d6 = this.f4237a.d();
        if (d6 > 1) {
            float f6 = 0.0f;
            for (int i6 = 0; i6 < d6; i6++) {
                Paint paint = this.f4238b;
                if (this.f4237a.a() == i6) {
                    g6 = this.f4237a.j();
                } else {
                    g6 = this.f4237a.g();
                }
                paint.setColor(g6);
                if (this.f4237a.a() == i6) {
                    h6 = this.f4237a.k();
                } else {
                    h6 = this.f4237a.h();
                }
                this.f4709d.set(f6, 0.0f, h6 + f6, this.f4237a.c());
                f6 += h6 + this.f4237a.e();
                canvas.drawRoundRect(this.f4709d, this.f4237a.i(), this.f4237a.i(), this.f4238b);
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
        int i8 = d6 - 1;
        setMeasuredDimension((this.f4237a.e() * i8) + (this.f4237a.h() * i8) + this.f4237a.k(), this.f4237a.c());
    }
}
