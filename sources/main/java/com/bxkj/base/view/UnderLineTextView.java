package com.bxkj.base.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.internal.view.SupportMenu;
import cn.bluemobi.dylan.base.utils.u;
import com.bxkj.base.R;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class UnderLineTextView extends AppCompatTextView {

    /* renamed from: c, reason: collision with root package name */
    private Rect f17195c;

    /* renamed from: d, reason: collision with root package name */
    private Paint f17196d;

    /* renamed from: e, reason: collision with root package name */
    private int f17197e;

    /* renamed from: f, reason: collision with root package name */
    private float f17198f;

    /* renamed from: g, reason: collision with root package name */
    private float f17199g;

    /* renamed from: h, reason: collision with root package name */
    private float f17200h;

    public UnderLineTextView(Context context) {
        this(context, null, 0);
    }

    public UnderLineTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void init(Context context, AttributeSet attributeSet, int i6) {
        this.f17200h = u.a(1.0f, context);
        this.f17198f = context.getResources().getDisplayMetrics().density;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.UnderlinedTextView, i6, 0);
        this.f17197e = obtainStyledAttributes.getColor(R.styleable.UnderlinedTextView_underlineColor, SupportMenu.CATEGORY_MASK);
        this.f17199g = obtainStyledAttributes.getDimension(R.styleable.UnderlinedTextView_underlineWidth, this.f17198f * 2.0f);
        obtainStyledAttributes.recycle();
        this.f17195c = new Rect();
        Paint paint = new Paint();
        this.f17196d = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.f17196d.setColor(this.f17197e);
        this.f17196d.setStrokeWidth(this.f17199g);
    }

    public int getUnderLineColor() {
        return this.f17197e;
    }

    public float getUnderlineWidth() {
        return this.f17199g;
    }

    public void setUnderLineColor(int i6) {
        this.f17197e = i6;
        invalidate();
    }

    public void setUnderlineWidth(float f6) {
        this.f17199g = f6;
        invalidate();
    }

    public UnderLineTextView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        init(context, attributeSet, i6);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        int lineCount = getLineCount();
        Layout layout = getLayout();
        for (int i6 = 0; i6 < lineCount; i6++) {
            int lineBounds = getLineBounds(i6, this.f17195c);
            int lineStart = layout.getLineStart(i6);
            int lineEnd = layout.getLineEnd(i6);
            float primaryHorizontal = layout.getPrimaryHorizontal(lineStart);
            float primaryHorizontal2 = layout.getPrimaryHorizontal(lineEnd - 1) + (layout.getPrimaryHorizontal(lineStart + 1) - primaryHorizontal);
            float f6 = lineBounds;
            float f7 = this.f17199g;
            float f8 = this.f17200h;
            canvas.drawLine(primaryHorizontal, f6 + f7 + f8, primaryHorizontal2, f6 + f7 + f8, this.f17196d);
        }
        super.onDraw(canvas);
    }
}
