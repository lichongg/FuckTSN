package com.amap.api.col.p0003l;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class ed extends View {

    /* renamed from: b, reason: collision with root package name */
    public static final int f6033b = Color.argb(255, 235, 235, 235);

    /* renamed from: c, reason: collision with root package name */
    public static final int f6034c = Color.argb(255, 21, 21, 21);

    /* renamed from: a, reason: collision with root package name */
    private Paint f6035a;

    public final void a() {
        setVisibility(8);
    }

    public final void b(int i6) {
        Paint paint = this.f6035a;
        if (paint != null) {
            paint.setColor(i6);
            try {
                postInvalidate();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public ed(Context context) {
        super(context);
        Paint paint = new Paint();
        this.f6035a = paint;
        paint.setAntiAlias(true);
        this.f6035a.setColor(f6033b);
    }

    @Override // android.view.View
    protected final void onDraw(Canvas canvas) {
        canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.f6035a);
    }
}
