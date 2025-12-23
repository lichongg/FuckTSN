package com.bytedance.sdk.openadsdk.res.layout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bytedance.sdk.component.utils.tl;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.l.ae;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\Downloads\app\classes4.dex */
public class LazeLayout<T extends View> extends View {
    private View.OnTouchListener ae;
    private j cw;

    /* renamed from: j, reason: collision with root package name */
    private volatile com.bytedance.sdk.openadsdk.res.layout.j<T> f31818j;

    /* renamed from: m, reason: collision with root package name */
    private View.OnClickListener f31819m;

    /* renamed from: r, reason: collision with root package name */
    private AtomicBoolean f31820r;
    private T tl;
    private AtomicBoolean up;
    private volatile Context xt;

    public interface j<T extends View> {
        void j(T t5);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f31819m = onClickListener;
    }

    @Override // android.view.View
    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.ae = onTouchListener;
    }

    public LazeLayout(Context context, com.bytedance.sdk.openadsdk.res.layout.j jVar, j jVar2) {
        super(context);
        this.f31820r = new AtomicBoolean(false);
        this.up = new AtomicBoolean(false);
        this.f31818j = jVar;
        this.xt = context;
        this.cw = jVar2;
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.up.set(true);
        if (this.f31820r.get()) {
            return;
        }
        this.f31820r.set(true);
        T t5 = this.tl;
        if (t5 != null) {
            j((LazeLayout<T>) t5, getParent());
        } else {
            tl.cw().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.res.layout.LazeLayout.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        LazeLayout lazeLayout = LazeLayout.this;
                        lazeLayout.tl = lazeLayout.f31818j.xt(LazeLayout.this.xt);
                        if (LazeLayout.this.tl == null) {
                            return;
                        }
                        LazeLayout lazeLayout2 = LazeLayout.this;
                        lazeLayout2.j((LazeLayout) lazeLayout2.tl, LazeLayout.this.getParent());
                    } catch (Exception e6) {
                        vl.xt("LazeLayout", "inflate error", e6);
                    }
                }
            });
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.up.set(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(final T t5, final ViewParent viewParent) {
        if (t5 == null) {
            return;
        }
        if (viewParent == null) {
            if (this.up.get()) {
                tl.cw().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.res.layout.LazeLayout.2
                    @Override // java.lang.Runnable
                    public void run() {
                        LazeLayout lazeLayout = LazeLayout.this;
                        lazeLayout.j((LazeLayout) t5, lazeLayout.getParent());
                    }
                }, 50L);
                return;
            } else {
                this.f31820r.set(false);
                return;
            }
        }
        if (viewParent instanceof ViewGroup) {
            ae.j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.res.layout.LazeLayout.3
                @Override // java.lang.Runnable
                public void run() {
                    if (LazeLayout.this.up.get()) {
                        LazeLayout.this.j((LazeLayout) t5, (ViewGroup) viewParent);
                    } else {
                        LazeLayout.this.f31820r.set(false);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(T t5, ViewGroup viewGroup) {
        int indexOfChild = viewGroup.indexOfChild(this);
        viewGroup.removeViewInLayout(this);
        this.xt = null;
        this.f31818j = null;
        ViewParent parent = t5.getParent();
        if (parent != null) {
            ((ViewGroup) parent).removeView(t5);
        }
        View.OnClickListener onClickListener = this.f31819m;
        if (onClickListener != null) {
            t5.setOnClickListener(onClickListener);
        }
        View.OnTouchListener onTouchListener = this.ae;
        if (onTouchListener != null) {
            t5.setOnTouchListener(onTouchListener);
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            viewGroup.addView(t5, indexOfChild, layoutParams);
        } else {
            viewGroup.addView(t5, indexOfChild);
        }
        j jVar = this.cw;
        if (jVar != null) {
            jVar.j(t5);
        }
        this.tl = null;
    }

    public void j() {
        this.tl = null;
        this.f31818j = null;
        this.xt = null;
        this.cw = null;
    }

    @Override // android.view.View
    @SuppressLint({"MissingSuperCall"})
    public void draw(Canvas canvas) {
    }
}
