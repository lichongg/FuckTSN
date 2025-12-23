package com.kwad.sdk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class RatioFrameLayout extends FrameLayout {
    private double avY;

    public RatioFrameLayout(@NonNull Context context) {
        this(context, null);
    }

    public RatioFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public double getRatio() {
        return this.avY;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i6, int i7) {
        if (this.avY != 0.0d) {
            i7 = View.MeasureSpec.makeMeasureSpec((int) (View.MeasureSpec.getSize(i6) * this.avY), 1073741824);
        }
        super.onMeasure(i6, i7);
    }

    public void setRatio(double d6) {
        this.avY = d6;
    }

    public RatioFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.avY = 0.0d;
    }
}
