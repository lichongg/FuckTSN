package com.beizi.fusion.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class CustomRoundImageView extends AppCompatImageView {

    /* renamed from: a, reason: collision with root package name */
    private final RectF f13855a;

    /* renamed from: b, reason: collision with root package name */
    private float f13856b;

    /* renamed from: c, reason: collision with root package name */
    private String f13857c;

    /* renamed from: d, reason: collision with root package name */
    private int f13858d;

    /* renamed from: e, reason: collision with root package name */
    private final Paint f13859e;

    /* renamed from: f, reason: collision with root package name */
    private final Paint f13860f;

    public CustomRoundImageView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f13855a = new RectF();
        this.f13856b = 0.0f;
        this.f13857c = null;
        this.f13858d = 0;
        this.f13859e = new Paint();
        this.f13860f = new Paint();
        a();
    }

    private void a() {
        this.f13859e.setAntiAlias(true);
        this.f13859e.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        this.f13860f.setAntiAlias(true);
        this.f13860f.setColor(-1);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        canvas.saveLayer(this.f13855a, this.f13860f, 31);
        RectF rectF = this.f13855a;
        float f6 = this.f13856b;
        canvas.drawRoundRect(rectF, f6, f6, this.f13860f);
        canvas.saveLayer(this.f13855a, this.f13859e, 31);
        super.draw(canvas);
        if (this.f13858d > 0 && !TextUtils.isEmpty(this.f13857c) && this.f13857c.startsWith("#")) {
            Paint paint = new Paint();
            paint.setColor(Color.parseColor(this.f13857c));
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(this.f13858d);
            paint.setAntiAlias(true);
            RectF rectF2 = this.f13855a;
            float f7 = this.f13856b;
            canvas.drawRoundRect(rectF2, f7, f7, paint);
        }
        canvas.restore();
    }

    public void setBorderColor(String str) {
        this.f13857c = str;
        invalidate();
    }

    public void setBorderWidth(int i6) {
        this.f13858d = i6;
        invalidate();
    }

    public void setRectRadius(float f6) {
        this.f13856b = f6;
        invalidate();
    }

    @Override // android.view.View
    protected void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        super.onLayout(z5, i6, i7, i8, i9);
        this.f13855a.set(0.0f, 0.0f, getWidth(), getHeight());
    }

    public CustomRoundImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13855a = new RectF();
        this.f13856b = 0.0f;
        this.f13857c = null;
        this.f13858d = 0;
        this.f13859e = new Paint();
        this.f13860f = new Paint();
        a();
    }

    public CustomRoundImageView(Context context) {
        super(context);
        this.f13855a = new RectF();
        this.f13856b = 0.0f;
        this.f13857c = null;
        this.f13858d = 0;
        this.f13859e = new Paint();
        this.f13860f = new Paint();
        a();
    }
}
