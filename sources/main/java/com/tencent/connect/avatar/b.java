package com.tencent.connect.avatar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class b extends View {

    /* renamed from: a, reason: collision with root package name */
    private Rect f40336a;

    /* renamed from: b, reason: collision with root package name */
    private Paint f40337b;

    private void b() {
        this.f40337b = new Paint();
    }

    public Rect a() {
        if (this.f40336a == null) {
            this.f40336a = new Rect();
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            int min = Math.min(Math.min(measuredHeight - 140, measuredWidth), 640);
            int i6 = (measuredWidth - min) / 2;
            int i7 = (measuredHeight - min) / 2;
            this.f40336a.set(i6, i7, i6 + min, min + i7);
        }
        return this.f40336a;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Rect a6 = a();
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        this.f40337b.setStyle(Paint.Style.FILL);
        this.f40337b.setColor(Color.argb(100, 0, 0, 0));
        float f6 = measuredWidth;
        canvas.drawRect(0.0f, 0.0f, f6, a6.top, this.f40337b);
        canvas.drawRect(0.0f, a6.bottom, f6, measuredHeight, this.f40337b);
        canvas.drawRect(0.0f, a6.top, a6.left, a6.bottom, this.f40337b);
        canvas.drawRect(a6.right, a6.top, f6, a6.bottom, this.f40337b);
        canvas.drawColor(Color.argb(100, 0, 0, 0));
        this.f40337b.setStyle(Paint.Style.STROKE);
        this.f40337b.setColor(-1);
        canvas.drawRect(a6.left, a6.top, a6.right - 1, a6.bottom, this.f40337b);
    }

    public b(Context context) {
        super(context);
        b();
    }
}
