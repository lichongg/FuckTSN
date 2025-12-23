package com.github.mikephil.charting.components;

import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import com.github.mikephil.charting.utils.Utils;
import org.apache.commons.net.telnet.f;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class LimitLine extends ComponentBase {
    private DashPathEffect mDashPathEffect;
    private String mLabel;
    private LimitLabelPosition mLabelPosition;
    private float mLimit;
    private int mLineColor;
    private float mLineWidth;
    private Paint.Style mTextStyle;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum LimitLabelPosition {
        LEFT_TOP,
        LEFT_BOTTOM,
        RIGHT_TOP,
        RIGHT_BOTTOM
    }

    public LimitLine(float f6) {
        this.mLimit = 0.0f;
        this.mLineWidth = 2.0f;
        this.mLineColor = Color.rgb(f.f51104t, 91, 91);
        this.mTextStyle = Paint.Style.FILL_AND_STROKE;
        this.mLabel = "";
        this.mDashPathEffect = null;
        this.mLabelPosition = LimitLabelPosition.RIGHT_TOP;
        this.mLimit = f6;
    }

    public void disableDashedLine() {
        this.mDashPathEffect = null;
    }

    public void enableDashedLine(float f6, float f7, float f8) {
        this.mDashPathEffect = new DashPathEffect(new float[]{f6, f7}, f8);
    }

    public DashPathEffect getDashPathEffect() {
        return this.mDashPathEffect;
    }

    public String getLabel() {
        return this.mLabel;
    }

    public LimitLabelPosition getLabelPosition() {
        return this.mLabelPosition;
    }

    public float getLimit() {
        return this.mLimit;
    }

    public int getLineColor() {
        return this.mLineColor;
    }

    public float getLineWidth() {
        return this.mLineWidth;
    }

    public Paint.Style getTextStyle() {
        return this.mTextStyle;
    }

    public boolean isDashedLineEnabled() {
        return this.mDashPathEffect != null;
    }

    public void setLabel(String str) {
        this.mLabel = str;
    }

    public void setLabelPosition(LimitLabelPosition limitLabelPosition) {
        this.mLabelPosition = limitLabelPosition;
    }

    public void setLineColor(int i6) {
        this.mLineColor = i6;
    }

    public void setTextStyle(Paint.Style style) {
        this.mTextStyle = style;
    }

    public void setLineWidth(float f6) {
        if (f6 < 0.2f) {
            f6 = 0.2f;
        }
        if (f6 > 12.0f) {
            f6 = 12.0f;
        }
        this.mLineWidth = Utils.convertDpToPixel(f6);
    }

    public LimitLine(float f6, String str) {
        this.mLimit = 0.0f;
        this.mLineWidth = 2.0f;
        this.mLineColor = Color.rgb(f.f51104t, 91, 91);
        this.mTextStyle = Paint.Style.FILL_AND_STROKE;
        this.mLabel = "";
        this.mDashPathEffect = null;
        this.mLabelPosition = LimitLabelPosition.RIGHT_TOP;
        this.mLimit = f6;
        this.mLabel = str;
    }
}
