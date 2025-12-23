package com.scwang.smartrefresh.layout.header.bezierradar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import androidx.annotation.ColorInt;
import com.scwang.smartrefresh.layout.util.c;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class RoundDotView extends View {

    /* renamed from: a, reason: collision with root package name */
    private int f37400a;

    /* renamed from: b, reason: collision with root package name */
    private Paint f37401b;

    /* renamed from: c, reason: collision with root package name */
    private float f37402c;

    /* renamed from: d, reason: collision with root package name */
    private float f37403d;

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        int i6 = this.f37400a;
        float f6 = this.f37403d;
        float f7 = ((width / i6) * f6) - (f6 > 1.0f ? ((f6 - 1.0f) * (width / i6)) / f6 : 0.0f);
        float f8 = height;
        float f9 = 2.0f;
        float f10 = f8 - (f6 > 1.0f ? (((f6 - 1.0f) * f8) / 2.0f) / f6 : 0.0f);
        int i7 = 0;
        while (true) {
            int i8 = this.f37400a;
            if (i7 >= i8) {
                return;
            }
            float f11 = (i7 + 1.0f) - ((i8 + 1.0f) / f9);
            float abs = (1.0f - ((Math.abs(f11) / this.f37400a) * f9)) * 255.0f;
            float d6 = c.d(f8);
            double d7 = abs;
            float f12 = f7;
            this.f37401b.setAlpha((int) (d7 * (1.0d - (1.0d / Math.pow((d6 / 800.0d) + 1.0d, 15.0d)))));
            float f13 = this.f37402c * (1.0f - (1.0f / ((d6 / 10.0f) + 1.0f)));
            canvas.drawCircle(((width / 2) - (f13 / 2.0f)) + (f11 * f12), f10 / 2.0f, f13, this.f37401b);
            i7++;
            f7 = f12;
            f9 = 2.0f;
        }
    }

    public void setDotColor(@ColorInt int i6) {
        this.f37401b.setColor(i6);
    }

    public void setFraction(float f6) {
        this.f37403d = f6;
    }

    public RoundDotView(Context context) {
        super(context);
        this.f37400a = 7;
        Paint paint = new Paint();
        this.f37401b = paint;
        paint.setAntiAlias(true);
        this.f37401b.setColor(-1);
        this.f37402c = c.b(7.0f);
    }

    @Override // android.view.View
    protected void onMeasure(int i6, int i7) {
        setMeasuredDimension(View.resolveSize(getSuggestedMinimumWidth(), i6), View.resolveSize(getSuggestedMinimumHeight(), i7));
    }
}
