package com.scwang.smartrefresh.layout.header;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.util.c;
import m2.e;
import m2.g;
import m2.h;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class FalsifyHeader extends View implements e {

    /* renamed from: a, reason: collision with root package name */
    protected g f37394a;

    public FalsifyHeader(Context context) {
        super(context);
    }

    public int d(h hVar, boolean z5) {
        return 0;
    }

    public boolean j() {
        return false;
    }

    public FalsifyHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // m2.f
    public SpinnerStyle getSpinnerStyle() {
        return SpinnerStyle.Translate;
    }

    public void q(g gVar, int i6, int i7) {
        this.f37394a = gVar;
    }

    public void w(h hVar, int i6, int i7) {
        g gVar = this.f37394a;
        if (gVar != null) {
            gVar.e(RefreshState.None);
            this.f37394a.e(RefreshState.RefreshFinish);
        }
    }

    public FalsifyHeader(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation", "SetTextI18n"})
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isInEditMode()) {
            int b6 = c.b(5.0f);
            Paint paint = new Paint();
            paint.setStyle(Paint.Style.STROKE);
            paint.setColor(1157627903);
            paint.setStrokeWidth(c.b(1.0f));
            float f6 = b6;
            paint.setPathEffect(new DashPathEffect(new float[]{f6, f6, f6, f6}, 1.0f));
            canvas.drawRect(f6, f6, getWidth() - b6, getBottom() - b6, paint);
            TextView textView = new TextView(getContext());
            textView.setText(getClass().getSimpleName() + " 虚假区域\n运行时代表下拉Header的高度【" + c.d(getHeight()) + "dp】\n而不会显示任何东西");
            textView.setTextColor(1157627903);
            textView.setGravity(17);
            textView.measure(View.MeasureSpec.makeMeasureSpec(getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getHeight(), 1073741824));
            textView.layout(0, 0, getWidth(), getHeight());
            textView.draw(canvas);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i6, int i7) {
        setMeasuredDimension(View.resolveSize(getSuggestedMinimumWidth(), i6), View.resolveSize(getSuggestedMinimumHeight(), i7));
    }

    @RequiresApi(21)
    public FalsifyHeader(Context context, @Nullable AttributeSet attributeSet, int i6, int i7) {
        super(context, attributeSet, i6, i7);
    }

    @Override // m2.f
    @NonNull
    public View getView() {
        return this;
    }

    @Deprecated
    public void setPrimaryColors(@ColorInt int... iArr) {
    }

    public void h(h hVar, int i6, int i7) {
    }

    public void i(float f6, int i6, int i7) {
    }

    public void x(h hVar, RefreshState refreshState, RefreshState refreshState2) {
    }

    public void g(float f6, int i6, int i7, int i8) {
    }

    public void y(float f6, int i6, int i7, int i8) {
    }
}
