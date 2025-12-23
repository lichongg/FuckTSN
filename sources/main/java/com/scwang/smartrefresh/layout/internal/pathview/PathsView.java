package com.scwang.smartrefresh.layout.internal.pathview;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class PathsView extends View {

    /* renamed from: a, reason: collision with root package name */
    protected b f37446a;

    public PathsView(Context context) {
        super(context);
        this.f37446a = new b();
        a(context, null, 0);
    }

    private void a(Context context, AttributeSet attributeSet, int i6) {
        this.f37446a = new b();
    }

    public void b(int... iArr) {
        this.f37446a.h(iArr);
    }

    public void c(String... strArr) {
        this.f37446a.i(strArr);
    }

    @Override // android.view.View
    protected void onMeasure(int i6, int i7) {
        setMeasuredDimension(View.resolveSize(this.f37446a.n() + getPaddingLeft() + getPaddingRight(), i6), View.resolveSize(this.f37446a.f() + getPaddingTop() + getPaddingBottom(), i7));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f37446a.draw(canvas);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (getTag() instanceof String) {
            c(getTag().toString());
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        super.onLayout(z5, i6, i7, i8, i9);
        this.f37446a.setBounds(getPaddingLeft(), getPaddingTop(), Math.max((i8 - i6) - getPaddingRight(), getPaddingLeft()), Math.max((i9 - i7) - getPaddingTop(), getPaddingTop()));
    }

    public PathsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f37446a = new b();
        a(context, attributeSet, 0);
    }

    public PathsView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f37446a = new b();
        a(context, attributeSet, i6);
    }
}
