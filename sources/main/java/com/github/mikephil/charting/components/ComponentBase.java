package com.github.mikephil.charting.components;

import android.graphics.Typeface;
import androidx.core.view.ViewCompat;
import com.github.mikephil.charting.utils.Utils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class ComponentBase {
    protected boolean mEnabled = true;
    protected float mXOffset = 5.0f;
    protected float mYOffset = 5.0f;
    protected Typeface mTypeface = null;
    protected float mTextSize = Utils.convertDpToPixel(10.0f);
    protected int mTextColor = ViewCompat.MEASURED_STATE_MASK;

    public int getTextColor() {
        return this.mTextColor;
    }

    public float getTextSize() {
        return this.mTextSize;
    }

    public Typeface getTypeface() {
        return this.mTypeface;
    }

    public float getXOffset() {
        return this.mXOffset;
    }

    public float getYOffset() {
        return this.mYOffset;
    }

    public boolean isEnabled() {
        return this.mEnabled;
    }

    public void setEnabled(boolean z5) {
        this.mEnabled = z5;
    }

    public void setTextColor(int i6) {
        this.mTextColor = i6;
    }

    public void setTextSize(float f6) {
        if (f6 > 24.0f) {
            f6 = 24.0f;
        }
        if (f6 < 6.0f) {
            f6 = 6.0f;
        }
        this.mTextSize = Utils.convertDpToPixel(f6);
    }

    public void setTypeface(Typeface typeface) {
        this.mTypeface = typeface;
    }

    public void setXOffset(float f6) {
        this.mXOffset = Utils.convertDpToPixel(f6);
    }

    public void setYOffset(float f6) {
        this.mYOffset = Utils.convertDpToPixel(f6);
    }
}
