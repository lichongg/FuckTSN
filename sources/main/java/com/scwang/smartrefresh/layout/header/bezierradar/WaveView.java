package com.scwang.smartrefresh.layout.header.bezierradar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.ColorInt;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class WaveView extends View {

    /* renamed from: a, reason: collision with root package name */
    private int f37413a;

    /* renamed from: b, reason: collision with root package name */
    private int f37414b;

    /* renamed from: c, reason: collision with root package name */
    private Path f37415c;

    /* renamed from: d, reason: collision with root package name */
    private Paint f37416d;

    /* renamed from: e, reason: collision with root package name */
    private int f37417e;

    public WaveView(Context context) {
        this(context, null, 0);
    }

    public WaveView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a() {
        this.f37415c = new Path();
        Paint paint = new Paint();
        this.f37416d = paint;
        paint.setColor(-14736346);
        this.f37416d.setAntiAlias(true);
    }

    public int getHeadHeight() {
        return this.f37414b;
    }

    public int getWaveHeight() {
        return this.f37413a;
    }

    public void setHeadHeight(int i6) {
        this.f37414b = i6;
    }

    public void setWaveColor(@ColorInt int i6) {
        this.f37416d.setColor(i6);
    }

    public void setWaveHeight(int i6) {
        this.f37413a = i6;
    }

    public void setWaveOffsetX(int i6) {
        this.f37417e = i6;
    }

    public WaveView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f37417e = -1;
        a();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        this.f37415c.reset();
        this.f37415c.lineTo(0.0f, this.f37414b);
        Path path = this.f37415c;
        int i6 = this.f37417e;
        if (i6 < 0) {
            i6 = width / 2;
        }
        float f6 = i6;
        float f7 = width;
        path.quadTo(f6, this.f37413a + r4, f7, this.f37414b);
        this.f37415c.lineTo(f7, 0.0f);
        canvas.drawPath(this.f37415c, this.f37416d);
    }

    @Override // android.view.View
    protected void onMeasure(int i6, int i7) {
        setMeasuredDimension(View.resolveSize(getSuggestedMinimumWidth(), i6), View.resolveSize(getSuggestedMinimumHeight(), i7));
    }
}
