package com.kwad.components.ad.reward.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.kwad.sdk.R;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SuppressLint({"AppCompatCustomView"})
/* loaded from: D:\Downloads\app\classes6.dex */
public class KsShadowImageView extends ImageView {
    private Paint DT;
    private BlurMaskFilter DU;
    private int DV;
    private boolean DW;
    private boolean DX;
    private boolean DY;
    private boolean DZ;
    private Rect Ea;

    @ColorInt
    private int Eb;

    public KsShadowImageView(Context context) {
        super(context);
        this.DZ = true;
        a(context, null, 0);
    }

    private void a(Context context, @Nullable AttributeSet attributeSet, int i6) {
        this.DT = new Paint();
        this.DU = new BlurMaskFilter(50.0f, BlurMaskFilter.Blur.OUTER);
        this.Ea = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_KsShadowImageView, i6, 0);
        this.DV = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ksad_KsShadowImageView_ksad_shadowSize, 20);
        this.Eb = obtainStyledAttributes.getColor(R.styleable.ksad_KsShadowImageView_ksad_shadowColor, Color.parseColor("#33000000"));
        this.DW = obtainStyledAttributes.getBoolean(R.styleable.ksad_KsShadowImageView_ksad_enableLeftShadow, true);
        this.DX = obtainStyledAttributes.getBoolean(R.styleable.ksad_KsShadowImageView_ksad_enableRightShadow, true);
        this.DY = obtainStyledAttributes.getBoolean(R.styleable.ksad_KsShadowImageView_ksad_enableTopShadow, true);
        this.DZ = obtainStyledAttributes.getBoolean(R.styleable.ksad_KsShadowImageView_ksad_enableBottomShadow, true);
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        int i6;
        int i7;
        int i8;
        super.onDraw(canvas);
        this.DT.setMaskFilter(this.DU);
        this.DT.setColor(this.Eb);
        this.DT.setStyle(Paint.Style.FILL);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        Rect rect = this.Ea;
        int i9 = 0;
        if (this.DW) {
            i6 = this.DV;
        } else {
            i6 = 0;
        }
        rect.left = i6;
        if (this.DY) {
            i7 = this.DV;
        } else {
            i7 = 0;
        }
        rect.top = i7;
        if (this.DX) {
            i8 = this.DV;
        } else {
            i8 = 0;
        }
        rect.right = measuredWidth - i8;
        if (this.DZ) {
            i9 = this.DV;
        }
        rect.bottom = measuredHeight - i9;
        canvas.drawRect(rect, this.DT);
    }

    public KsShadowImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.DZ = true;
        a(context, attributeSet, 0);
    }

    public KsShadowImageView(Context context, @Nullable AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.DZ = true;
        a(context, attributeSet, i6);
    }

    @RequiresApi(api = 21)
    public KsShadowImageView(Context context, @Nullable AttributeSet attributeSet, int i6, int i7) {
        super(context, attributeSet, i6, i7);
        this.DZ = true;
        a(context, attributeSet, i6);
    }
}
