package com.kwad.components.core.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.kwad.sdk.R;
import com.kwad.sdk.widget.j;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SuppressLint({"AppCompatCustomView"})
/* loaded from: D:\Downloads\app\classes6.dex */
public class KSCornerButton extends Button {
    private j mViewRCHelper;

    public KSCornerButton(Context context) {
        super(context);
        a(context, null);
    }

    private void a(Context context, @Nullable AttributeSet attributeSet) {
        j.a aVar = new j.a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_KSCornerImageView);
        aVar.cp(obtainStyledAttributes.getBoolean(R.styleable.ksad_KSCornerImageView_ksad_leftTopCorner, true));
        aVar.cq(obtainStyledAttributes.getBoolean(R.styleable.ksad_KSCornerImageView_ksad_topRightCorner, true));
        aVar.cr(obtainStyledAttributes.getBoolean(R.styleable.ksad_KSCornerImageView_ksad_rightBottomCorner, true));
        aVar.cs(obtainStyledAttributes.getBoolean(R.styleable.ksad_KSCornerImageView_ksad_bottomLeftCorner, true));
        obtainStyledAttributes.recycle();
        j jVar = new j(aVar);
        this.mViewRCHelper = jVar;
        jVar.initAttrs(context, attributeSet);
    }

    @Override // android.view.View
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

    @NonNull
    public j.a getCornerConf() {
        return this.mViewRCHelper.getCornerConf();
    }

    public void setRadius(float f6) {
        this.mViewRCHelper.setRadius(f6);
        postInvalidate();
    }

    public KSCornerButton(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i6, int i7, int i8, int i9) {
        super.onSizeChanged(i6, i7, i8, i9);
        this.mViewRCHelper.onSizeChanged(i6, i7);
    }

    public KSCornerButton(Context context, @Nullable AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        a(context, attributeSet);
    }

    @RequiresApi(api = 21)
    public KSCornerButton(Context context, @Nullable AttributeSet attributeSet, int i6, int i7) {
        super(context, attributeSet, i6, i7);
        a(context, attributeSet);
    }
}
