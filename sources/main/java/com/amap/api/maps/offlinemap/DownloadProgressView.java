package com.amap.api.maps.offlinemap;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.internal.view.SupportMenu;
import com.amap.api.map3d.R;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class DownloadProgressView extends View {

    /* renamed from: a, reason: collision with root package name */
    private String f9024a;

    /* renamed from: b, reason: collision with root package name */
    private int f9025b;

    /* renamed from: c, reason: collision with root package name */
    private int f9026c;

    /* renamed from: d, reason: collision with root package name */
    private float f9027d;

    /* renamed from: e, reason: collision with root package name */
    private float f9028e;

    /* renamed from: f, reason: collision with root package name */
    private TextPaint f9029f;

    /* renamed from: g, reason: collision with root package name */
    private TextPaint f9030g;

    /* renamed from: h, reason: collision with root package name */
    private float f9031h;

    /* renamed from: i, reason: collision with root package name */
    private float f9032i;

    public DownloadProgressView(Context context) {
        super(context);
        this.f9025b = SupportMenu.CATEGORY_MASK;
        this.f9026c = SupportMenu.CATEGORY_MASK;
        this.f9027d = 0.0f;
        this.f9028e = 0.6f;
        a(null, 0);
    }

    private void a(AttributeSet attributeSet, int i6) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.f8912a, i6, 0);
        this.f9024a = obtainStyledAttributes.getString(0);
        this.f9025b = obtainStyledAttributes.getColor(3, this.f9025b);
        this.f9027d = obtainStyledAttributes.getDimension(1, this.f9027d);
        this.f9026c = obtainStyledAttributes.getColor(2, this.f9026c);
        obtainStyledAttributes.recycle();
        TextPaint textPaint = new TextPaint();
        this.f9029f = textPaint;
        textPaint.setFlags(1);
        this.f9029f.setTextAlign(Paint.Align.RIGHT);
        TextPaint textPaint2 = new TextPaint();
        this.f9030g = textPaint2;
        textPaint2.setStyle(Paint.Style.FILL);
        a();
    }

    public void setProgress(int i6) {
        if (i6 > 100 || i6 < 0) {
            return;
        }
        this.f9028e = i6 / 100.0f;
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int width = (getWidth() - paddingLeft) - paddingRight;
        int height = (getHeight() - paddingTop) - paddingBottom;
        String str = String.valueOf((int) (this.f9028e * 100.0f)) + "%";
        canvas.drawRect(new Rect(0, (int) (height * 0.8f), (int) (width * this.f9028e), height), this.f9030g);
        canvas.drawText(str, (int) (this.f9028e * r3), (int) (r1 - 3.0d), this.f9029f);
    }

    public DownloadProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f9025b = SupportMenu.CATEGORY_MASK;
        this.f9026c = SupportMenu.CATEGORY_MASK;
        this.f9027d = 0.0f;
        this.f9028e = 0.6f;
        a(attributeSet, 0);
    }

    public DownloadProgressView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f9025b = SupportMenu.CATEGORY_MASK;
        this.f9026c = SupportMenu.CATEGORY_MASK;
        this.f9027d = 0.0f;
        this.f9028e = 0.6f;
        a(attributeSet, i6);
    }

    private void a() {
        this.f9029f.setTextSize(this.f9027d);
        this.f9029f.setColor(this.f9025b);
        this.f9030g.setColor(this.f9026c);
        this.f9031h = this.f9029f.measureText(this.f9024a);
        this.f9032i = this.f9029f.getFontMetrics().bottom;
    }
}
