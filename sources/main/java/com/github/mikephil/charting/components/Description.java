package com.github.mikephil.charting.components;

import android.graphics.Paint;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class Description extends ComponentBase {
    private MPPointF mPosition;
    private String text = "Description Label";
    private Paint.Align mTextAlign = Paint.Align.RIGHT;

    public MPPointF getPosition() {
        return this.mPosition;
    }

    public String getText() {
        return this.text;
    }

    public Paint.Align getTextAlign() {
        return this.mTextAlign;
    }

    public void setPosition(float f6, float f7) {
        MPPointF mPPointF = this.mPosition;
        if (mPPointF == null) {
            this.mPosition = MPPointF.getInstance(f6, f7);
        } else {
            mPPointF.f32565x = f6;
            mPPointF.f32566y = f7;
        }
    }

    public void setText(String str) {
        this.text = str;
    }

    public void setTextAlign(Paint.Align align) {
        this.mTextAlign = align;
    }

    public Description() {
        this.mTextSize = Utils.convertDpToPixel(8.0f);
    }
}
