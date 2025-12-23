package com.kwad.sdk.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aj;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class KSLinearLayout extends LinearLayout implements k {
    private final aj.a aLL;
    private final AtomicBoolean bR;
    private i bdg;
    private k bdh;
    private float mRatio;
    private j mViewRCHelper;

    public KSLinearLayout(@NonNull Context context) {
        super(context);
        this.bR = new AtomicBoolean(true);
        this.mRatio = 0.0f;
        this.aLL = new aj.a();
        init(context, null);
    }

    @CallSuper
    private void aa() {
        this.bdg.onAttachedToWindow();
    }

    @CallSuper
    private void ab() {
        this.bdg.onDetachedFromWindow();
    }

    private void init(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        if (attributeSet != null) {
            int i6 = R.attr.ksad_ratio;
            int[] iArr = {i6};
            Arrays.sort(iArr);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
            this.mRatio = obtainStyledAttributes.getFloat(Arrays.binarySearch(iArr, i6), 0.0f);
            obtainStyledAttributes.recycle();
        }
        i iVar = new i(this, this);
        this.bdg = iVar;
        iVar.co(true);
        j jVar = new j();
        this.mViewRCHelper = jVar;
        jVar.initAttrs(context, attributeSet);
    }

    private void vX() {
        if (this.bR.getAndSet(false)) {
            aa();
        }
    }

    private void vY() {
        if (this.bR.getAndSet(true)) {
            return;
        }
        ab();
    }

    @Override // com.kwad.sdk.widget.k
    @CallSuper
    public final void E(View view) {
        k kVar = this.bdh;
        if (kVar != null) {
            kVar.E(view);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        this.mViewRCHelper.beforeDispatchDraw(canvas);
        try {
            super.dispatchDraw(canvas);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
        this.mViewRCHelper.afterDispatchDraw(canvas);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        this.mViewRCHelper.beforeDraw(canvas);
        super.draw(canvas);
        this.mViewRCHelper.afterDraw(canvas);
    }

    @MainThread
    public aj.a getTouchCoords() {
        return this.aLL;
    }

    public float getVisiblePercent() {
        return this.bdg.getVisiblePercent();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i6, int i7) {
        if (this.mRatio != 0.0f) {
            i7 = View.MeasureSpec.makeMeasureSpec((int) (View.MeasureSpec.getSize(i6) * this.mRatio), 1073741824);
        }
        super.onMeasure(i6, i7);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i6, int i7, int i8, int i9) {
        this.bdg.b(i6, i7, i8, i9);
        super.onSizeChanged(i6, i7, i8, i9);
        this.bdg.SP();
        this.mViewRCHelper.onSizeChanged(i6, i7);
    }

    public void setRadius(float f6) {
        this.mViewRCHelper.setRadius(f6);
        postInvalidate();
    }

    public void setRatio(float f6) {
        this.mRatio = f6;
    }

    public void setViewVisibleListener(k kVar) {
        this.bdh = kVar;
    }

    public void setVisiblePercent(float f6) {
        this.bdg.setVisiblePercent(f6);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1) {
                this.aLL.f(motionEvent.getX(), motionEvent.getY());
            }
        } else {
            this.aLL.B(getWidth(), getHeight());
            this.aLL.e(motionEvent.getX(), motionEvent.getY());
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    @Deprecated
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        vX();
    }

    @Override // android.view.ViewGroup, android.view.View
    @Deprecated
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        vY();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        vX();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        vY();
    }

    public KSLinearLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bR = new AtomicBoolean(true);
        this.mRatio = 0.0f;
        this.aLL = new aj.a();
        init(context, attributeSet);
    }

    public KSLinearLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.bR = new AtomicBoolean(true);
        this.mRatio = 0.0f;
        this.aLL = new aj.a();
        init(context, attributeSet);
    }
}
