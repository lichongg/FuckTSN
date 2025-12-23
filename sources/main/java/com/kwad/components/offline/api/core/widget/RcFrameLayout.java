package com.kwad.components.offline.api.core.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.offline.api.core.utils.TkViewRCHelper;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class RcFrameLayout extends FrameLayout {
    private float mRatio;
    private TkViewRCHelper mViewRCHelper;
    private boolean widthBasedRatio;

    public RcFrameLayout(@NonNull Context context) {
        super(context);
        this.mRatio = 0.0f;
        this.widthBasedRatio = true;
        init(context, null);
    }

    protected boolean enableFirstVisible() {
        return true;
    }

    public void setRadius(float f6) {
        this.mViewRCHelper.setRadius(f6);
        postInvalidate();
    }

    private float[] getRadius(float f6, float f7, float f8, float f9) {
        return new float[]{f6, f6, f7, f7, f8, f8, f9, f9};
    }

    private void init(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        TkViewRCHelper tkViewRCHelper = new TkViewRCHelper();
        this.mViewRCHelper = tkViewRCHelper;
        tkViewRCHelper.initAttrs(context, attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        this.mViewRCHelper.beforeDispatchDraw(canvas);
        super.dispatchDraw(canvas);
        this.mViewRCHelper.afterDispatchDraw(canvas);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        this.mViewRCHelper.beforeDraw(canvas);
        super.draw(canvas);
        this.mViewRCHelper.afterDraw(canvas);
    }

    public boolean isWidthBasedRatio() {
        return this.widthBasedRatio;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i6, int i7) {
        if (this.mRatio != 0.0f) {
            if (this.widthBasedRatio) {
                i7 = View.MeasureSpec.makeMeasureSpec((int) (View.MeasureSpec.getSize(i6) * this.mRatio), 1073741824);
            } else {
                i6 = View.MeasureSpec.makeMeasureSpec((int) (View.MeasureSpec.getSize(i7) / this.mRatio), 1073741824);
            }
        }
        super.onMeasure(i6, i7);
    }

    public void setRatio(float f6) {
        this.mRatio = f6;
    }

    public void setWidthBasedRatio(boolean z5) {
        this.widthBasedRatio = z5;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i6, int i7, int i8, int i9) {
        super.onSizeChanged(i6, i7, i8, i9);
        this.mViewRCHelper.onSizeChanged(i6, i7);
    }

    public void setRadius(float f6, float f7, float f8, float f9) {
        this.mViewRCHelper.setRadius(getRadius(f6, f7, f8, f9));
        postInvalidate();
    }

    public RcFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRatio = 0.0f;
        this.widthBasedRatio = true;
        init(context, null);
    }

    public RcFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.mRatio = 0.0f;
        this.widthBasedRatio = true;
        init(context, null);
    }
}
