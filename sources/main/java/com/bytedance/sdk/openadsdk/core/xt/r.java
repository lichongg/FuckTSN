package com.bytedance.sdk.openadsdk.core.xt;

import android.content.Context;
import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.bytedance.sdk.openadsdk.core.p.g;
import com.bytedance.sdk.openadsdk.core.rn.v;
import com.bytedance.sdk.openadsdk.core.tj.qv;
import com.bytedance.sdk.openadsdk.core.tj.x;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class r implements View.OnClickListener, View.OnTouchListener {
    private static float cw = 0.0f;

    /* renamed from: g, reason: collision with root package name */
    protected static int f31357g = 8;

    /* renamed from: j, reason: collision with root package name */
    private static float f31358j;

    /* renamed from: r, reason: collision with root package name */
    private static float f31359r;
    private static long up;
    private static float xt;

    /* renamed from: m, reason: collision with root package name */
    protected final Context f31360m;
    protected qv ae = new qv();
    protected final com.bytedance.sdk.openadsdk.core.xt.j.r tl = new com.bytedance.sdk.openadsdk.core.xt.j.r();

    protected abstract void j(View view, qv qvVar);

    public void j(x xVar) {
    }

    public static class j {
        public double cw;

        /* renamed from: j, reason: collision with root package name */
        public int f31362j;

        /* renamed from: r, reason: collision with root package name */
        public long f31363r;
        public double xt;

        public j(int i6, double d6, double d7, long j6) {
            this.f31362j = i6;
            this.xt = d6;
            this.cw = d7;
            this.f31363r = j6;
        }
    }

    public <T extends com.bytedance.sdk.openadsdk.core.xt.j.j> T j(Class<T> cls) {
        return (T) this.tl.j(cls);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(final View view, MotionEvent motionEvent) {
        int i6;
        this.ae.cw(motionEvent.getDeviceId());
        this.ae.xt(motionEvent.getToolType(0));
        this.ae.r(motionEvent.getSource());
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.ae.up((int) motionEvent.getRawX());
            this.ae.m((int) motionEvent.getRawY());
            this.ae.j(motionEvent.getRawX());
            this.ae.xt(motionEvent.getRawY());
            this.ae.j(System.currentTimeMillis());
            this.ae.xt(motionEvent.getToolType(0));
            this.ae.cw(motionEvent.getDeviceId());
            this.ae.r(motionEvent.getSource());
            up = System.currentTimeMillis();
            this.ae.j(true);
            v.j(motionEvent);
            i6 = 0;
        } else if (actionMasked != 1) {
            i6 = 2;
            if (actionMasked == 2) {
                cw += Math.abs(motionEvent.getX() - f31358j);
                f31359r += Math.abs(motionEvent.getY() - xt);
                f31358j = motionEvent.getX();
                xt = motionEvent.getY();
                long currentTimeMillis = System.currentTimeMillis() - up;
                this.ae.cw(motionEvent.getRawX());
                this.ae.r(motionEvent.getRawY());
                if (Math.abs(this.ae.av() - this.ae.tl()) >= f31357g || Math.abs(this.ae.i() - this.ae.g()) >= f31357g) {
                    this.ae.j(false);
                }
                if (currentTimeMillis > 200) {
                    float f6 = cw;
                    int i7 = f31357g;
                    if (f6 > i7 || xt > i7) {
                        i6 = 1;
                    }
                }
            } else if (actionMasked != 3) {
                i6 = -1;
            } else {
                if (com.bytedance.sdk.component.adexpress.dynamic.xt.j.j(view) && com.bytedance.sdk.component.adexpress.dynamic.xt.j.xt(view)) {
                    view.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.xt.r.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (view.isShown()) {
                                r rVar = r.this;
                                rVar.j(view, rVar.ae);
                            }
                        }
                    });
                    return true;
                }
                i6 = 4;
            }
        } else {
            this.ae.cw(motionEvent.getRawX());
            this.ae.r(motionEvent.getRawY());
            if (Math.abs(this.ae.av() - this.ae.tl()) >= f31357g || Math.abs(this.ae.i() - this.ae.g()) >= f31357g) {
                this.ae.j(false);
            }
            this.ae.xt(System.currentTimeMillis());
            Context context = this.f31360m;
            if (context == null) {
                context = com.bytedance.sdk.openadsdk.core.v.getContext();
            }
            com.bytedance.sdk.openadsdk.core.xt.j.xt xtVar = (com.bytedance.sdk.openadsdk.core.xt.j.xt) j(com.bytedance.sdk.openadsdk.core.xt.j.xt.class);
            if (xtVar != null) {
                xtVar.j(this.ae);
            }
            if (com.bytedance.sdk.component.adexpress.dynamic.xt.j.j(view)) {
                if (com.bytedance.sdk.component.adexpress.dynamic.xt.j.j(view, this.ae.av(), this.ae.i(), this.ae.tl(), this.ae.g())) {
                    return false;
                }
                if (com.bytedance.sdk.component.adexpress.dynamic.xt.j.xt(view)) {
                    j(view, this.ae);
                }
                return true;
            }
            if (xtVar != null) {
                Point point = new Point((int) this.ae.av(), (int) this.ae.i());
                if (view != null && !xtVar.j(view, context) && xtVar.j((View) view.getParent(), point)) {
                    return true;
                }
            }
            i6 = 3;
        }
        this.ae.oq().put(motionEvent.getActionMasked(), new j(i6, motionEvent.getSize(), motionEvent.getPressure(), System.currentTimeMillis()));
        return false;
    }

    static {
        try {
            if (ViewConfiguration.get(com.bytedance.sdk.openadsdk.core.v.getContext()) != null) {
                f31357g = ViewConfiguration.get(com.bytedance.sdk.openadsdk.core.v.getContext()).getScaledTouchSlop();
            }
        } catch (Exception unused) {
        }
    }

    public r(Context context) {
        if (context == null) {
            this.f31360m = com.bytedance.sdk.openadsdk.core.v.getContext();
        } else {
            this.f31360m = context;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!g.j()) {
            return;
        }
        j(view, this.ae);
    }

    public void cw() {
    }

    public void r() {
    }

    public void up(int i6) {
    }
}
