package com.scwang.smartrefresh.layout.footer;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.header.FalsifyHeader;
import com.scwang.smartrefresh.layout.util.c;
import m2.d;
import m2.g;
import m2.h;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class FalsifyFooter extends FalsifyHeader implements d {
    public FalsifyFooter(Context context) {
        super(context);
    }

    @Override // m2.d
    public boolean b(boolean z5) {
        return false;
    }

    public FalsifyFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // m2.d
    public void k(h hVar, int i6, int i7) {
        g gVar = this.f37394a;
        if (gVar != null) {
            gVar.e(RefreshState.None);
            this.f37394a.e(RefreshState.LoadFinish);
        }
    }

    public FalsifyFooter(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
    }

    @Override // com.scwang.smartrefresh.layout.header.FalsifyHeader, android.view.View
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
            textView.setText(getClass().getSimpleName() + " 虚假区域\n运行时代表上拉Footer的高度【" + c.d(getHeight()) + "dp】\n而不会显示任何东西");
            textView.setTextColor(1157627903);
            textView.setGravity(17);
            textView.measure(View.MeasureSpec.makeMeasureSpec(getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getHeight(), 1073741824));
            textView.layout(0, 0, getWidth(), getHeight());
            textView.draw(canvas);
        }
    }

    @Override // com.scwang.smartrefresh.layout.header.FalsifyHeader, m2.f
    public void q(g gVar, int i6, int i7) {
        super.q(gVar, i6, i7);
        gVar.c().V(false);
    }

    @RequiresApi(21)
    public FalsifyFooter(Context context, @Nullable AttributeSet attributeSet, int i6, int i7) {
        super(context, attributeSet, i6, i7);
    }

    @Override // m2.d
    public void c(float f6, int i6, int i7, int i8) {
    }

    @Override // m2.d
    public void v(float f6, int i6, int i7, int i8) {
    }
}
