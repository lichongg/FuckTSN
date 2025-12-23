package com.kwad.components.ad.reward.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.kwad.sdk.R;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class JinniuCouponLayout extends LinearLayout {
    private float DA;
    private Rect DB;
    private RectF DC;
    private RectF DD;
    private RectF DE;
    private RectF DF;
    private Path DG;

    @ColorInt
    private int endColor;
    private Paint mPaint;
    private float mRadius;

    @ColorInt
    private int startColor;

    public JinniuCouponLayout(Context context) {
        super(context);
        this.mPaint = new Paint();
        this.DA = 4.0f;
        this.mRadius = 10.0f;
        this.DB = new Rect();
        this.DC = new RectF();
        this.DD = new RectF();
        this.DE = new RectF();
        this.DF = new RectF();
        this.DG = new Path();
        this.startColor = Color.parseColor("#FFFE3666");
        this.endColor = Color.parseColor("#FFFD7200");
        a(context, null, 0);
    }

    private void a(Context context, @Nullable AttributeSet attributeSet, int i6) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_JinniuCouponLayout, i6, 0);
        this.mRadius = obtainStyledAttributes.getDimension(R.styleable.ksad_JinniuCouponLayout_ksad_outerRadius, 4.0f);
        this.DA = obtainStyledAttributes.getDimension(R.styleable.ksad_JinniuCouponLayout_ksad_verticalRadius, 10.0f);
        obtainStyledAttributes.recycle();
        this.mPaint.setAntiAlias(true);
    }

    private void setGradientPaint(RectF rectF) {
        this.mPaint.setShader(new LinearGradient(rectF.left, rectF.top, rectF.right, rectF.bottom, this.startColor, this.endColor, Shader.TileMode.CLAMP));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        this.DB.setEmpty();
        getDrawingRect(this.DB);
        this.DC.set(this.DB);
        if (getChildCount() > 1) {
            View childAt = getChildAt(0);
            RectF rectF = this.DD;
            if (rectF == null) {
                this.DD = new RectF();
            } else {
                rectF.setEmpty();
            }
            RectF rectF2 = this.DE;
            if (rectF2 == null) {
                this.DE = new RectF();
            } else {
                rectF2.setEmpty();
            }
            float measuredWidth = childAt.getMeasuredWidth();
            Rect rect = this.DB;
            float f6 = rect.left + measuredWidth;
            RectF rectF3 = this.DD;
            int i6 = rect.top;
            float f7 = this.DA;
            rectF3.set(f6, i6 - f7, (2.0f * f7) + f6, i6 + f7);
            RectF rectF4 = this.DE;
            RectF rectF5 = this.DD;
            float f8 = rectF5.left;
            int i7 = this.DB.bottom;
            float f9 = this.DA;
            rectF4.set(f8, i7 - f9, rectF5.right, i7 + f9);
            a(this.DG, this.DC, this.DD, this.DE);
            setGradientPaint(this.DC);
            canvas.drawPath(this.DG, this.mPaint);
        }
        super.dispatchDraw(canvas);
    }

    private void a(Path path, RectF rectF, RectF rectF2, RectF rectF3) {
        path.reset();
        RectF rectF4 = this.DC;
        path.moveTo(rectF4.left, rectF4.top + this.mRadius);
        this.DF.set(rectF);
        RectF rectF5 = this.DF;
        float f6 = rectF5.top;
        float f7 = this.mRadius;
        rectF5.bottom = f6 + (f7 * 2.0f);
        rectF5.right = rectF5.left + (f7 * 2.0f);
        path.arcTo(rectF5, 180.0f, 90.0f);
        path.lineTo(rectF2.left, rectF2.top);
        path.arcTo(rectF2, -180.0f, -180.0f);
        path.lineTo(rectF.width() - this.mRadius, rectF.top);
        this.DF.set(rectF);
        RectF rectF6 = this.DF;
        float f8 = rectF6.right;
        float f9 = this.mRadius;
        rectF6.left = f8 - (f9 * 2.0f);
        rectF6.bottom = rectF6.top + (f9 * 2.0f);
        path.arcTo(rectF6, 270.0f, 90.0f);
        this.DF.set(rectF);
        RectF rectF7 = this.DF;
        float f10 = rectF7.right;
        float f11 = this.mRadius;
        rectF7.left = f10 - (f11 * 2.0f);
        rectF7.top = rectF7.bottom - (f11 * 2.0f);
        path.arcTo(rectF7, 0.0f, 90.0f);
        path.lineTo(rectF3.right, rectF3.bottom);
        path.arcTo(rectF3, 0.0f, -180.0f);
        path.lineTo(rectF.left + this.mRadius, rectF.bottom);
        this.DF.set(rectF);
        RectF rectF8 = this.DF;
        float f12 = rectF8.left;
        float f13 = this.mRadius;
        rectF8.right = f12 + (f13 * 2.0f);
        rectF8.top = rectF8.bottom - (f13 * 2.0f);
        path.arcTo(rectF8, 90.0f, 90.0f);
    }

    public JinniuCouponLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPaint = new Paint();
        this.DA = 4.0f;
        this.mRadius = 10.0f;
        this.DB = new Rect();
        this.DC = new RectF();
        this.DD = new RectF();
        this.DE = new RectF();
        this.DF = new RectF();
        this.DG = new Path();
        this.startColor = Color.parseColor("#FFFE3666");
        this.endColor = Color.parseColor("#FFFD7200");
        a(context, attributeSet, 0);
    }

    public JinniuCouponLayout(Context context, @Nullable AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.mPaint = new Paint();
        this.DA = 4.0f;
        this.mRadius = 10.0f;
        this.DB = new Rect();
        this.DC = new RectF();
        this.DD = new RectF();
        this.DE = new RectF();
        this.DF = new RectF();
        this.DG = new Path();
        this.startColor = Color.parseColor("#FFFE3666");
        this.endColor = Color.parseColor("#FFFD7200");
        a(context, attributeSet, i6);
    }

    @RequiresApi(api = 21)
    public JinniuCouponLayout(Context context, AttributeSet attributeSet, int i6, int i7) {
        super(context, attributeSet, i6, i7);
        this.mPaint = new Paint();
        this.DA = 4.0f;
        this.mRadius = 10.0f;
        this.DB = new Rect();
        this.DC = new RectF();
        this.DD = new RectF();
        this.DE = new RectF();
        this.DF = new RectF();
        this.DG = new Path();
        this.startColor = Color.parseColor("#FFFE3666");
        this.endColor = Color.parseColor("#FFFD7200");
        a(context, attributeSet, i6);
    }
}
