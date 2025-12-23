package com.kwad.components.ad.reward.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import com.kwad.components.core.widget.d;
import com.kwad.components.core.widget.e;
import com.kwad.sdk.R;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SuppressLint({"AppCompatCustomView"})
/* loaded from: D:\Downloads\app\classes6.dex */
public class KSCouponLabelTextView extends TextView implements d {
    private final Rect DB;
    private final RectF DC;
    private final RectF DF;
    private float DH;
    private float DI;
    private float DJ;
    private final RectF DK;
    private final RectF DL;
    private final Path DM;
    private Path DN;
    private Path DO;
    private boolean DP;
    private final Paint mPaint;

    @ColorInt
    private int strokeColor;

    public KSCouponLabelTextView(Context context) {
        super(context);
        this.mPaint = new Paint();
        this.DB = new Rect();
        this.DC = new RectF();
        this.DK = new RectF();
        this.DL = new RectF();
        this.DM = new Path();
        this.DF = new RectF();
        this.DP = true;
        a(context, null, 0);
    }

    @SuppressLint({"CustomViewStyleable"})
    private void a(Context context, AttributeSet attributeSet, int i6) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_KSCouponLabelTextView, i6, 0);
        int color = context.getResources().getColor(R.color.ksad_reward_main_color);
        this.DH = obtainStyledAttributes.getDimension(R.styleable.ksad_KSCouponLabelTextView_ksad_labelRadius, 8.0f);
        this.DI = obtainStyledAttributes.getDimension(R.styleable.ksad_KSCouponLabelTextView_ksad_strokeSize, 2.0f);
        this.strokeColor = obtainStyledAttributes.getColor(R.styleable.ksad_KSCouponLabelTextView_ksad_strokeColor, color);
        this.DJ = obtainStyledAttributes.getDimension(R.styleable.ksad_KSCouponLabelTextView_ksad_sideRadius, 16.0f);
        obtainStyledAttributes.recycle();
        lm();
    }

    private void b(Path path, RectF rectF, RectF rectF2, RectF rectF3) {
        path.reset();
        path.moveTo(rectF.left, rectF.top + this.DH);
        this.DF.set(rectF);
        RectF rectF4 = this.DF;
        float f6 = rectF4.top;
        float f7 = this.DH;
        rectF4.bottom = f6 + (f7 * 2.0f);
        rectF4.right = rectF4.left + (f7 * 2.0f);
        path.arcTo(rectF4, 180.0f, 90.0f);
        path.lineTo(rectF.width() - this.DH, rectF.top);
        this.DF.set(rectF);
        RectF rectF5 = this.DF;
        float f8 = rectF5.right;
        float f9 = this.DH;
        rectF5.left = f8 - (f9 * 2.0f);
        rectF5.bottom = rectF5.top + (f9 * 2.0f);
        path.arcTo(rectF5, 270.0f, 90.0f);
        path.lineTo(rectF.right, rectF3.top);
        path.arcTo(rectF3, 270.0f, -180.0f);
        path.lineTo(rectF.right, rectF.bottom - this.DH);
        this.DF.set(rectF);
        RectF rectF6 = this.DF;
        float f10 = rectF6.right;
        float f11 = this.DH;
        rectF6.left = f10 - (f11 * 2.0f);
        rectF6.top = rectF6.bottom - (f11 * 2.0f);
        path.arcTo(rectF6, 0.0f, 90.0f);
        path.lineTo(rectF.left + this.DH, rectF.bottom);
        this.DF.set(rectF);
        RectF rectF7 = this.DF;
        float f12 = rectF7.left;
        float f13 = this.DH;
        rectF7.right = f12 + (f13 * 2.0f);
        rectF7.top = rectF7.bottom - (f13 * 2.0f);
        path.arcTo(rectF7, 90.0f, 90.0f);
        path.lineTo(rectF.left, rectF2.bottom);
        path.arcTo(rectF2, 90.0f, -180.0f);
        path.close();
    }

    private void lm() {
        this.mPaint.setColor(this.strokeColor);
        this.mPaint.setStrokeWidth(this.DI);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setAntiAlias(true);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.DB.setEmpty();
        getDrawingRect(this.DB);
        float f6 = this.DI / 2.0f;
        this.DC.set(this.DB);
        RectF rectF = this.DC;
        rectF.left += f6;
        rectF.top += f6;
        rectF.right -= f6;
        rectF.bottom -= f6;
        a(rectF, this.DK);
        b(this.DC, this.DL);
        Path path = this.DN;
        if (path == null) {
            this.DN = new Path();
        } else {
            path.reset();
        }
        Path path2 = this.DO;
        if (path2 == null) {
            this.DO = new Path();
        } else {
            path2.reset();
        }
        a(this.DM, this.DN, this.DO, this.DC, this.DK, this.DL);
        canvas.drawPath(this.DM, this.mPaint);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i6, int i7) {
        super.onMeasure(i6, i7);
        if (this.DP) {
            if (getPaddingLeft() + getPaddingRight() + getPaint().measureText(getText().toString()) <= getMeasuredWidth()) {
                return;
            }
            setVisibility(8);
        }
    }

    public KSCouponLabelTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPaint = new Paint();
        this.DB = new Rect();
        this.DC = new RectF();
        this.DK = new RectF();
        this.DL = new RectF();
        this.DM = new Path();
        this.DF = new RectF();
        this.DP = true;
        a(context, attributeSet, 0);
    }

    @RequiresApi(api = 19)
    private void a(Path path, Path path2, Path path3, RectF rectF, RectF rectF2, RectF rectF3) {
        path.reset();
        float f6 = this.DH;
        path.addRoundRect(rectF, f6, f6, Path.Direction.CW);
        path2.addArc(rectF2, 90.0f, -180.0f);
        path3.addArc(rectF3, 90.0f, 180.0f);
        Path path4 = this.DN;
        Path.Op op = Path.Op.DIFFERENCE;
        path.op(path4, op);
        path.op(this.DO, op);
    }

    private void a(RectF rectF, RectF rectF2) {
        rectF2.set(rectF);
        float f6 = rectF2.left;
        float f7 = this.DJ;
        float f8 = f6 - f7;
        rectF2.left = f8;
        rectF2.right = f8 + (f7 * 2.0f);
        float height = rectF.height();
        float f9 = this.DJ;
        float f10 = rectF2.top + ((height - (f9 * 2.0f)) / 2.0f);
        rectF2.top = f10;
        rectF2.bottom = f10 + (f9 * 2.0f);
    }

    public KSCouponLabelTextView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.mPaint = new Paint();
        this.DB = new Rect();
        this.DC = new RectF();
        this.DK = new RectF();
        this.DL = new RectF();
        this.DM = new Path();
        this.DF = new RectF();
        this.DP = true;
        a(context, attributeSet, i6);
    }

    @Override // com.kwad.components.core.widget.d
    public final void a(e eVar) {
        int color = getResources().getColor(R.color.ksad_reward_main_color);
        this.strokeColor = color;
        setTextColor(color);
        lm();
        invalidate();
    }

    private void b(RectF rectF, RectF rectF2) {
        rectF2.set(rectF);
        float f6 = rectF2.right;
        float f7 = this.DJ;
        float f8 = f6 + f7;
        rectF2.right = f8;
        rectF2.left = f8 - (f7 * 2.0f);
        float height = rectF.height();
        float f9 = this.DJ;
        float f10 = rectF2.top + ((height - (f9 * 2.0f)) / 2.0f);
        rectF2.top = f10;
        rectF2.bottom = f10 + (f9 * 2.0f);
    }
}
