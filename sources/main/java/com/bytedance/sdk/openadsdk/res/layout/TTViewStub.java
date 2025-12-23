package com.bytedance.sdk.openadsdk.res.layout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.lang.ref.WeakReference;

/* loaded from: D:\Downloads\app\classes4.dex */
public final class TTViewStub extends View {
    private Context cw;

    /* renamed from: j, reason: collision with root package name */
    private WeakReference<View> f31824j;

    /* renamed from: r, reason: collision with root package name */
    private j f31825r;
    private com.bytedance.sdk.openadsdk.res.layout.j xt;

    public interface j {
    }

    public View j() {
        ViewParent parent = getParent();
        if (parent == null || !(parent instanceof ViewGroup)) {
            throw new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
        }
        com.bytedance.sdk.openadsdk.res.layout.j jVar = this.xt;
        if (jVar == null) {
            throw new IllegalArgumentException("ViewStub must have a valid layoutResource");
        }
        View xt = jVar.xt(this.cw);
        j(xt, (ViewGroup) parent);
        this.f31824j = new WeakReference<>(xt);
        return xt;
    }

    @Override // android.view.View
    protected void onMeasure(int i6, int i7) {
        setMeasuredDimension(0, 0);
    }

    public void setOnInflateListener(j jVar) {
        this.f31825r = jVar;
    }

    @Override // android.view.View
    public void setVisibility(int i6) {
        WeakReference<View> weakReference = this.f31824j;
        if (weakReference != null) {
            View view = weakReference.get();
            if (view == null) {
                throw new IllegalStateException("setVisibility called on un-referenced view");
            }
            view.setVisibility(i6);
            return;
        }
        super.setVisibility(i6);
        if (i6 == 0 || i6 == 4) {
            j();
        }
    }

    public TTViewStub(Context context, com.bytedance.sdk.openadsdk.res.layout.j jVar) {
        super(context);
        this.cw = context;
        this.xt = jVar;
        setVisibility(8);
    }

    private void j(View view, ViewGroup viewGroup) {
        int indexOfChild = viewGroup.indexOfChild(this);
        viewGroup.removeViewInLayout(this);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            viewGroup.addView(view, indexOfChild, layoutParams);
        } else {
            viewGroup.addView(view, indexOfChild);
        }
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
    }

    @Override // android.view.View
    @SuppressLint({"MissingSuperCall"})
    public void draw(Canvas canvas) {
    }
}
