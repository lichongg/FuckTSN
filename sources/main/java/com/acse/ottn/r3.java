package com.acse.ottn;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.annotation.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class r3 extends b0 {
    public r3(Context context) {
        this(context, null);
    }

    public r3(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public r3(Context context, @Nullable AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f4238b.setStyle(Paint.Style.FILL);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f4237a.d() <= 1) {
            return;
        }
        this.f4238b.setColor(this.f4237a.g());
        canvas.drawRoundRect(new RectF(0.0f, 0.0f, canvas.getWidth(), this.f4237a.c()), this.f4237a.i(), this.f4237a.i(), this.f4238b);
        this.f4238b.setColor(this.f4237a.j());
        canvas.drawRoundRect(new RectF(this.f4237a.a() * this.f4237a.k(), 0.0f, r0 + this.f4237a.k(), this.f4237a.c()), this.f4237a.i(), this.f4237a.i(), this.f4238b);
    }

    @Override // android.view.View
    public void onMeasure(int i6, int i7) {
        super.onMeasure(i6, i7);
        int d6 = this.f4237a.d();
        if (d6 <= 1) {
            return;
        }
        setMeasuredDimension(this.f4237a.k() * d6, this.f4237a.c());
    }
}
