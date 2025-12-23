package com.acse.ottn;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class b0 extends View implements p1 {

    /* renamed from: a, reason: collision with root package name */
    public q1 f4237a;

    /* renamed from: b, reason: collision with root package name */
    public Paint f4238b;

    /* renamed from: c, reason: collision with root package name */
    public float f4239c;

    public b0(Context context) {
        this(context, null);
    }

    public b0(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // com.acse.ottn.p1
    public void a(int i6, int i7) {
        this.f4237a.d(i6);
        this.f4237a.a(i7);
        requestLayout();
    }

    @Override // com.acse.ottn.p1
    public q1 getIndicatorConfig() {
        return this.f4237a;
    }

    @Override // com.acse.ottn.p1
    @NonNull
    public View getIndicatorView() {
        if (this.f4237a.l()) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            int b6 = this.f4237a.b();
            if (b6 == 0) {
                layoutParams.gravity = 8388691;
            } else if (b6 == 1) {
                layoutParams.gravity = 81;
            } else if (b6 == 2) {
                layoutParams.gravity = 8388693;
            }
            layoutParams.leftMargin = this.f4237a.f().f5021a;
            layoutParams.rightMargin = this.f4237a.f().f5023c;
            layoutParams.topMargin = this.f4237a.f().f5022b;
            layoutParams.bottomMargin = this.f4237a.f().f5024d;
            setLayoutParams(layoutParams);
        }
        return this;
    }

    @Override // com.acse.ottn.y2
    public void onPageScrolled(int i6, float f6, int i7) {
        this.f4239c = f6;
        invalidate();
    }

    @Override // com.acse.ottn.y2
    public void onPageSelected(int i6) {
        this.f4237a.a(i6);
        invalidate();
    }

    public b0(Context context, @Nullable AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f4237a = new q1();
        Paint paint = new Paint();
        this.f4238b = paint;
        paint.setAntiAlias(true);
        this.f4238b.setColor(this.f4237a.g());
    }

    @Override // com.acse.ottn.y2
    public void onPageScrollStateChanged(int i6) {
    }
}
